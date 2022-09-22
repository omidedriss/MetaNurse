package com.example.metacogroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView =findViewById(R.id.videoView2);
        videoView.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.metaco11);
        videoView.start();
        videoView.setOnCompletionListener(mp -> {
            Intent i = new Intent(MainActivity.this,emtiazdehi.class);
            startActivity(i);
            finish();
        });






    }
}