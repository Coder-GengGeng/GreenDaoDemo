package com.meitu.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.ToOne;

import com.meitu.greendaodemo.greendao.dao.DaoSession;
import com.meitu.greendaodemo.greendao.dao.StudentDao;
import com.meitu.greendaodemo.greendao.dao.ComputerDao;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * @author Jason on 2016/11/24.
 */
@Entity(active = true)
public class Student {
    @Id
    private Long id;
    private int age;
    private long computerId;
    @ToOne(joinProperty = "computerId")
    private Computer computer;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;
    @Generated(hash = 962148366)
    private transient Long computer__resolvedKey;
    @Generated(hash = 1171011447)
    public Student(Long id, int age, long computerId) {
        this.id = id;
        this.age = age;
        this.computerId = computerId;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }
    public long getComputerId() {
        return this.computerId;
    }
    public void setComputerId(long computerId) {
        this.computerId = computerId;
    }
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 959254731)
    public Computer getComputer() {
        long __key = this.computerId;
        if (computer__resolvedKey == null || !computer__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ComputerDao targetDao = daoSession.getComputerDao();
            Computer computerNew = targetDao.load(__key);
            synchronized (this) {
                computer = computerNew;
                computer__resolvedKey = __key;
            }
        }
        return computer;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 264446706)
    public void setComputer(@NotNull Computer computer) {
        if (computer == null) {
            throw new DaoException(
                    "To-one property 'computerId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.computer = computer;
            computerId = computer.getId();
            computer__resolvedKey = computerId;
        }
    }


}
