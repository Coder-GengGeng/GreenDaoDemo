package com.meitu.greendaodemo.base;

import android.app.Application;
import android.content.Context;

/**
 * @author Jason on 2016/11/22.
 */

public class BaseApplication extends Application {

    private static final String TAG=BaseApplication.class.getSimpleName();

    private static BaseApplication mInstance=null;

    public static BaseApplication getInstance(){
        return mInstance;
    }

    public static Context getContext(){
        return mInstance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        mInstance=this;
        super.onCreate();
    }
}
