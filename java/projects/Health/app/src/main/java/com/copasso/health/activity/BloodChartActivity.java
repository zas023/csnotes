package com.copasso.health.activity;

import android.graphics.Color;
import com.copasso.health.R;
import com.copasso.health.base.BaseActivity;
import com.copasso.health.model.LocalRepository;
import com.copasso.health.model.bean.Blood;
import com.copasso.health.utils.LineChartManager;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

/**
 * BloodChartActivity:血糖记录统计
 */
public class BloodChartActivity extends BaseActivity {
    private LineChartManager lineChartManager;
    private List<Float> list = new ArrayList<>(); //数据集合
    private List<String> names = new ArrayList<>(); //折线名字集合
    private List<Integer> colours = new ArrayList<>();//折线颜色集合

    private List<Blood> items;

    @Override
    protected int getLayout() {
        return R.layout.activity_blood_chart;
    }

    @Override
    protected void initView() {
        LineChart chart= (LineChart) findViewById(R.id.view_chart);
        //折线名字
        names.add("空腹");
        names.add("饭后两小时");
        //折线颜色
        colours.add(Color.BLUE);
        colours.add(Color.GREEN);

        lineChartManager=new LineChartManager(chart,names,colours);
        lineChartManager.setYAxis(20, 0, 20);

        items= LocalRepository.getInstance().getAllBloods();
        for (Blood blood: items){
            list.add(blood.getEmptyValue());
            list.add(blood.getMealValue());
            lineChartManager.addEntry(list);
            list.clear();
        }

    }
}

