package mao.android_application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import mao.android_application.application.MainApplication;

public class MainActivity2 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.TextView_result);

        findViewById(R.id.Button3).setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v)
            {
                Map<String, Object> map = MainApplication.getInstance().map;
                String username = (String) map.get("username");
                String password = (String) map.get("password");

                if (username == null)
                {
                    toastShow("用户名读取失败");
                    return;
                }
                if (password == null)
                {
                    toastShow("密码读取失败");
                    return;
                }
                textView.setText("用户名：" + username + "\n密码：" + password);

            }
        });
    }

    /**
     * 显示消息
     *
     * @param message 消息
     */
    private void toastShow(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}