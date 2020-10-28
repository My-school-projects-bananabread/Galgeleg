package com.example.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Help extends AppCompatActivity implements View.OnClickListener {
    Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setText("x");

        backBtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
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



/*ting vi skal have med

Galgeleg II:

    Bruger interaktion:
        starte projektet                                ✓

        Hovedmenu                                       x
        Selve spillet                                   x
            du har vundet skærmbillede                  x
            du har tab skærmbillede                     x
        Hjælp skærm                                     x
        Highscore                                       x

        Mindst 2 af følgende 3 punkter er opfyldt:      x
            Der vises en liste (ListView eller Recyclerview - f.eks. en highscoreliste)
            Du benytter netværkskommunikation og flertrådet programmering
            F.eks. AsyncTask der henter en liste af ord fra DR med hentOrdFraDr() eller hentOrdFraRegneark()
            Du gemmer nogle data lokalt (f.eks. med PreferenceManager)

        En zip fil:                                     x
            UDEN: .gradle, build og app/build (build i “app”-mappen)

    Software processor osv:

        SOLID principperne er overholdt i din løsning.  x
        Udarbejd et UML diagram af din løsning.         x
        en tekstfil på max 1 side                       x
            der giver et overblik over hvilke patterns du har brugt. Tekstfilen vedlægges projektet.
            Beskriv endvidere din implementering af kommunikationen mellem logikken og Android UI-en ved brug af  patterns.

        overvej og adde det her                         x

            Spiltyper (på tid, på mindste antal gæt, mulighed for at ‘købe’ et bogstav) og sværhedsgrader
            En highscore-liste
            Flere spil i gang samtidig for brugeren
            Flere spil i gang samtidig for forskellige brugere (evt med login)
            Brugere kan dyste mod hinanden - f.eks. ved at skiftes til at gætte på modstanderens ord
            Brugere kan udfordre hinanden - lobbyfunktion, chat


Galgeleg III:
        Torsdag d 09.01.2020

 */