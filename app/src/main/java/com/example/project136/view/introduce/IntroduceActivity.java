package com.example.project136.view.introduce;

import android.content.Intent;
import com.example.project136.MainActivity;
import com.example.project136.base.BaseActivity;
import com.example.project136.view.login.LoginActivity;
import com.example.project136.utils.SharedPreferencesManager;

public class IntroduceActivity extends BaseActivity<com.example.project136.databinding.ActivityIntroduceBinding> {

    public IntroduceActivity() {
        super(com.example.project136.databinding.ActivityIntroduceBinding::inflate);
    }

    @Override
    protected void initView() {
        super.initView();
        binding.introBtn.setOnClickListener(v -> {
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);
            finishAndRemoveTask();
            if (sharedPreferencesManager.isLoggedIn()) {
                startActivity(new Intent(IntroduceActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(IntroduceActivity.this, LoginActivity.class));
            }
        });
    }

}