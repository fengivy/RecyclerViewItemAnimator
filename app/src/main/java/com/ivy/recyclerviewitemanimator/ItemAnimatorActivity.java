package com.ivy.recyclerviewitemanimator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivy on 2017/3/21.
 * Description：
 */

public class ItemAnimatorActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView mRv;
    private Button btnAdd,btnRemove,btnUpdate;
    private List<String> mData=new ArrayList<>();
    private ItemAnimatorAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_animator);
        mRv= (RecyclerView) this.findViewById(R.id.rv);
        btnAdd= (Button) this.findViewById(R.id.btn_add);
        btnRemove= (Button) this.findViewById(R.id.btn_remove);
        btnUpdate= (Button) this.findViewById(R.id.btn_update);

        btnAdd.setOnClickListener(this);
        btnRemove.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter=new ItemAnimatorAdapter(this,mData);
        mRv.setAdapter(mAdapter);
        for(int i=0;i<50;i++){
            mData.add("我是"+i);
        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                mData.add(1,"我是添加的");
                mAdapter.notifyItemInserted(1);
                break;
            case R.id.btn_remove:
                mData.remove(1);
                mAdapter.notifyItemRemoved(1);
                break;
            case R.id.btn_update:
                mData.set(1,"我是更新的");
                mAdapter.notifyItemChanged(1);
                break;
            default:
                break;
        }
    }
}
