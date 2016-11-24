package com.meitu.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.meitu.greendaodemo.bean.Computer;
import com.meitu.greendaodemo.bean.Student;
import com.meitu.greendaodemo.util.ComputerDaoUtil;
import com.meitu.greendaodemo.util.StudentDaoUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG=MainActivity.class.getSimpleName();

    @BindView(R.id.main_student_tv)
    TextView mStudentTv;
    @BindView(R.id.main_computer_tv)
    TextView mComputerTv;

    List<Student> mStudentsList=new ArrayList<>();
    List<Computer> mComputersList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        simulator();
        save();
//        get();
    }

    private void simulator(){
    }

    private void save(){
        Student student=StudentDaoUtil.getStudent(1l);
        mStudentsList=StudentDaoUtil.getAllStudnets();
        if(null==student){
            student=new Student();
            student.setId(1l);
            student.setAge(2);
            Computer computer=new Computer(11L,256);
            student.setComputer(computer);
            StudentDaoUtil.save(student);
        }else{
            student.refresh();
            mStudentTv.setText("Age : " + student.getAge());
            if (null != student.getComputer()) {
                mComputerTv.setText("id: " + student.getComputer().getId() + " memory :" + student.getComputer().getMemory());
            }
        }


    }

    private void get(){
        Student student=StudentDaoUtil.getStudent(1);
//        if(null!=mStudentsList && mStudentsList.size()>=1) {
//            Student student=mStudentsList.get(0);
        if(null!=student) {
            mStudentTv.setText("Age : " + student.getAge());
            if (null != student.getComputer()) {
                mComputerTv.setText("id: " + student.getComputer().getId() + " memory :" + student.getComputer().getMemory());
            }
//        }
        }
    }
}
