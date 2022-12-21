package com.example.listapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.listapplication.databinding.AnotherActivityBinding;

public class AnotherActivity extends Activity implements View.OnClickListener {
    private AnotherActivityBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = AnotherActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        findViewById(R.id.finish).setOnClickListener(this);
        Intent intent = getIntent();
        binding.hello.setText( "Привет, "+intent.getStringExtra("Name"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.finish:
                finish();
                break;
        }
    }
}
