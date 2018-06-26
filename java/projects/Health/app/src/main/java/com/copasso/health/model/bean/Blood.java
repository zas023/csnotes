package com.copasso.health.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 血糖
 */
@Entity
public class Blood{
    @Id(autoincrement = true)
    private Long id;    //id
    private float mealValue;   //饭后血糖值
    private float emptyValue;  //空腹血糖值
    @Generated(hash = 1264244740)
    public Blood(Long id, float mealValue, float emptyValue) {
        this.id = id;
        this.mealValue = mealValue;
        this.emptyValue = emptyValue;
    }
    @Generated(hash = 960436)
    public Blood() {
    }

    public Blood(float mealValue, float emptyValue) {
        this.mealValue = mealValue;
        this.emptyValue = emptyValue;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public float getMealValue() {
        return this.mealValue;
    }
    public void setMealValue(float mealValue) {
        this.mealValue = mealValue;
    }
    public float getEmptyValue() {
        return this.emptyValue;
    }
    public void setEmptyValue(float emptyValue) {
        this.emptyValue = emptyValue;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
