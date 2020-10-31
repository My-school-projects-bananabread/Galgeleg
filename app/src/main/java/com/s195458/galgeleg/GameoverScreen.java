package com.s195458.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameoverScreen extends AppCompatActivity implements View.OnClickListener {
    Button backBtn;
    private Button exitGameBtn, againGameBtn;
    private TextView gameoverTxtView, correctWordTxtView;
    private String yourFinalScoreTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        displayScreenElements();
    }

    public void displayScreenElements(){
        gameoverTxtView = findViewById(R.id.gameoverTxtView);
        correctWordTxtView = findViewById(R.id.correctWordTxtView);

        exitGameBtn = findViewById(R.id.exitGameBtn);
        exitGameBtn.setOnClickListener(this);

        againGameBtn = findViewById(R.id.againGameBtn);
        againGameBtn.setOnClickListener(this);

        Intent i = getIntent();

        int score = i.getIntExtra("score",0);
        String yourscore = "Score: " + score;
        gameoverTxtView.setText(yourscore);

        String guessword = "WORD: " + i.getStringExtra("guessWord");
        correctWordTxtView.setText(guessword);
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
        if (v == backBtn) {

            finish();
        }
        if (v == againGameBtn){
            Intent i = new Intent(this, Game.class);
            startActivity(i);
            finish();
        }
        if (v == exitGameBtn){
            Intent i = new Intent(this, MainMenu.class);
            startActivity(i);
            finish();
        }
    }
    public void onBackPressed() {
        finish();
    }
}