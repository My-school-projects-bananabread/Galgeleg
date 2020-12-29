package com.s195458.galgeleg;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.s195458.galgeleg.controller.HighscoreController;
import com.s195458.galgeleg.model.Highscore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*
mulig format til fremtiden

no.     name/date       score
1       abb             5
2       fad             3
...
 */

public class HighscoreScreen extends AppCompatActivity implements View.OnClickListener {
    Button backBtn;
    TextView highscoreTxtTitle;
    ListView highscoreListView;

    ArrayList<Highscore> highscores;
    HighscoreController hc = new HighscoreController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setText("x");
        backBtn.setOnClickListener(this);

        highscoreTxtTitle = findViewById(R.id.highscoreTxtTitle);
        highscoreTxtTitle.setText("Highscores");

        hc.getHighscores(getApplicationContext());

        //listview for highscores
        highscoreListView = findViewById(R.id.highscoreListView);
        showlistview();
    }

    public void showlistview(){
        highscores = hc.getHighscores(getApplicationContext());

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.listeelement, R.id.listeelem_overskrift, highscores) {
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView overskrift = view.findViewById(R.id.listeelem_overskrift);
                String tmpscore = Integer.toString(highscores.get(position).getScore());
                overskrift.setText(tmpscore);

                TextView beskrivelse = view.findViewById(R.id.listeelem_beskrivelse);
                DateFormat df = new SimpleDateFormat();
                String tmpdate = df.format(highscores.get(position).getDate());
                beskrivelse.setText(tmpdate);

                System.out.println("lort");
                return view;
            }
        };

        highscoreListView.setAdapter(adapter);
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
