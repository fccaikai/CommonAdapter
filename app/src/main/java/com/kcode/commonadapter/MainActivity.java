package com.kcode.commonadapter;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kcode.adapter.CommonAdapter;
import com.kcode.adapter.DividerItemDecoration;
import com.kcode.adapter.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout.LayoutParams headLayoutParams;

    private LinearLayout mHeadLayout;
    private RecyclerView mRecyclerView;
    private CommonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeadLayout = (LinearLayout) findViewById(R.id.headLayout);
        headLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommonAdapter<String>(R.layout.item_text) {

            @Override
            protected void setupViewHolder(RecyclerViewHolder holder, int position, String item) {
                holder.setText(R.id.tv_text,item);
            }
        };

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(ContextCompat.getDrawable(getApplicationContext(),R.drawable.line)
                        ,LinearLayoutManager.VERTICAL));

        mRecyclerView.setAdapter(adapter);
        adapter.init(initData());

        //add item click listener
        adapter.addOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });

        //add item long click listener
        adapter.addOnItemLongClickListener(new CommonAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(int position) {

            }
        });


    }

    private List<String> initData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("" + i + "条");
        }

        return data;
    }
}
