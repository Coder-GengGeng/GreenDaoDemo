package com.meitu.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.meitu.greendaodemo.greendao.dao.DaoSession;
import com.meitu.greendaodemo.greendao.dao.ComputerDao;

/**
 * @author Jason on 2016/11/24.
 */
@Entity
public class Computer {
    @Id
    private Long id;
    private int memory;
    @Generated(hash = 1892157744)
    public Computer(Long id, int memory) {
        this.id = id;
        this.memory = memory;
    }
    @Generated(hash = 1238779503)
    public Computer() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getMemory() {
        return this.memory;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }
}
