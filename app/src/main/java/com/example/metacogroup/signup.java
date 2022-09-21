package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class signup extends AppCompatActivity {
TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signup=findViewById(R.id.signup);
        Typeface font = Typeface.createFromAsset(getAssets(), "saeidian_font/BNazanin.ttf");

        signup.setTypeface(font);
    }
}