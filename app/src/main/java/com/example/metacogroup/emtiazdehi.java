package com.example.metacogroup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class emtiazdehi extends AppCompatActivity {
    Button btn;
    TextView feedback;
    RatingBar rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emtiazdehi);
        feedback =findViewById(R.id.rezayat);
        rb =findViewById(R.id.ratingBar);

        rb.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {

            if (rating == 0) {
                feedback.setText("ناراضی");

            }
            else if (rating == 1) {
                feedback.setText("بد نبود");
            }
            else if (rating == 2 || rating == 3) {
                feedback.setText("راضی");

            }
            else if (rating == 4) {
                feedback.setText("رضایتمند");
            }
            else if (rating == 5)
            {
                feedback.setText("عالی");

            }



        });

    }

    public void goback(View view) {
        btn =findViewById(R.id.goback);
        Intent intent =new Intent(this,NursePanelLogin.class);
        startActivity(intent);
    }


    public void send(View view) {
        Intent it =new Intent(this,NursePanelRecycle.class);
        startActivity(it);
        Toast.makeText(this,"ممنون بابت ارسال نظر",Toast.LENGTH_LONG).show();
        finish();

    }

}

