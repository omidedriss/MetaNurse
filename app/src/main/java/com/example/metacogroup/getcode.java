package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class getcode extends AppCompatActivity {
    TextView show_phone;
    EditText enter_phone;
    public String message2,message;
    String phone_read;
    int x=0;
    String code_read;
    String phone="09173929711";
    String code_get;
    TextView print_phone;
    EditText get_code;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getcode);
        ConstraintLayout constraintLayout = findViewById(R.id.color_ss);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        Bundle bundle = getIntent().getExtras();
        print_phone=findViewById(R.id.phone);
        get_code = (EditText) findViewById(R.id.get_code);
        TextView wrongnumber = findViewById(R.id.wrong_number);
        TextView resendcode = findViewById(R.id.resend_code);
        confirm = (Button) findViewById(R.id.confirm);
        get_code.setTextColor(Color.BLACK);

        if (bundle != null) {
            //phone = bundle.getString("email", "nothing");
            SharedPreferences shareName = getSharedPreferences("namee", Context.MODE_PRIVATE);

            phone_read =shareName .getString("number","0");
            code_read = bundle.getString("code", "nothing");
            print_phone.setText(phone_read);
            phone_read = bundle.getString("phone", "nothing");
            get_code.setText(code_read);
        }

//
//        Toast.makeText(saeidian_login3.this, code_get, Toast.LENGTH_SHORT).show();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code_get = get_code.getText().toString();
                //Toast.makeText(saeidian_login3.this, code_get, Toast.LENGTH_SHORT).show();
                if (code_get.equalsIgnoreCase(code_read)|code_get.equalsIgnoreCase(message2)) {

                    showToast();
                    Intent i = new
                            Intent(getcode.this, login.class);
                    Bundle bundle = new Bundle();
                    i.putExtras(bundle);
                    startActivity(i);
                } else {
                    showToast1();
                }
            }
        });
        wrongnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new
                        Intent(getcode.this, signup.class);
                Bundle bundle = new Bundle();
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        resendcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(x<5) {
                    Random random2 = new Random();
                    int val = random2.nextInt(1000000);
                    message2 = (Integer.toString(val));
                    SmsManager mySmsManager = SmsManager.getDefault();
                    mySmsManager.sendTextMessage(phone, null, message2, null, null);
                    get_code.getText().clear();
                    get_code.setText(message2);
                    x++;
                }
                else
                {
                    showToast2();
                    Intent i = new
                            Intent(getcode.this, signup.class);
                    Bundle bundle = new Bundle();
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

//        confirm.setOnClickListener(view ->
//        {
//            if (TextUtils.isEmpty(code.getText().toString())) {
//                Toast.makeText(saeidian_login3.this, "Wrong Sms", Toast.LENGTH_SHORT).show();
//            }
//            else
//                verifycode(code.getText().toString());
//        });

//        ActivityCompat.requestPermissions(saeidian_login3.this, new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
//
////            show_phone = findViewById(R.id.show_phone);
////            enter_phone = (EditText) findViewById(R.id.enter_phone);
//            next = (Button) findViewById(R.id.next);
//
//            next.setOnClickListener((new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Random random = new Random();
//                    int val = random.nextInt(1000000); // save random number in an integer variable
//                    //txt.setText(Integer.toString(val)); //convert to String and set it as text inside the textview
//
//                     message = (Integer.toString(val));
//                     number = enter_phone.getText().toString();
//
//                    SmsManager mySmsManager = SmsManager.getDefault();
//                    mySmsManager.sendTextMessage(number, null, message, null, null);
//                    Intent i = new
//                            Intent(saeidian_login3.this, saeidian_login2.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("sms", message);
//
//                    i.putExtras(bundle);
//                    startActivity(i);
//
//                }
//
//
//
//            }));
    }
    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_custom_toast, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastText.setText("Correct Code");
//            toastImage.setImageResource(R.drawable.ic_toasticon);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 300);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();

    }
    public void showToast1() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_custom_toast, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastText.setText("Wrong Code");
//            toastImage.setImageResource(R.drawable.ic_toasticon);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 300);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();

    }
    public void showToast2() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_custom_toast, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastText.setText("5 بار کد اشتباه وارد شده است لطفا بعدا تلاش نمایید");
//            toastImage.setImageResource(R.drawable.ic_toasticon);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 300);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();

    }
}