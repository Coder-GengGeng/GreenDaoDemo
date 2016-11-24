package com.meitu.greendaodemo.greendao;

import com.meitu.greendaodemo.base.BaseApplication;
import com.meitu.greendaodemo.greendao.dao.DaoMaster;
import com.meitu.greendaodemo.greendao.dao.DaoSession;

/**
 * @ThreadUnSafe
 * @author Jason on 2016/11/22.
 */

public class DaoManager {
    private static final String TAG=DaoManager.class.getSimpleName();
    private static final String DB_NAME="greendaodemo.db";
    private static DaoManager mDaoManager=null;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private DaoManager(){}

    public static DaoManager getInstance(){
        if(null==mDaoManager){
            mDaoManager=new DaoManager();
        }
        return mDaoManager;
    }

    public DaoMaster getDaoMaster(){
        if(null==mDaoMaster){
            DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(BaseApplication.getContext(),DB_NAME);
            mDaoMaster=new DaoMaster(helper.getWritableDatabase());
        }
        return mDaoMaster;
    }

    public DaoSession getDaoSession(){
        if(null==mDaoSession){
            mDaoSession=getDaoMaster().newSession();
        }
        return mDaoSession;
    }

}
