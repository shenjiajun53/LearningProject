package com.example.jory.learningproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rey.material.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedThreadActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private Button joinBt;
    private ArrayList<String> stringArrayList=new ArrayList<>();
    private MyAdapter myAdapter;

    private JoinThread joinThread;

    private final int JOIN_MSG=101;

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case JOIN_MSG:
                    recyclerView.smoothScrollToPosition(stringArrayList.size());
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronized_thread);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        initView();
    }

    private void initView(){
        joinBt=(Button) findViewById(R.id.join_bt);
        joinBt.setOnClickListener(this);

        recyclerView=(RecyclerView) findViewById(R.id.thread_recycler);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SynchronizedThreadActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter=new MyAdapter();
        myAdapter.openLoadAnimation();
        recyclerView.setAdapter(myAdapter);
    }

    private void startJoinThread(){
        new JoinThread("new Thread").start();
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                JoinThread th = new JoinThread("joined thread");
                th.start();
                try {
                    th.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stringArrayList.add(Thread.currentThread().getName() + "  " + i);
            myAdapter.notifyDataSetChanged();
//            recyclerView.scrollToPosition(stringArrayList.size());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.join_bt:
                startJoinThread();
                break;
            default:
                break;
        }
    }

    class MyAdapter extends BaseQuickAdapter<String>{

        public MyAdapter() {
            super(R.layout.item_main_recycler,stringArrayList);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.item_tv,s);
        }
    }

    private class JoinThread extends Thread{

        public JoinThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
//                System.out.println(getName() + "  " + i);
                stringArrayList.add(getName() + "  " + i);
                myAdapter.notifyDataSetChanged();
                mHandler.sendEmptyMessage(JOIN_MSG);

//                recyclerView.scrollToPosition(stringArrayList.size());

//                try {
//                    sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
