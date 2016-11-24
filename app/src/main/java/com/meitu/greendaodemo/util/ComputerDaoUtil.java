package com.meitu.greendaodemo.util;

import com.meitu.greendaodemo.greendao.DaoManager;
import com.meitu.greendaodemo.greendao.dao.ComputerDao;

/**
 * @author Jason on 2016/11/24.
 */

public class ComputerDaoUtil {
    private static final String TAG=ComputerDaoUtil.class.getSimpleName();
    private static ComputerDao mComputerDao= DaoManager.getInstance().getDaoSession().getComputerDao();

}
