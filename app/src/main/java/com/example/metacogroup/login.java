package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
EditText pass,codePersonally;
TextView singUp,forgetPass;
Button buttonLogin;
private String name,family,password;
private String codmeli , codPersonally , number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        entry();
        inPut();
        //checker();
    }
    //هنگام اجرا برنامه ادیت  تکس ها و ... مچ میشن
    public void entry (){
        pass = findViewById(R.id.passwordlogin);
        codePersonally = findViewById(R.id.codemelipersoneli);
        singUp = findViewById(R.id.donthaveacount);
        forgetPass = findViewById(R.id.forgetpassword);
        buttonLogin = findViewById(R.id.login_btn);
        singUp.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),signup.class);
            startActivity(i);
            finish();
                });
        forgetPass.setOnClickListener(v -> {
          //  Intent i = new Intent(getApplicationContext(),forget.class);
           // startActivity(i);
        });
    }
    //دریافت اطلاعات از sharepreferences
    public void inPut (){
        SharedPreferences shareName = getSharedPreferences("namee", Context.MODE_PRIVATE);
        name = shareName.getString("namee","noName");
       // SharedPreferences shareFamily = getSharedPreferences("family", Context.MODE_PRIVATE);
        family = shareName.getString("familyy","noFamily");
      //  SharedPreferences sharePassword = getSharedPreferences("password", Context.MODE_PRIVATE);
        password = shareName.getString("passwordd","noPass");
       // SharedPreferences shareCodmeli = getSharedPreferences("codmeli", Context.MODE_PRIVATE);
        codmeli = shareName.getString("codmeli","0");
       // SharedPreferences shareCodePersonally = getSharedPreferences("codepersonally", Context.MODE_PRIVATE);
        codPersonally = shareName.getString("codepersonally","0");
       // SharedPreferences shareNumber = getSharedPreferences("codepersonally", Context.MODE_PRIVATE);
        number = shareName .getString("number","0");
    }
/*    public void checker (){
        if(codmeli !=0 && codPersonally != 0){
            codePersonally.setText(codPersonally);
        }else if(codPersonally == 0 && codmeli !=0 ){
            codePersonally.setText(codmeli);
        }
        if(password.startsWith("noPass")){
            Toast.makeText(getApplicationContext(),password,Toast.LENGTH_LONG).show();
        }else {
            pass.setText(password);
        }
    }*/

}