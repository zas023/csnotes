package com.copasso.health.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.copasso.health.R;
import com.copasso.health.model.bean.Blood;

import java.util.List;

public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.ViewHolder> {
    private Context context;
    private List<Blood> items;

    public BloodAdapter(){

    }

    public BloodAdapter(Context context, List<Blood> items) {
        this.context = context;
        this.items = items;
    }

    public void addItem(Blood blood){
        items.add(blood);
        notifyDataSetChanged();
    }

    @Override
    public BloodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_common, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvIdex.setText(position+1+"");
        holder.tvUp.setText("空腹血糖："+items.get(position).getEmptyValue());
        holder.tvBottom.setText("饭后两小时血糖："+items.get(position).getMealValue());
    }

    @Override
    public int getItemCount() {
        if (items==null)
            return 0;
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvIdex;
        private TextView tvUp;
        private TextView tvBottom;

        public ViewHolder(View itemView) {
            super(itemView);
            tvIdex= (TextView) itemView.findViewById(R.id.item_tv_index);
            tvUp= (TextView) itemView.findViewById(R.id.item_tv_up);
            tvBottom= (TextView) itemView.findViewById(R.id.item_tv_bottom);
        }
    }
}
