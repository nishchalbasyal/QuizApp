package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String[] questions = {"Loard Buddha was Born in Nepal?",
            "Taj Mahal lies in India?",
            "Mount Kailash is the Tallest Mountain in the World?",
            "America is the Most Powerful Country in the World?",
            "Python is the Most loved Language?",
            "Progamming is Easy",
            "The Monkey has 32 teeth?"};
    private final boolean[] answers = {true,true,false,true,true,false,false};

    private int score = 0;
    private int index = 0;
    Button yes, no,reset;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes = findViewById(R.id.button);
        no = findViewById(R.id.button2);
        reset = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);
        textView.setText(questions[index]);



        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (index <= questions.length - 1) {

                    if (answers[index]) {
                        score++;
                    }

                    index++;
                    if (index <= questions.length - 1) {
                        textView.setText(questions[index]);
                    } else {
                        showScore(score);
//                            Toast.makeText(MainActivity.this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });



        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (index <= questions.length - 1) {

                    if (!answers[index]) {
                        score++;
                    }

                    index++;
                    if (index <= questions.length - 1) {
                        textView.setText(questions[index]);
                    } else {
                        showScore(score);
//                            Toast.makeText(MainActivity.this, "Your Score is " + score, Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetQuiz();
            }
        });



    }

    private void showScore(int score){
        new AlertDialog.Builder(this).setTitle("Your Score is "+score).setPositiveButton("Replay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetQuiz();
            }
        }).show();
    }

    private void resetQuiz() {
        score = 0;
        index = 0;
        textView.setText(questions[index]);
    }


}