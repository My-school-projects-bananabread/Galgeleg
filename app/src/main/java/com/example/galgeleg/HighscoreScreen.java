package com.example.galgeleg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HighscoreScreen extends AppCompatActivity implements View.OnClickListener {
    Button backBtn;
    SharedPreferences prefs;
    TextView myscoreTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setText("x");
        myscoreTxtView = findViewById(R.id.myscoreTxtView);


        backBtn.setOnClickListener(this);

        getScore();
        System.out.println("kage");
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
        if (v == backBtn) {

            finish();
        }
    }

    public void getScore(){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String score = prefs.getString("myscore", "no scores yet");
        myscoreTxtView.setText(score);
    }

    //disable back button on phone
    @Override
    public void onBackPressed() {
        finish();
    }
}
