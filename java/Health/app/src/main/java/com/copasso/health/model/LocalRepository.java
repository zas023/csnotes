package com.copasso.health.model;

import com.copasso.health.model.bean.Blood;
import com.copasso.health.model.bean.Pressure;
import com.copasso.health.model.gen.DaoSession;

import java.util.List;

public class LocalRepository {
    private static volatile LocalRepository sInstance;
    private DaoSession mSession;

    private LocalRepository() {
        mSession = DaoDbHelper.getInstance().getSession();
    }

    public static LocalRepository getInstance() {
        if (sInstance == null) {
            synchronized (LocalRepository.class) {
                if (sInstance == null) {
                    sInstance = new LocalRepository();
                }
            }
        }
        return sInstance;
    }

    /*****************get****************/
    /**
     * 查询所有血糖记录
     * @return
     */
    public List<Blood> getAllBloods(){
        return mSession.getBloodDao().queryBuilder().list();
    }

    /**
     * 查询所有血压记录
     * @return
     */
    public List<Pressure> getAllPressures(){
        return mSession.getPressureDao().queryBuilder().list();
    }

    /*****************save****************/

    /**
     * 保存血糖
     * @param blood
     */
    public Long saveBlood(Blood blood){
        return mSession.getBloodDao().insert(blood);
    }

    /**
     * 保存血压
     * @param pressure
     */
    public Long savePressure(Pressure pressure){
        return mSession.getPressureDao().insert(pressure);
    }
}
