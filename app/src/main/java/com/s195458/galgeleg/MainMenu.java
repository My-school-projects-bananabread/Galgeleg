package com.s195458.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;

import com.s195458.galgeleg.controller.HighscoreController;
import com.s195458.galgeleg.model.Highscore;



public class MainMenu extends AppCompatActivity implements OnClickListener {
    // Vi erklærer variabler herude så de huskes fra metode til metode
    Button playBtn, highscoreBtn, /*settingsBtn,*/ helpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        playBtn = findViewById(R.id.playBtn);
        playBtn.setText("Play");

        highscoreBtn = findViewById(R.id.highscoreBtn);
        highscoreBtn.setText("Highscore");

        /*
        settingsBtn = findViewById(R.id.settingsBtn);
        settingsBtn.setText("Settings");
         */

        helpBtn = findViewById(R.id.helpBtn);
        helpBtn.setText("Help");

        playBtn.setOnClickListener(this);
        highscoreBtn.setOnClickListener(this);
        //settingsBtn.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
        if (v == playBtn) {

            Intent i = new Intent(this, Game.class);
            startActivity(i);

        } /*else if (v == settingsBtn) {

            Intent i = new Intent(this, Help.class);
            startActivity(i);



        } */ else if (v == highscoreBtn) {

            Intent i = new Intent(this, HighscoreScreen.class);
            startActivity(i);

        } else if (v == helpBtn) {

            Intent i = new Intent(this, Help.class);
            startActivity(i);

        }
    }

    //disable back button on phone
    @Override
    public void onBackPressed() {
    }
}
