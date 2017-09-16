package com.lvqingyang.callcustomserver.Task;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lvqingyang.callcustomserver.Base.BaseFragment;
import com.lvqingyang.callcustomserver.BuildConfig;
import com.lvqingyang.callcustomserver.R;
import com.lvqingyang.callcustomserver.bean.Order;
import com.lvqingyang.callcustomserver.bean.User;
import com.lvqingyang.callcustomserver.net.RequestHelper;
import com.lvqingyang.callcustomserver.net.RequestListener;

import java.util.ArrayList;
import java.util.List;

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
public class TaskCenterFragment extends BaseFragment {

    private Toolbar toolbar;
    private RecyclerView rvtask;
    private SwipeRefreshLayout srl;
    private List<Order> mOrderList=new ArrayList<>();
    private List<Order> mOrderListTemp=new ArrayList<>();
    private SolidRVBaseAdapter mAdapter;
    private String[] mTypeArr;
    private Gson mGson=new Gson();
    private static final String TAG = "TaskCenterFragment";
    private MyPrefence ymMyPrefence;
    private static final int REQUEST_ADD = 785;
    private User mUser;

    public static TaskCenterFragment newInstance() {

        Bundle args = new Bundle();

        TaskCenterFragment fragment = new TaskCenterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_task,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        this.srl = (SwipeRefreshLayout) view.findViewById(R.id.srl);
        this.rvtask = (RecyclerView) view.findViewById(R.id.rv_task);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        initToolbar(toolbar,getString(R.string.task_list),false);
    }

    @Override
    protected void setListener() {
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getTasks();
            }
        });
    }

    @Override
    protected void initData() {
        mUser=MyPrefence.getInstance(getContext()).getUser(User.class);
        mTypeArr=getResources().getStringArray(R.array.type_task);

        mAdapter=new SolidRVBaseAdapter<Order>(getContext(), mOrderList) {
            @Override
            protected void onBindDataToView(SolidCommonViewHolder holder, final Order bean) {
                ((CircleTextView)holder.getView(R.id.ctv_type))
                        .text(mTypeArr[bean.getOrderType()-1])
                        .bgColor(getResources().getColor(mColorArr[bean.getOrderType()-1]))
                        .paint();
                holder.setText(R.id.tv_name,bean.getOrderName());
                holder.setText(R.id.tv_total,bean.getPhoneCount()+"");
                holder.setText(R.id.tv_price,bean.getUnitPrice()+"");
                int called=0;
                if (bean.getCallTasks() != null) {
                    for (Order.CallTasksBean callTasksBean : bean.getCallTasks()) {
                        if (callTasksBean.getCallResult().getResultType()==2) {
                            called++;
                        }
                    }
                }
                holder.setText(R.id.tv_complete,called+"");
                ((ProgressBar)holder.getView(R.id.pb)).setProgress((int) (called*1f/bean.getPhoneCount()*100));

                holder.getView(R.id.tv_detail).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AlertDialog.Builder(getContext())
                                .setTitle(R.string.call_content)
                                .setMessage(bean.getCallContent())
                                .show();
                    }
                });


            }

            @Override
            public int getItemLayoutID(int viewType) {
                return R.layout.item_task;
            }

            @Override
            protected void onItemClick(int position, Order bean) {
                super.onItemClick(position, bean);
                showAccpetOrderDialog(bean);
            }
        };
    }

    @Override
    protected void setData() {
        rvtask.setLayoutManager(new LinearLayoutManager(getContext()));
        rvtask.setAdapter(mAdapter);

        srl.setRefreshing(true);
        getTasks();
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    private void getTasks(){
        RequestHelper.getOrders(getActivity(), new RequestListener() {
            @Override
            public void onResponse(String res) {
                if (BuildConfig.DEBUG) Log.d(TAG, "onResponse: "+res);
                srl.setRefreshing(false);
                mAdapter.clearAllItems();
                mAdapter.addItems((List) mGson.fromJson(res, new TypeToken<List<Order>>() {}.getType()));
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

    private void showAccpetOrderDialog(final Order order){
        View view=getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_accept_order,null);
        final EditText etCount=view.findViewById(R.id.et_count);

        new AlertDialog.Builder(getContext())
                .setTitle(order.getOrderName())
                .setView(view)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int count=Integer.parseInt(etCount.getText().toString());
                        if (count>0&&count<=order.getPhoneCount()) {
                            RequestHelper.acceptOrder(getActivity(), mUser.getServerID(), order.getOrderID(),count, new RequestListener() {
                                @Override
                                public void onResponse(String res) {
                                    if (BuildConfig.DEBUG) Log.d(TAG, "onResponse: "+res);
                                    getTasks();
                                }

                                @Override
                                public void onError() {
                                    MyToast.error(getContext(), R.string.load_error, Toast.LENGTH_SHORT);
                                }
                            });
                        }else {
                            MyToast.info(getContext(), R.string.wrong_count);
                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel,null)
                .create()
                .show();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_task_center,menu);
        final MenuItem item = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new     SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if (BuildConfig.DEBUG) Log.d(TAG, "onQueryTextChange: "+newText);
                if (TextUtils.isEmpty(newText)) {
                    if (BuildConfig.DEBUG) Log.d(TAG, "onQueryTextChange: ");
                    mOrderList.clear();
                    mOrderList.addAll(mOrderListTemp);
                }else {
                    if (BuildConfig.DEBUG) Log.d(TAG, "onQueryTextChange: ppp");
                    mOrderList.clear();
                    for (Order order : mOrderListTemp) {
                        if (mGson.toJson(order).contains(newText)) {
                            mOrderList.add(order);
                        }
                    }
                }
                mAdapter.notifyDataSetChanged();
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void changeData(List<Order> list){

    }

}
