package com.copasso.health.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 血压
 */
@Entity
public class Pressure {
    @Id(autoincrement = true)
    private Long id;    //id
    private float systolicValue;   //收缩压
    private float diastolicValue;  //舒张压

    public Pressure(float systolicValue, float diastolicValue) {
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
    }

    public Pressure() {
    }

    @Generated(hash = 387024575)
    public Pressure(Long id, float systolicValue, float diastolicValue) {
        this.id = id;
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getSystolicValue() {
        return this.systolicValue;
    }
    public void setSystolicValue(float systolicValue) {
        this.systolicValue = systolicValue;
    }
    public float getDiastolicValue() {
        return this.diastolicValue;
    }
    public void setDiastolicValue(float diastolicValue) {
        this.diastolicValue = diastolicValue;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
