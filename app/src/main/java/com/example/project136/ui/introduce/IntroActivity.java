package com.example.project136.ui.introduce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

import com.example.project136.ui.login.LoginActivity;
import com.example.project136.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ConstraintLayout introBtn = findViewById(R.id.introBtn);
        introBtn.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this, LoginActivity.class)));

    }
}