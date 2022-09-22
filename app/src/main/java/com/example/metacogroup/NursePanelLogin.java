package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NursePanelLogin extends AppCompatActivity {
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
        checker();
        pass.setTextColor(Color.BLACK);
        codePersonally.setTextColor(Color.BLACK);
        buttonLogin.setOnClickListener(v -> {
            if((codePersonally.getText().toString().equalsIgnoreCase(codPersonally)||
                    codePersonally.getText().toString().equalsIgnoreCase(codmeli) && pass.getText().toString().
                            equalsIgnoreCase(password)) ){
                Intent i = new Intent(getApplicationContext(),NursePanelRecycle.class);
                startActivity(i);}
            else
            { showToast();}


        });
    }
    //هنگام اجرا برنامه ادیت  تکس ها و ... مچ میشن
    public void entry (){
        pass = findViewById(R.id.passwordlogin);
        codePersonally = findViewById(R.id.codemelipersoneli);
        singUp = findViewById(R.id.donthaveacount);
        forgetPass = findViewById(R.id.forgetpassword);
        buttonLogin = findViewById(R.id.login_btn);
        singUp.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),NursepanelSignup.class);
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
    public void checker (){
        if(!codmeli .equalsIgnoreCase("0") && !codPersonally .equalsIgnoreCase("0") ){
            codePersonally.setText(codPersonally);
        }else if(codPersonally.equals("0")  && !codmeli.equals("0") ){
            codePersonally.setText(codmeli);
        }
        if(password.startsWith("noPass")){
            Toast.makeText(getApplicationContext(),password,Toast.LENGTH_LONG).show();
        }else {
            pass.setText(password);
        }
    }
    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_custom_toast, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastText.setText("نام کاربری یا پسورد نادرست است");
//            toastImage.setImageResource(R.drawable.ic_toasticon);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 300);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();}

}