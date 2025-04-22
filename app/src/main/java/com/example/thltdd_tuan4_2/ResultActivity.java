package com.example.thltdd_tuan4_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView tvFinalScore;
    Button btnPlayAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvFinalScore = findViewById(R.id.tvFinalScore);
        btnPlayAgain = findViewById(R.id.btnPlayAgain);

        // Lấy điểm từ intent
        int score = getIntent().getIntExtra("SCORE", 0);
        tvFinalScore.setText("Your Score: " + score);

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
