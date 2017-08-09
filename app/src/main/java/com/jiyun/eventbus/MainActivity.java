package com.jiyun.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {


    private TextView tv_event;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_event = (TextView) findViewById(R.id.tv_event);

        //注册eventBus
        EventBus.getDefault().register(this);

        findViewById(R.id.btn).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        MainActivity.this.startActivity(i);
                    }
                }
        );
    }

    @Subscribe  //订阅事件
    public void onEventMainThread(LoginEevent event  ) {
        tv_event.setText(event.getMsg());
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        //取消event注册
        EventBus.getDefault().unregister(this);
    }
}
