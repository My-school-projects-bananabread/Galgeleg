package com.s195458.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

//HUSK MANIFEST NÅR DER LAVES NYE FILER!!! TIL INTENTS!!!

//we just use this for opening the main menu
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);
    }

    //disable back button on phone
    @Override
    public void onBackPressed() {
    }
}
