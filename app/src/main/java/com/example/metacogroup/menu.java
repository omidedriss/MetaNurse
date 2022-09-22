package com.example.metacogroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.exit_menu) {
            Toast.makeText(getApplicationContext(), "صفحه خروج اجباری :)", Toast.LENGTH_LONG).show();

        }
        if(item.getItemId()==R.id.exit_login) {
            Toast.makeText(getApplicationContext(), "صفحه خروج اجباری :)", Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

}