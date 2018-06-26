package com.copasso.health.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.copasso.health.R;
import com.copasso.health.adapter.PressureAdapter;
import com.copasso.health.base.BaseActivity;
import com.copasso.health.model.LocalRepository;
import com.copasso.health.model.bean.Pressure;

import java.util.List;

/**
 * PressureActivity:血压界面
 */
public class PressureActivity extends BaseActivity implements View.OnClickListener {

    /**************View****************/
    private EditText editSystolic;
    private EditText editDiastolic;
    private Button btnSave;
    private RecyclerView recyclerView;

    /**************params****************/
    private PressureAdapter adapter;
    private List<Pressure> listPressure;

    @Override
    protected int getLayout() {
        return R.layout.activity_pressure;
    }

    @Override
    protected void initView() {
        editSystolic = (EditText) findViewById(R.id.pressure_et_systolicValue);
        editDiastolic = (EditText) findViewById(R.id.pressure_et_diastolicValue);
        btnSave = (Button) findViewById(R.id.pressure_btn_save);

        btnSave.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.pressure_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listPressure=LocalRepository.getInstance().getAllPressures();
        adapter=new PressureAdapter(mContext,listPressure);
        recyclerView.setAdapter(adapter);
    }

    /**
     * 保存记录
     */
    private void savePressure(){
        String strSystolic= editSystolic.getText().toString();
        String strDiastolic = editDiastolic.getText().toString();

        if (strSystolic.equals("")|| strDiastolic.equals("")) {
            Toast.makeText(mContext, "请输入完整信息", Toast.LENGTH_SHORT).show();
        }else{
            float systolicValue = Float.valueOf(strSystolic);
            float diastolicValue = Float.valueOf(strDiastolic);
            Pressure pressure=new Pressure(systolicValue,diastolicValue);
            //保存血糖记录
            System.out.println(LocalRepository.getInstance().savePressure(pressure));
            adapter.addItem(pressure);
        }
    }

    /**************listener****************/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pressure_btn_save:
                savePressure();
                break;
        }
    }
}
