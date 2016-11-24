package com.meitu.greendaodemo.util;

import com.meitu.greendaodemo.bean.Computer;
import com.meitu.greendaodemo.greendao.DaoManager;
import com.meitu.greendaodemo.greendao.dao.ComputerDao;

import org.greenrobot.greendao.async.AsyncSession;

import java.util.List;

/**
 * @author Jason on 2016/11/24.
 */

public class ComputerDaoUtil {
    private static final String TAG=ComputerDaoUtil.class.getSimpleName();
    private static ComputerDao mComputerDao= DaoManager.getInstance().getDaoSession().getComputerDao();

    public static void asyncSave(final Computer computer){
        if(null!=mComputerDao){
            AsyncSession asyncSession=DaoManager.getInstance().getDaoSession().startAsyncSession();
            asyncSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    mComputerDao.save(computer);
                }
            });
        }
    }

    public static void asyncSave(final List<Computer> computerList){
        if(null!=mComputerDao){
            AsyncSession asyncSession=DaoManager.getInstance().getDaoSession().startAsyncSession();
            asyncSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    mComputerDao.saveInTx(computerList);
                }
            });

        }
    }

    public static void save(Computer computer){
        if(null!=mComputerDao){
            mComputerDao.insertOrReplace(computer);
        }
    }



    public static Computer getComputer(long id){
        if(null!=mComputerDao){
            return mComputerDao.load(id);
        }
        return null;
    }

    public static List<Computer> getAllComputers(){
        if(null!=mComputerDao){
            return mComputerDao.loadAll();
        }
        return null;
    }

}

