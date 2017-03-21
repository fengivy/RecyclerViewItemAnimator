package com.ivy.recyclerviewitemanimator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivy on 2017/3/21.
 * Description：
 */

public class ItemAnimatorAdapter extends RecyclerView.Adapter<ViewHolder>{
    private final Context mContext;
    private List<String> mData=new ArrayList<>();

    public ItemAnimatorAdapter(Context context,List<String> data){
        this.mContext=context;
        this.mData=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_item_animator,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(position+":"+mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder{
    public TextView tv;
    public ViewHolder(View itemView) {
        super(itemView);
        tv= (TextView) itemView.findViewById(R.id.tv);
    }
}
