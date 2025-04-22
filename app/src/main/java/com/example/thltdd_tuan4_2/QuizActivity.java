package com.example.thltdd_tuan4_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    TextView tvQuestion;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3, option4;
    Button btnNext;

    String[] questions = {
            "Loài vật nào đi bằng đầu ?",
            "Nếu có 4 con chim đậu trên cành, bạn bắn rơi 1 con. Hỏi còn mấy con?",
            " 77 + 33?",
            "Cái gì luôn ở phía trước bạn nhưng bạn không bao giờ nhìn thấy được?",
            "Cái gì càng giặt càng bẩn?"
    };

    String[][] options = {
            {"Con rắn", "Con bò", "Con kiến", "Con voi"},
            {"0", "1", "2", "3"},
            {"100", "99", "110", "103"},
            {"Cái bóng", "Quá khứ", "Tương lai", "Mũi của bạn"},
            {"Áo trắng", "Nước sông", "Máy giặt", "Quần tây"}
    };

    String[] correctAnswers = {
            "Con rắn", "0", "110", "Tương lai", "Máy giặt"
    };

    int currentQuestion = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvQuestion = findViewById(R.id.tvQuestion);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnNext = findViewById(R.id.btnNext);

        loadQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedOption = findViewById(selectedId);
                String answer = selectedOption.getText().toString();

                if (answer.equals(correctAnswers[currentQuestion])) {
                    score += 20;
                }

                currentQuestion++;

                if (currentQuestion < questions.length) {
                    loadQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    void loadQuestion() {
        tvQuestion.setText(questions[currentQuestion]);
        option1.setText(options[currentQuestion][0]);
        option2.setText(options[currentQuestion][1]);
        option3.setText(options[currentQuestion][2]);
        option4.setText(options[currentQuestion][3]);
        radioGroup.clearCheck();
    }
}
