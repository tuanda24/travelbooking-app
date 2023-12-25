package com.example.project136.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {
    private final LayoutInflaterBinding<VB> bindingInflater;
    private VB binding;

    public BaseActivity(LayoutInflaterBinding<VB> bindingInflater) {
        this.bindingInflater = bindingInflater;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = bindingInflater.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        initView();
        handleEvent();
        bindData();
    }

    protected void initData() {

    }

    protected void initView() {

    }

    protected void handleEvent() {

    }

    protected void bindData() {

    }

    public interface LayoutInflaterBinding<VB extends ViewBinding> {
        VB inflate(LayoutInflater inflater);
    }
}