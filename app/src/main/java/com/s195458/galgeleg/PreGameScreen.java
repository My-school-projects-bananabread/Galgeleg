package com.s195458.galgeleg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PreGameScreen extends AppCompatActivity implements View.OnClickListener {
    Button backBtn;
    private Button start;
    private TextView pregametitleTxtView;
    private String yourFinalScoreTxt;
    ListView wordtypesListView;
    ArrayList<String> WordsTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregame);
        pregametitleTxtView = findViewById(R.id.pregametitleTxtView);
        pregametitleTxtView.setText("Choose Words");

        backBtn = findViewById(R.id.backBtn);
        backBtn.setText("x");
        backBtn.setOnClickListener(this);

        wordtypesListView = findViewById(R.id.wordtypesListView);

        WordsTypes = new ArrayList<String>();
        WordsTypes.add("Internet");
        WordsTypes.add("Local");

        displayWordTypes();
    }


    public void displayWordTypes(){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, R.layout.simpelt_listeelement,
                WordsTypes );

        wordtypesListView.setAdapter(arrayAdapter);

        wordtypesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(WordsTypes.get(position));

                Intent i = new Intent(view.getContext(), Game.class);
                i.putExtra("WordsType", WordsTypes.get(position));
                startActivity(i);
                finish();
            }
        });
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
        if (v == backBtn) {
            finish();
        }
    }
    public void onBackPressed() {
        finish();
    }
}