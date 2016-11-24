package com.meitu.greendaodemo.util;

import android.util.Log;

import com.meitu.greendaodemo.bean.Computer;
import com.meitu.greendaodemo.bean.Student;
import com.meitu.greendaodemo.greendao.DaoManager;
import com.meitu.greendaodemo.greendao.dao.StudentDao;

import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.internal.LongHashMap;
import org.greenrobot.greendao.query.Query;

import java.util.List;

/**
 * @author Jason on 2016/11/24.
 */

public class StudentDaoUtil {
    private static final String TAG= StudentDaoUtil.class.getSimpleName();
    private static StudentDao mStudentDao= DaoManager.getInstance().getDaoSession().getStudentDao();

    public static void asyncSave(final Student student){
        if(null!=mStudentDao) {
            AsyncSession asyncSession = DaoManager.getInstance().getDaoSession().startAsyncSession();
            asyncSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    ComputerDaoUtil.save(student.getComputer());
                    mStudentDao.save(student);
//                    student.setComputer();
                }
            });
        }
    }

    public static void asyncSave(final List<Student> studentList){
        if(null!=mStudentDao){
            AsyncSession asyncSession=DaoManager.getInstance().getDaoSession().startAsyncSession();
            asyncSession.runInTx(new Runnable() {
                @Override
                public void run() {
                    mStudentDao.saveInTx(studentList);
                }
            });
        }
    }


    public static void save(Student student){
        if(null!=mStudentDao){
            try {
//                Computer computer=student.getComputer();
                ComputerDaoUtil.save(student.getComputer());
//                student.setComputer(student.getComputer());
//                student.refresh();
//                mStudentDao.save(student);
                mStudentDao.insertOrReplace(student);
//                student.refresh();
//                student.update();
            }catch (Exception e){
                Log.e(TAG,e.toString());
            }
        }
    }

    public static Student getStudent(long id){
        if(null!=mStudentDao){
            return mStudentDao.load(id);
        }
        return null;
    }

    public static List<Student> getAllStudnets(){
        if(null!=mStudentDao){
//            return mStudentDao.loadAll();
            Query<Student> query=mStudentDao.queryBuilder().build();
            return query.list();
        }
        return null;
    }
}
