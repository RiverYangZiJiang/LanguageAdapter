package com.languageadapter;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.languageadapter.utils.LocaleManager;

public class App extends Application {


    private final String TAG = "App";

    /**
     * 应用上下文
     */
    public static Context applicationContext;

    @Override
    public void onCreate()
    {
        Log.d(TAG, "onCreate");

        super.onCreate();
        //app上下文
        applicationContext = this.getApplicationContext();
    }

    /*【
    1.虽然这样可以使用applicationContext作为国际化的上下文，但是当语言切换之后，由于没有进行重新调用attachBaseContext方法，只要不杀掉应用，切换语言之后，使用applicationContext
    进行国际化会失败
    2.最好还是在本类中再创建一个临时的contextTemp，把其他Activity的context赋值给contextTemp，这样在其他非Activity类中使用contextTemp作为国际化的上下文，这样反复切换语言都OK
    3.这种国际化方案并也重新创建Activity，在切换语言时会调用startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    】*/
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
        Log.d(TAG, "attachBaseContext");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocaleManager.setLocale(this);
        Log.d(TAG, "onConfigurationChanged: " + newConfig.locale.getLanguage());
    }

}