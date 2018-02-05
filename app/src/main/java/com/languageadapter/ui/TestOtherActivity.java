package com.languageadapter.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.languageadapter.App;
import com.languageadapter.R;
import com.languageadapter.com.BaseActivity;

/**
 * Created by  Marlon on 11/27/2017.
 * Describe
 */

//public class TestOtherActivity extends Activity {
public class TestOtherActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testother);

//        Toast.makeText(App.applicationContext, R.string.TestOtherActivity, Toast.LENGTH_LONG).show();  // 切换语言，不杀掉应用的话，在此国际化失败
        Toast.makeText(App.applicationContext, App.applicationContext.getString(R.string.TestOtherActivity), Toast.LENGTH_LONG).show();  // 切换语言，不杀掉应用的话，在此国际化失败
    }

}
