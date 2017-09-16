package com.lvqingyang.callcustomserver.User;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lvqingyang.callcustomserver.Base.BaseFragment;
import com.lvqingyang.callcustomserver.BuildConfig;
import com.lvqingyang.callcustomserver.Login.LoginActivity;
import com.lvqingyang.callcustomserver.R;
import com.lvqingyang.callcustomserver.bean.User;
import com.lvqingyang.callcustomserver.net.RequestHelper;
import com.lvqingyang.callcustomserver.net.RequestListener;
import com.lvqingyang.callcustomserver.view.CardItem;

import de.hdodenhof.circleimageview.CircleImageView;
import frame.tool.MyPrefence;
import frame.tool.MyToast;

/**
 * Author：LvQingYang
 * Date：2017/9/1
 * Email：biloba12345@gamil.com
 * Github：https://github.com/biloba123
 * Info：
 */
public class UserFragment extends BaseFragment {

    private Toolbar toolbar;
    private CircleImageView civhead;
    private TextView tvusername;
    private TextView tvposition;
    private CardItem mCiWallet;
    private User user;
    private static final String TAG = "UserFragment";
    private Gson mGson=new Gson();
    private TextView mTvWaitMoney;
    private CardItem mCiExit;

    public static UserFragment newInstance() {

        Bundle args = new Bundle();

        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        showUserInfo();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden&&mCiWallet!=null) {
            showUserInfo();
        }
    }

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_uesr,container,false);
        return view;
    }

    @Override
    protected void initView(View view) {
        this.tvposition = (TextView) view.findViewById(R.id.tv_position);
        this.tvusername = (TextView) view.findViewById(R.id.tv_username);
        this.civhead = (CircleImageView) view.findViewById(R.id.civ_head);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mCiWallet = (CardItem) view.findViewById(R.id.ci_wallet);
        mTvWaitMoney = (TextView) view.findViewById(R.id.tv_wait_balance);
        mCiExit = (CardItem) view.findViewById(R.id.ci_exit);
        initToolbar(toolbar,getString(R.string.account_info),false);
    }

    @Override
    protected void setListener() {

        mCiExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyPrefence.getInstance(getActivity()).logOut();
                LoginActivity.start(getActivity());
                getActivity().finish();
            }
        });

        mCiWallet.setOnClickListener(new View.OnClickListener() {
            private android.widget.Button btn;
            private EditText et;

            @Override
            public void onClick(View view) {
                View view1=getActivity().getLayoutInflater()
                        .inflate(R.layout.dialog_withdraw,null);
                this.et = (EditText) view1.findViewById(R.id.et);
                final AlertDialog alertDialog=new AlertDialog.Builder(getContext())
                        .setView(view1)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final Float money=((int)Float.parseFloat(et.getText().toString())*100)/100f;
//                                RequestHelper.chargeBalance(getActivity(), user.getEnterID(), money, new RequestListener() {
//                                    @Override
//                                    public void onResponse(String res) {
//                                        if (BuildConfig.DEBUG) Log.d(TAG, "onResponse: "+res);
//                                        if (res.equals("1")) {
//                                            MyToast.success(getContext(), R.string.charge_succ);
//                                            showUserInfo();
//                                        }else {
//                                            MyToast.error(getContext(), R.string.charge_fail);
//                                        }
//                                    }
//
//                                    @Override
//                                    public void onError() {
//                                        MyToast.error(getActivity(), R.string.load_error);
//                                    }
//                                });
                                RequestHelper.withdrawCash(getActivity(), user.getServerID(), money, new RequestListener() {
                                    @Override
                                    public void onResponse(String res) {
                                        if (TextUtils.equals(res,"1")) {
                                            MyToast.success(getContext(), R.string.withdraw_succ);
                                            showUserInfo();
                                        }else {
                                            MyToast.error(getContext(), R.string.withdraw_fail);
                                        }
                                    }

                                    @Override
                                    public void onError() {
                                        MyToast.error(getContext(), R.string.load_error, Toast.LENGTH_SHORT);
                                    }
                                });
                            }
                        })
                        .setNegativeButton(android.R.string.cancel,null)
                        .create();
                alertDialog.show();
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void setData() {
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_user,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void showUserInfo(){
        user= MyPrefence.getInstance(getContext()).getUser(User.class);
        RequestHelper.login(getActivity(), user.getUsername(), user.getPassword(), new RequestListener() {
            @Override
            public void onResponse(String res) {
                if (BuildConfig.DEBUG) Log.d(TAG, "onResponse: "+res);
                user=mGson.fromJson(res, User.class);
                tvusername.setText(user.getUsername());
                tvposition.setText(user.getEmail());
                mCiWallet.setHint(((int)user.getBalance()*100)/100f+"");
                mTvWaitMoney.setText(user.getWaittingBalance().trim());
                MyPrefence.getInstance(getContext()).saveUser(user);
            }

            @Override
            public void onError() {

            }
        });


    }
}
