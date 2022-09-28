package mao.android_application.application;

import android.app.Application;
import android.content.ContentProvider;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：android_Application
 * Package(包名): mao.android_application.application
 * Class(类名): MainApplication
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/28
 * Time(创建时间)： 12:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MainApplication extends Application
{
    /**
     * 标签
     */
    private static final String TAG = "MainApplication";

    /**
     * 实例，单例模式，双重检查锁，volatile防止指令重排，在写后面加写屏障
     */
    private static volatile MainApplication mainApplication;

    public Map<String, Object> map = new HashMap<>();

    public static MainApplication getInstance()
    {
        if (mainApplication == null)
        {
            synchronized (MainApplication.class)
            {
                if (mainApplication == null)
                {
                    mainApplication = new MainApplication();
                }
            }
        }
        return mainApplication;
    }


    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    /**
     * This method is for use in emulated process environments.  It will
     * never be called on a production Android device, where processes are
     * removed by simply killing them; no user code (including this callback)
     * is executed when doing so.
     */
    @Override
    public void onTerminate()
    {
        super.onTerminate();
        Log.d(TAG, "onTerminate: ");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
    }
}
