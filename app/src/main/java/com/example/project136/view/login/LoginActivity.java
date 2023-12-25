package com.example.project136.view.login;

import android.content.Intent;
import com.example.project136.base.BaseActivity;
import com.example.project136.databinding.ActivityLoginBinding;
import com.example.project136.utils.ConfirmDialog;
import com.example.project136.utils.SharedPreferencesManager;
import com.example.project136.view.introduce.IntroduceActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    public LoginActivity() {
        super(ActivityLoginBinding::inflate);
    }

    @Override
    protected void initView() {
        super.initView();
        binding.btnLogin.setOnClickListener(v -> {
            SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);
            sharedPreferencesManager.setLoggedIn(true);
            finishAndRemoveTask();
            Intent intent = new Intent(LoginActivity.this, IntroduceActivity.class);
            startActivity(intent);
        });
        binding.btnClose.setOnClickListener(v -> {
            ConfirmDialog.showConfirmDialog(
                    this,
                    "Bạn có muốn thoát khỏi ứng dụng hay không?",
                    "Chọn có để xác nhận",
                    "Có",
                    "Không",
                    new ConfirmDialog.ConfirmationDialogListener() {
                        @Override
                        public void onPositiveButtonClicked() {
                            finishAndRemoveTask();
                        }

                        @Override
                        public void onNegativeButtonClicked() {

                        }
                    }
            );
        });
    }
}