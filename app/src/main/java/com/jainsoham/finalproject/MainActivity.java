package com.jainsoham.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;
    TextView scoreText;
    TextView timeText;
    int time = 60;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = findViewById(R.id.drawView);
        scoreText = findViewById(R.id.scoreText);
        timeText = findViewById(R.id.timeText);

        drawView.setScoreListener(new DrawView.ScoreListener() {
            @Override
            public void onScoreChanged(int score) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        scoreText.setText("Score: " + score);
                    }
                });
            }
        });

        // Start countdown
        startCountdown();
    }

    private void startCountdown() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time--;
                timeText.setText("" + time);
                if (time > 0) {
                    startCountdown();
                } else {
                    loadScoreLayout();
                }
            }
        }, 1000);
    }

    private void loadScoreLayout() {
        View scoreView = LayoutInflater.from(this).inflate(R.layout.score, null);
        setContentView(scoreView);
        TextView finalScore = findViewById(R.id.finalScore);
        finalScore.setText("" + DrawView.getScore());
    }
}
