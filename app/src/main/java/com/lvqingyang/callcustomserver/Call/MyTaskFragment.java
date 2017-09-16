package com.lvqingyang.callcustomserver.Call;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lvqingyang.callcustomserver.Base.BaseFragment;
import com.lvqingyang.callcustomserver.BuildConfig;
import com.lvqingyang.callcustomserver.R;
import com.lvqingyang.callcustomserver.bean.ServerOrder;
import com.lvqingyang.callcustomserver.bean.User;
import com.lvqingyang.callcustomserver.net.RequestHelper;
import com.lvqingyang.callcustomserver.net.RequestListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import frame.tool.DialogUtil;
import frame.tool.MyPrefence;
import frame.tool.MyToast;
import frame.tool.SolidRVBaseAdapter;
import frame.view.CircleTextView;

/**
 * Author：LvQingYang
 * Date：2017/9/1
 * Email：biloba12345@gamil.com
 * Github：https://github.com/biloba123
 * Info：
 */
public class MyTaskFragment extends BaseFragment {

    private Toolbar toolbar;
    private RecyclerView rvcall;
    private SwipeRefreshLayout srl;
    private List<ServerOrder> mOrderList=new ArrayList<>();
    private List<ServerOrder> mOrderListTemp=new ArrayList<>();
    private Spinner sp;
    private List<String> mTaskTypes=new ArrayList<>();
    private SolidRVBaseAdapter mAdapter;
    private ArrayAdapter mSpAdapter;
    private Gson mGson=new Gson();
    private User mUser;
    private static final String TAG = "MyTaskFragment";

    public static MyTaskFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MyTaskFragment fragment = new MyTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_call,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        this.srl = (SwipeRefreshLayout) view.findViewById(R.id.srl);
        this.rvcall = (RecyclerView) view.findViewById(R.id.rv_call);
        this.toolbar =  view.findViewById(R.id.toolbar);
        initToolbar(toolbar, getString(R.string.my_task),false);

        this.sp = (Spinner) view.findViewById(R.id.sp);
    }

    @Override
    protected void setListener() {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getMyTasks();
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (BuildConfig.DEBUG) Log.d(TAG, "onItemSelected: "+i);
                mOrderList.clear();
                if (i==0) {
                    mOrderList.addAll(mOrderListTemp);
                }else {
                    for (ServerOrder serverOrder : mOrderListTemp) {
                        if (serverOrder.getOrder().getOrderType()==i) {
                            mOrderList.add(serverOrder);
                        }
                    }
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void initData() {
        mTaskTypes.add(0,"全部任务");
        mTaskTypes.addAll(Arrays.asList(getResources().getStringArray(R.array.type_task)));
        mAdapter=new SolidRVBaseAdapter<ServerOrder>(getContext(), mOrderList) {
            @Override
            protected void onBindDataToView(final SolidCommonViewHolder holder, final ServerOrder bean) {
                ((CircleTextView)holder.getView(R.id.ctv_type))
                        .text(mTaskTypes.get(bean.getOrder().getOrderType()))
                        .bgColor(getResources().getColor(mColorArr[bean.getOrder().getOrderType()-1]))
                        .paint();
                holder.setText(R.id.tv_name,bean.getOrder().getOrderName());
                holder.setText(R.id.tv_total,bean.getCallCount()+"");
                holder.setText(R.id.tv_price,bean.getOrder().getUnitPrice()+"");
                if (bean.getFinishCount()>bean.getCallCount()) {
                    holder.setText(R.id.tv_complete,bean.getCallCount()+"");
                }else {
                    holder.setText(R.id.tv_complete,bean.getFinishCount()+"");
                }
                if (BuildConfig.DEBUG) Log.d(TAG, "onBindDataToView: getFinishCount"+bean.getFinishCount());

                ((ProgressBar)holder.getView(R.id.pb)).setProgress((int) (bean.getFinishCount()*1f/bean.getCallCount()*100));

                //state
                TextView tvState=holder.getView(R.id.tv_state);
                ImageView ivSync=holder.getView(R.id.iv_sync);
                switch (bean.getState()) {
                    case 0:
                        tvState.setVisibility(View.GONE);
                        ivSync.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        ivSync.setVisibility(View.GONE);
                        tvState.setVisibility(View.VISIBLE);
                        tvState.setText("待结算");
                        tvState.setBackgroundResource(R.drawable.bg_task_uncheck);
                        break;
                    case 2:
                        ivSync.setVisibility(View.GONE);
                        tvState.setVisibility(View.VISIBLE);
                        tvState.setText("已完成");
                        tvState.setBackgroundResource(R.drawable.bg_task_complete);
                        break;
                }

                holder.getView(R.id.iv_sync).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        if (view.getAnimation()==null) {
                            Animation animation= AnimationUtils.loadAnimation(getContext(), R.anim.rotate);
                            view.startAnimation(animation);
                            RequestHelper.asyncServerOrder(getActivity(), bean.getId(), new RequestListener() {
                                @Override
                                public void onResponse(String res) {
                                    view.clearAnimation();
                                    if (TextUtils.equals(res,"1")) {
                                        getMyTasks();
                                    }else{
                                        MyToast.error(getContext(), R.string.async_fail);
                                    }
                                }

                                @Override
                                public void onError() {
                                    view.clearAnimation();
                                    MyToast.error(getContext(), R.string.async_fail);
                                }
                            });
                        }else {
                            MyToast.info(getContext(), R.string.asyncing);
                        }

                    }
                });
            }

            @Override
            public int getItemLayoutID(int viewType) {
                return R.layout.item_my_task;
            }

            @Override
            protected void onItemClick(int position, ServerOrder bean) {
                super.onItemClick(position, bean);
                DialogUtil.getMesDialog(getContext(), "传统呼叫平台",
                        "账户名："+bean.getCallPlatform().getUsername()+"\n" +
                                "密码："+bean.getCallPlatform().getPassword()+"\n" +
                                "平台地址："+bean.getCallPlatform().getApiUrl())
                        .show();
            }
        };

        mSpAdapter=new ArrayAdapter<String>
                (getContext(), R.layout.item_sp, mTaskTypes);
    }

    @Override
    protected void setData() {
        mUser=MyPrefence.getInstance(getContext()).getUser(User.class);
        rvcall.setLayoutManager(new LinearLayoutManager(getContext()));
        rvcall.setAdapter(mAdapter);

        sp.setAdapter(mSpAdapter);

        srl.setRefreshing(true);
        getMyTasks();
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    private void getMyTasks(){
        RequestHelper.getMyTasks(getActivity(),mUser.getServerID(), new RequestListener() {
            @Override
            public void onResponse(String res) {
                if (BuildConfig.DEBUG) Log.d(TAG, "onResponse: "+res);
                srl.setRefreshing(false);
                mAdapter.clearAllItems();
                mAdapter.addItems((List)mGson.fromJson(res, new TypeToken<List<ServerOrder>>() {}.getType()));
                mOrderListTemp.clear();
                mOrderListTemp.addAll(mOrderList);
            }

            @Override
            public void onError() {
                srl.setRefreshing(false);
                MyToast.error(getContext(), R.string.load_error, Toast.LENGTH_SHORT);
            }
        });
    }


}
