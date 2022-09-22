package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class editProfile extends AppCompatActivity implements View.OnClickListener {
EditText pName,pFamily,pPhone;
ImageView img;
TextView myCode;
Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        entry();
    }
    public void entry(){
        pName = findViewById(R.id.editName);
        pFamily = findViewById(R.id.editFamily);
        pPhone = findViewById(R.id.editPhone);
        myCode = findViewById(R.id.myCodPersonally);
        img = findViewById(R.id.myPicProfile);
        ok = findViewById(R.id.ok);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ok.getId()){
            pName.setText("");
            pFamily.setText("");
            pPhone.setText("");
            Toast.makeText(getApplicationContext(),"ثبت شد",Toast.LENGTH_LONG).show();
            finish();
        }
    }
}