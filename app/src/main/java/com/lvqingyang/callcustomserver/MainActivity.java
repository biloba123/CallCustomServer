package com.lvqingyang.callcustomserver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.lvqingyang.callcustomserver.Call.MyTaskFragment;
import com.lvqingyang.callcustomserver.Task.TaskCenterFragment;
import com.lvqingyang.callcustomserver.User.UserFragment;

import frame.base.BaseActivity;

public class MainActivity extends BaseActivity {


    /**
     * view
     */
    private BottomNavigationView navigation;

    /**
     * fragment
     */
    private TaskCenterFragment mTaskCenterFragment;
    private MyTaskFragment mMyTaskFragment;
    private UserFragment mUserFragment;

    /**
     * data
     */
    private FragmentManager mFragmentManager;


    /**
     * tag
     */


    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
//        starter.putExtra();
        context.startActivity(starter);
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentManager=getSupportFragmentManager();
        if (savedInstanceState!=null) {
            mTaskCenterFragment = (TaskCenterFragment) mFragmentManager
                    .findFragmentByTag(TaskCenterFragment.class.getName());
            mMyTaskFragment = (MyTaskFragment) mFragmentManager
                    .findFragmentByTag(MyTaskFragment.class.getName());
            mUserFragment= (UserFragment) mFragmentManager
                    .findFragmentByTag(UserFragment.class.getName());
            mFragmentManager.beginTransaction()
                    .show(mTaskCenterFragment)
                    .hide(mMyTaskFragment)
                    .hide(mUserFragment)
                    .commit();
        }else {
            mTaskCenterFragment = TaskCenterFragment.newInstance();
            mMyTaskFragment = MyTaskFragment.newInstance();
            mUserFragment=UserFragment.newInstance();
            mFragmentManager.beginTransaction()
                    .add(R.id.content, mTaskCenterFragment, TaskCenterFragment.class.getName())
                    .add(R.id.content, mMyTaskFragment, MyTaskFragment
                            .class.getName())
                    .add(R.id.content, mUserFragment, UserFragment.class.getName())
                    .hide(mMyTaskFragment)
                    .hide(mUserFragment)
                    .commit();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

    @Override
    protected void setListener() {
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_task_center:
                        mFragmentManager.beginTransaction()
                                .hide(mMyTaskFragment)
                                .hide(mUserFragment)
                                .show(mTaskCenterFragment)
                                .commit();
                        return true;
                    case R.id.navigation_my_task:
                        mFragmentManager.beginTransaction()
                                .hide(mTaskCenterFragment)
                                .hide(mUserFragment)
                                .show(mMyTaskFragment)
                                .commit();
                        return true;
                    case R.id.navigation_user:
                        mFragmentManager.beginTransaction()
                                .hide(mMyTaskFragment)
                                .hide(mTaskCenterFragment)
                                .show(mUserFragment)
                                .commit();
                        return true;
                }
                return false;
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
    protected String[] getNeedPermissions() {
        return new String[0];
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
