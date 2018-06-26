package com.copasso.health.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.copasso.health.R;
import com.copasso.health.base.BaseActivity;

import java.text.DecimalFormat;

/**
 * BMIActivity：体重指标界面
 */
public class BMIActivity extends BaseActivity {

    /**************View****************/
    private EditText editHight;
    private EditText editWeight;
    private Button btnEvaluate;
    private TextView tvResult;

    /**************View****************/
    @Override
    protected int getLayout() {
        return R.layout.activity_bmi;
    }

    @Override
    protected void initView() {
        editHight = (EditText) findViewById(R.id.et_height);
        editWeight = (EditText) findViewById(R.id.et_weight);
        btnEvaluate = (Button) findViewById(R.id.btn_evaluate);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strHeight = editHight.getText().toString();
                String strWeight = editWeight.getText().toString();
                if (strHeight.equals("")|| strWeight.equals("")) {
                    Toast.makeText(mContext, "请输入完整信息", Toast.LENGTH_SHORT).show();
                }else {
                    float height = Float.valueOf(strHeight);
                    float weight = Float.valueOf(strWeight);

                    evaluate(height, weight);
                }

            }
        });
    }

    /**
     * 计算BMI
     *
     * @param height
     * @param weight
     */
    private void evaluate(float height, float weight) {
        float result = weight / (height * height);
        DecimalFormat fnum = new DecimalFormat("##.00");
        if (result >= 28.0)
            tvResult.setText("BMI:" + fnum.format(result) + "\n您的身材肥胖");
        else if (result >= 24.0)
            tvResult.setText("BMI:" + fnum.format(result) + "\n您的身材过重");
        else if (result >= 18.5)
            tvResult.setText("BMI:" + fnum.format(result) + "\n您的身材正常");
        else
            tvResult.setText("BMI:" + fnum.format(result) + "\n您的身材偏瘦");
    }
    /**************View****************/
}
