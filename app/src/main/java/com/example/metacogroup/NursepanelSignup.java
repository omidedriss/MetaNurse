package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class NursepanelSignup extends AppCompatActivity implements View.OnClickListener {
TextView vorud,backLogin;
AppCompatButton signUp_ss;
EditText password,confirmPassword,name,family,codMeli,phoneNumber,codePersonally;
RadioButton doctor,nurse,pationt;
RadioGroup radioGroup;
String message;
    TextView tvLogin;
int codeMeli1,codePersonaly1,number1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_test);
        entry();
       try {
            this.getActionBar().hide();
        }catch (Exception e){
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
        }

//        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/BNazanin.ttf");
//        vorud.setTypeface(font);
        password .setTextColor(Color.BLACK);
        confirmPassword.setTextColor(Color.BLACK);
        name.setTextColor(Color.BLACK);
//        family.setTextColor(Color.BLACK);
        codMeli.setTextColor(Color.BLACK);
        phoneNumber.setTextColor(Color.BLACK);
//        codePersonally.setTextColor(Color.BLACK);
    }
    @Override
    public void onClick(View v) {
        NursepanelSignup.this.finish();
    }

    public void entry (){
       // vorud=findViewById(R.id.signup);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmpassword);
        //codePersonally = findViewById(R.id.codepersonally);
        name = findViewById(R.id.name);
        //family = findViewById(R.id.family);
        codMeli= findViewById(R.id.codemelipersoneli);
        phoneNumber = findViewById(R.id.phone);
        signUp_ss = findViewById(R.id.signup_ss);

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length()> 10){
                    password.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        doctor = findViewById(R.id.doctor);
//        nurse = findViewById(R.id.nurse);
//        radioGroup = findViewById(R.id.radioGroup);
//        pationt = findViewById(R.id.patient);
 //       backLogin = findViewById(R.id.haveaccount);
//        nurse.setChecked(true);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(pationt.isChecked()){
//                    codePersonally.setEnabled(false);
//                    codePersonally.setText("");
//                    codePersonally.setHint("???? ???????????? ?????? ????????");
//                }else {
//                    codePersonally.setEnabled(true);
//                    codePersonally.setHint("???? ???????????? ????????");}
//            }
     //   });
        signUp_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().equalsIgnoreCase(confirmPassword.getText().toString())
                        && phoneNumber.getText().toString().startsWith("09") && phoneNumber.getText().toString().length() == 11 &&
                        codMeli.getText().toString().length() == 10) {
                    putExtra();
                    Random random = new Random();
                    int val = random.nextInt(1000000);
                    message = (Integer.toString(val));
                    SmsManager mySmsManager = SmsManager.getDefault();
                    mySmsManager.sendTextMessage(phoneNumber.getText().toString(), null, message, null, null);
                    Intent i = new
                            Intent(NursepanelSignup.this, NursePanelSmsVerificationCode.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("code", message);
                    i.putExtras(bundle);
                    confirmPassword.setError("?????????? ?????????? ???? ?????????? ?????? ????????");
                    confirmPassword.requestFocus();
                    startActivity(i);}
//            if (TextUtils.isEmpty(phone.getText().toString())) {
//                Toast.makeText(saeidian_login2.this, "Enter a valid Number", Toast.LENGTH_SHORT).show();
//            } else {
//                String number = phone.getText().toString();
//                sendverificationcode(number);
//            }

                 else {
                    if(name.getText().toString().isEmpty())
                    {
                        name.setError("?????? ?????? ???? ???????? ????????");
                        name.requestFocus();
//                    } else if(family.getText().toString().isEmpty()){
//                        family.setError("???????? ???? ?????????? ????????");
//                        family.requestFocus();
                    }else if(codMeli.getText().toString().isEmpty()) {
                        codMeli.setError("???? ?????? ???? ???????? ???????? ????????");
                        codMeli.requestFocus();
                    }
//                   else if(codePersonally.getText().toString().isEmpty() && !pationt.isChecked()){
//                        codePersonally.setError("???? ???????????? ?????? ???? ???????? ????????");
//                        codePersonally.requestFocus();
                    else if(phoneNumber.getText().toString().isEmpty() ||
                            !phoneNumber.getText().toString().startsWith("09")){
                        phoneNumber.setError("?????????? ?????????? ???? ???????? ???????? ????????");
                        phoneNumber.requestFocus();
                    }else if(password.getText().toString().isEmpty()){
                        password.setError("?????????? ?????? ???? ???????? ????????");
                        password.requestFocus();
                    }else if(confirmPassword.getText().toString().isEmpty()) {

                        confirmPassword.setError("???????? ???? ?????????? ????????");
                        confirmPassword.requestFocus();
                    }

                }
            }
        });





//        backLogin.setOnClickListener(v -> {
//            Intent i = new Intent(getApplicationContext(), NursePanelLogin.class);
//            startActivity(i);
//            finish();
//        });
    }
    public void putExtra(){
       // codeMeli1 = Integer.getInteger(codMeli.getText().toString());
       // codePersonaly1 = Integer.getInteger(codePersonally.getText().toString());
       // number1 = Integer.getInteger(phoneNumber.getText().toString());
            SharedPreferences shareName = getSharedPreferences("namee", Context.MODE_PRIVATE);
             SharedPreferences.Editor editor = shareName.edit();
                  editor.putString("namee",String.valueOf(name.getText()));
//                  editor.putString("familyy",String.valueOf(family.getText()));
                  editor.putString("number",String.valueOf(phoneNumber.getText()));
                  editor.putString("passwordd",String.valueOf(password.getText()));
                  editor.putString("codmeli",codMeli.getText().toString());
                 // editor.putString("codepersonally",codePersonally.getText().toString());
                  editor.commit();
    }


}