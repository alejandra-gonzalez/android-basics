package com.example.android.biologyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    RadioButton answerForQuestion1;
    CheckBox answer1ForQuestion2;
    CheckBox option2;
    CheckBox answer2ForQuestion2;
    CheckBox option4;
    EditText answerForQuestion3;
    RadioButton answerForQuestion4;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answerForQuestion1 = (RadioButton) findViewById(R.id.q1Option3);
        answer1ForQuestion2 = (CheckBox) findViewById(R.id.q2Answer1);
        option2 = (CheckBox) findViewById(R.id.q2Answer2);
        answer2ForQuestion2 = (CheckBox) findViewById(R.id.q2Answer3);
        option4 = (CheckBox) findViewById(R.id.q2Answer4);
        answerForQuestion3 = (EditText) findViewById(R.id.q3Response);
        answerForQuestion4 = (RadioButton) findViewById(R.id.q4Answer);
    }

    public void submitQuiz(View v) {
        if (answerForQuestion1.isChecked()) {
            score += 1;
        }
        if (answer1ForQuestion2.isChecked() && answer2ForQuestion2.isChecked() &&
                !option2.isChecked() && !option4.isChecked()) {
            score += 1;
        }
        if (answerForQuestion3.getText().toString().equals("0")) {
            score += 1;
        }
        if (answerForQuestion4.isChecked()) {
            score += 1;
        }

        if (score == 1) {
            Toast.makeText(this, getString(R.string.oneQuestion), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.youGot) + score +
                    getString(R.string.questions), Toast.LENGTH_SHORT).show();
        }
        score = 0;
    }
}
