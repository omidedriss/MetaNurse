package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterTest extends AppCompatActivity implements View.OnClickListener {
TextView tvLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_test);
        try {
            this.getActionBar().hide();
        }catch (Exception e){
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        RegisterTest.this.finish();
    }
}