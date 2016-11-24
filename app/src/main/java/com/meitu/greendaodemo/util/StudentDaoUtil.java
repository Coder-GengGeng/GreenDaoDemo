package com.meitu.greendaodemo.util;

import com.meitu.greendaodemo.bean.Student;
import com.meitu.greendaodemo.greendao.DaoManager;
import com.meitu.greendaodemo.greendao.dao.StudentDao;

import org.greenrobot.greendao.async.AsyncSession;

/**
 * @author Jason on 2016/11/24.
 */

public class StudentDaoUtil {
    private static final String TAG= StudentDaoUtil.class.getSimpleName();
    private static StudentDao mStudentDao= DaoManager.getInstance().getDaoSession().getStudentDao();

    public static void asyncSaveStudent(Student student){
        AsyncSession asyncSession=DaoManager.getInstance().getDaoSession().startAsyncSession();
    }
}
