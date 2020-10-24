package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

/*Skærme

    Hovedmenu           ✓
    Selve spillet       x
        du har vundet skærmbillede     x
        du har tab skærmbillede        x
    Hjælp skærm         x
    Highscore           x

 */

//HUSK MANIFEST NÅR DER LAVES NYE FILER!!! TIL INTENTS!!!

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.help);

        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);

        //Intent i = new Intent(view.getContext(), MainMenu.class);
        //startActivity(i);
    }

    //disable back button on phone
    @Override
    public void onBackPressed() {
    }
}