package com.lvqingyang.callcustomserver.net;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.lvqingyang.callcustomserver.BuildConfig;
import com.lvqingyang.callcustomserver.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import frame.tool.Md5Util;
import frame.tool.MyOkHttp;
import frame.tool.MyToast;
import frame.tool.NetWorkUtils;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 　　┏┓　　  ┏┓+ +
 * 　┏┛┻━ ━ ━┛┻┓ + +
 * 　┃　　　             ┃
 * 　┃　　　━　　   ┃ ++ + + +
 * ████━████     ┃+
 * 　┃　　　　　　  ┃ +
 * 　┃　　　┻　　  ┃
 * 　┃　　　　　　  ┃ + +
 * 　┗━┓　　　┏━┛
 * 　　　┃　　　┃
 * 　　　┃　　　┃ + + + +
 * 　　　┃　　　┃
 * 　　　┃　　　┃ +  神兽保佑
 * 　　　┃　　　┃    代码无bug！
 * 　　　┃　　　┃　　+
 * 　　　┃　 　　┗━━━┓ + +
 * 　　　┃ 　　　　　　　┣┓
 * 　　　┃ 　　　　　　　┏┛
 * 　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　┃┫┫　┃┫┫
 * 　　　　┗┻┛　┗┻┛+ + + +
 * ━━━━━━神兽出没━━━━━━
 * Author：LvQingYang
 * Date：2017/6/12
 * Email：biloba12345@gamil.com
 * Info：
 */

public class RequestHelper {
    private static final String key="wust_cloud_call";
    private static final String KEY_API = "http://call.zeblog.cn/api/Android/";
    private static final String API_LOGIN = KEY_API+"CustomServerLogin";
    private static final String API_GET_ORDERS = KEY_API+"GetOrdersForServer";
    private static final String API_ACCEPT_ORDER = KEY_API+"AcceptOrder";
    private static final String API__MY_TASK= KEY_API+"GetOrdersByServerID";
    private static final String API_WITHDRAW_CASH = KEY_API+"WithdrawCash";
    private static final String API_GET_PLATFROM_ACCOUNT = KEY_API+"GetPlatfromAccount";
    private static final String API_ASYNC_SERVER_ORDER = KEY_API+"AsyncServerOrder";




    private static final String TAG = "RequestHelper";

    private static void getResult(Context c, StringBuilder sb, final RequestListener listener){
        if (NetWorkUtils.isNetworkConnected(c)) {
            //相关参数
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time=format.format(date);
            String chkvalue=key+time;
            chkvalue= Md5Util.MD5(chkvalue);
            chkvalue=chkvalue.substring(3).toLowerCase();

            final String url=sb.append("Time="+time).append("&Checkvalue="+chkvalue).toString();
            Log.d(TAG, "getResult: "+url);
            Observable.create(new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> subscriber) {
                    try {
                        subscriber.onNext(MyOkHttp.getInstance()
                                .run(url));
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
                }
            })
                    .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                    .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onNext(String response) {
                            if (BuildConfig.DEBUG) Log.d(TAG, "onNext: "+response);
                            listener.onResponse(response);
                        }

                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            listener.onError();
                        }
                    });
        }else {
            MyToast.info(c, c.getString(R.string.check), Toast.LENGTH_SHORT);
        }
    }

    public static void login(Context c, String username,String pwd, RequestListener listener){
        StringBuilder sb=new StringBuilder(API_LOGIN)
                .append("?Username="+username+"&")
                .append("Password="+pwd+"&");
        getResult(c,sb,listener );
    }

    public static void getOrders(Context c, RequestListener listener){
        StringBuilder sb=new StringBuilder(API_GET_ORDERS)
                .append("?");
        getResult(c,sb,listener );
    }

    public static void acceptOrder(Context c, int serverId,int orderId,int count,RequestListener listener){
        StringBuilder sb=new StringBuilder(API_ACCEPT_ORDER)
                .append("?ServerID="+serverId+"&")
                .append("OrderID="+orderId+"&")
                .append("Count="+count+"&");
        getResult(c,sb,listener);
    }

    public static void getMyTasks(Context c, int serverId,RequestListener listener){
        StringBuilder sb=new StringBuilder(API__MY_TASK)
                .append("?ServerID="+serverId+"&");
        getResult(c,sb,listener);
    }

    public static void withdrawCash(Context c, int serverId,float money,RequestListener listener){
        StringBuilder sb=new StringBuilder(API_WITHDRAW_CASH)
                .append("?ServerID="+serverId+"&")
                .append("Money="+money+"&");
        getResult(c,sb,listener);
    }

    public static void getPlatformAccount(Context c, int serverId,RequestListener listener){
        StringBuilder sb=new StringBuilder(API_GET_PLATFROM_ACCOUNT)
                .append("?ServerID="+serverId+"&");
        getResult(c,sb,listener);
    }

    public static void asyncServerOrder(Context c, int serverOrderId,RequestListener listener){
        StringBuilder sb=new StringBuilder(API_ASYNC_SERVER_ORDER)
                .append("?ServerOrderID="+serverOrderId+"&");
        getResult(c,sb,listener);
    }
}
