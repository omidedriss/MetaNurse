package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class shadowlogintest extends AppCompatActivity implements View.OnClickListener {
    TextView tvSignUp;
    TextView tvSignUpSecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadowlogintest);
       // AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        try {
            this.getActionBar().hide();
        }catch (Exception e){

            setContentView(R.layout.activity_shadowlogintest);
            tvSignUp = findViewById(R.id.signup);

            tvSignUp.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),NursepanelSignup.class);
        shadowlogintest.this.startActivity(intent);
    }
}