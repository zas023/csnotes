package com.copasso.health.activity;

import android.graphics.Color;
import com.copasso.health.R;
import com.copasso.health.base.BaseActivity;
import com.copasso.health.model.LocalRepository;
import com.copasso.health.model.bean.Pressure;
import com.copasso.health.utils.LineChartManager;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

/**
 * PressureChartActivity：血压记录统计
 */
public class PressureChartActivity extends BaseActivity {

    private LineChartManager lineChartManager;
    private List<Float> list = new ArrayList<>(); //数据集合
    private List<String> names = new ArrayList<>(); //折线名字集合
    private List<Integer> colours = new ArrayList<>();//折线颜色集合

    private List<Pressure> items;

    @Override
    protected int getLayout() {
        return R.layout.activity_chart_p;
    }

    @Override
    protected void initView() {
        LineChart chart= (LineChart) findViewById(R.id.view_chart);
        //折线名字
        names.add("收缩压");
        names.add("舒张压");
        //折线颜色
        colours.add(Color.BLUE);
        colours.add(Color.GREEN);

        lineChartManager=new LineChartManager(chart,names,colours);
        lineChartManager.setYAxis(200, 0, 20);

        items= LocalRepository.getInstance().getAllPressures();
        for (Pressure pressure: items){
            list.add(pressure.getSystolicValue());
            list.add(pressure.getDiastolicValue());
            lineChartManager.addEntry(list);
            list.clear();
        }

    }
}
