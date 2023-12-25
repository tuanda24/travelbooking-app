package com.example.project136;

import android.content.Intent;
import android.os.Handler;

import com.example.project136.base.BaseActivity;
import com.example.project136.databinding.ActivitySplashBinding;
import com.example.project136.utils.SharedPreferencesManager;
import com.example.project136.view.introduce.IntroduceActivity;
import com.example.project136.view.login.LoginActivity;

public class SplashView extends BaseActivity<ActivitySplashBinding> {

    public SplashView() {
        super(ActivitySplashBinding::inflate);
    }

    @Override
    protected void initView() {
        super.initView();
        Handler handler = new Handler();
        SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finishAndRemoveTask();
                if (sharedPreferencesManager.isLoggedIn()) {
                    startActivity(new Intent(SplashView.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashView.this, LoginActivity.class));
                }
            }
        }, 1000);
    }
}