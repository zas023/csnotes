package com.copasso.health.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.copasso.health.R;
import com.copasso.health.adapter.BloodAdapter;
import com.copasso.health.base.BaseActivity;
import com.copasso.health.model.LocalRepository;
import com.copasso.health.model.bean.Blood;

import java.util.List;

/**
 * BloodActivity：血糖界面
 */
public class BloodActivity extends BaseActivity implements View.OnClickListener {

    /**************View****************/
    private EditText editEmpty;
    private EditText editMeal;
    private Button btnSave;
    private RecyclerView recyclerView;

    /**************params****************/
    private BloodAdapter adapter;
    private List<Blood> listBlood;


    /**************init****************/
    @Override
    protected int getLayout() {
        return R.layout.activity_blood;
    }

    @Override
    protected void initView() {
        editEmpty = (EditText) findViewById(R.id.et_empty);
        editMeal = (EditText) findViewById(R.id.et_meal);
        btnSave = (Button) findViewById(R.id.btn_save);

        btnSave.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listBlood=LocalRepository.getInstance().getAllBloods();
        adapter=new BloodAdapter(mContext,listBlood);
        recyclerView.setAdapter(adapter);

    }

    /**
     * 保存记录
     */
    private void saveBlood(){
        String strEmpty= editEmpty.getText().toString();
        String strMeal = editMeal.getText().toString();

        if (strEmpty.equals("")|| strMeal.equals("")) {
            Toast.makeText(mContext, "请输入完整信息", Toast.LENGTH_SHORT).show();
        }else{
            float emptyValue = Float.valueOf(strEmpty);
            float mealValue = Float.valueOf(strMeal);
            System.out.println(strEmpty+"  :  "+strMeal);
            Blood blood=new Blood(emptyValue,mealValue);
            //保存血糖记录
            LocalRepository.getInstance().saveBlood(blood);
            adapter.addItem(blood);
        }
    }

    /**************listener****************/
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                saveBlood();
                break;
        }
    }
}
