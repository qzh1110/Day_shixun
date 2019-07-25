package com.example.day_yi.dao;



import com.example.day_yi.bean.Student;
import com.example.xts.greendaodemo.db.DaoMaster;
import com.example.xts.greendaodemo.db.DaoSession;
import com.example.xts.greendaodemo.db.StudentDao;

import java.util.List;

/**
 * Created by 钱 on 2019/6/25.
 */

public class Db_util {
    private static  Db_util db_util;
    private StudentDao studentDao;

    public static Db_util getDb_util() {
        if (db_util==null){
            synchronized (Db_util.class){
                if (db_util==null){
                    db_util=new Db_util();
                }
            }
        }
        return db_util;
    }

    public Db_util() {
        super();
        init();

    }

    private void init() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "one.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();

        studentDao = daoSession.getStudentDao();

    }
    public  void insert(Student student){
        if (has(student)){
            return;
        }
        studentDao.insertOrReplaceInTx(student);
    }

    public boolean has(Student student) {
        List<Student> list = studentDao.queryBuilder().where(StudentDao.Properties.Name.eq(student.getName())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
    public List<Student>select(){
        List<Student> list = studentDao.queryBuilder().list();
        return list;
    }
    public  void delete(Student student){
        studentDao.delete(student);
    }


}
