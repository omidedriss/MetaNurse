package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.validation.Validator;

public class signup extends AppCompatActivity {
TextView vorud,backLogin;
Button btSingUp;
EditText password,confirmPassword,name,family,codMeli,phoneNumber,codePersonally;
RadioButton doctor,nurse,pationt;
int codeMeli1,codePersonaly1,number1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        entry();
        Typeface font = Typeface.createFromAsset(getAssets(), "saeidian_font/BNazanin.ttf");
        vorud.setTypeface(font);
    }
    public void entry (){
        vorud=findViewById(R.id.signup);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmpassword);
        codePersonally = findViewById(R.id.codepersonally);
        name = findViewById(R.id.name);
        family = findViewById(R.id.family);
        codMeli= findViewById(R.id.codemeli);
        phoneNumber = findViewById(R.id.phone);
        doctor = findViewById(R.id.doctor);
        nurse = findViewById(R.id.nurse);
        pationt = findViewById(R.id.patient);
        backLogin = findViewById(R.id.haveaccount);
        btSingUp = findViewById(R.id.signup_btn);
        pationt.setChecked(true);
        btSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

 /*           if(!pationt.isChecked()){

            }*/
                if(password.getText().toString().equalsIgnoreCase(confirmPassword.getText().toString())
                        &&phoneNumber.getText().toString().startsWith("09")&&phoneNumber.getText().toString().length()==11&&
                        codMeli.getText().toString().length()==10){
                    Intent i = new Intent(getApplicationContext(),getcode.class);
                    putExtra();
                    startActivity(i);
            }

               else {
                    Toast.makeText(getApplicationContext(),"اطالاعات وارد شده نادرست است",Toast.LENGTH_LONG).show();
                }
            }
        });





        backLogin.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),login.class);
            startActivity(i);
            finish();
        });
    }
    public void putExtra(){
       // codeMeli1 = Integer.getInteger(codMeli.getText().toString());
       // codePersonaly1 = Integer.getInteger(codePersonally.getText().toString());
       // number1 = Integer.getInteger(phoneNumber.getText().toString());
            SharedPreferences shareName = getSharedPreferences("namee", Context.MODE_PRIVATE);
             SharedPreferences.Editor editor = shareName.edit();
                  editor.putString("namee",String.valueOf(name.getText()));
                  editor.putString("familyy",String.valueOf(family.getText()));
                  editor.putString("number",String.valueOf(phoneNumber.getText()));
                  editor.putString("passwordd",String.valueOf(password.getText()));
                  editor.putString("codmeli",codMeli.getText().toString());
                  editor.putString("codepersonally",codePersonally.getText().toString());
                  editor.commit();
    }
}