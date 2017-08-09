package com.jiyun.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends AppCompatActivity {

    private EditText et_user_name, et_user_psd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_user_name=(EditText) findViewById(R.id.et_user_name);
        et_user_psd=(EditText) findViewById(R.id.et_user_psd);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //获取用户名
                final String userName=et_user_name.getText().toString();


                et_user_name.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //eventBus发送事件
                        EventBus.getDefault().post(new LoginEevent(userName));

                        //关闭当前activity
                        LoginActivity.this.finish();
                    }
                },3000);
            }
        });
    }
}
