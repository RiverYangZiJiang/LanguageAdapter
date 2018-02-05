package com.languageadapter.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.languageadapter.R;
import com.languageadapter.com.BaseActivity;
import com.languageadapter.utils.LocaleManager;

/**
 * Created by  Marlon on 11/27/2017.
 * Describe
 */
public class LanguageSettingActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LanguageSettingActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languagesetting);
        findViewById(R.id.tvChinese).setOnClickListener(this);
        findViewById(R.id.tvEnglish).setOnClickListener(this);

        Toast.makeText(getApplicationContext(), R.string.LanguageSettingActivity, Toast.LENGTH_LONG).show();  // 切换语言，不杀掉应用的话，在此国际化失败

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvChinese:
                LocaleManager.setNewLocale(this, LocaleManager.LANGUAGE_CHINESE);
                break;
            case R.id.tvEnglish:
                LocaleManager.setNewLocale(this, LocaleManager.LANGUAGE_ENGLISH);
                break;
        }
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}