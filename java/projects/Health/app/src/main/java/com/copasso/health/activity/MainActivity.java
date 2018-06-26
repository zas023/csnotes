package com.copasso.health.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.copasso.health.R;
import com.copasso.health.base.BaseActivity;

/**
 * MainActivity:主界面
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    /**************View****************/
    private Button btnBmi;
    private Button btnBlood;
    private Button btnStress;
    private Button btnChart1;
    private Button btnChart2;

    /**************init****************/
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnBmi= (Button) findViewById(R.id.btn_bmi);
        btnBlood= (Button) findViewById(R.id.btn_blood);
        btnStress= (Button) findViewById(R.id.btn_stress);
        btnChart1= (Button) findViewById(R.id.btn_chart_blood);
        btnChart2= (Button) findViewById(R.id.btn_chart_pressure);

        btnBmi.setOnClickListener(this);
        btnBlood.setOnClickListener(this);
        btnStress.setOnClickListener(this);
        btnChart1.setOnClickListener(this);
        btnChart2.setOnClickListener(this);
    }

    /**************listener****************/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bmi:
                startActivity(new Intent(mContext,BMIActivity.class));
                break;
            case R.id.btn_blood:
                startActivity(new Intent(mContext,BloodActivity.class));
                break;
            case R.id.btn_stress:
                startActivity(new Intent(mContext,PressureActivity.class));
                break;
            case R.id.btn_chart_pressure:
                startActivity(new Intent(mContext,PressureChartActivity.class));
                break;
            case R.id.btn_chart_blood:
                startActivity(new Intent(mContext,BloodChartActivity.class));
                break;
        }
    }
}
