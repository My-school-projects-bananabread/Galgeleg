package com.s195458.galgeleg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//our simple help text screen with some info about the game and an exit button to go back to the menu
public class Help extends AppCompatActivity implements View.OnClickListener {

    Button backBtn;
    TextView HelpTxt1, HelpTxt2, HelpTxt3;

    ImageView helpImgView;

    String text1 = "The goal of the game is to guess the right word";
    String text2 = "Press the buttons on the keyboard at the bottom and try to guess as many words as you can";
    String text3 = "Good luck and have fun";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        HelpTxt1 = findViewById(R.id.HelpTxt1);
        HelpTxt2 = findViewById(R.id.HelpTxt2);
        HelpTxt3 = findViewById(R.id.HelpTxt3);

        HelpTxt1.setText(text1);
        HelpTxt2.setText(text2);
        HelpTxt3.setText(text3);

        helpImgView= findViewById(R.id.helpImgView);
        helpImgView.setImageResource(R.drawable.dead10);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setText("x");
        backBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == backBtn) {
            finish();
        }
    }

    //disable back button on phone
    @Override
    public void onBackPressed() {
        finish();
    }
}