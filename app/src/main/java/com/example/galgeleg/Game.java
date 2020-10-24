package com.example.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity implements View.OnClickListener{

    //keyboard buttons
    Button  LtrA, LtrB, LtrC, LtrD, LtrE, LtrF, LtrG, LtrH, LtrI, LtrJ,
            LtrK, LtrL, LtrM, LtrN, LtrO, LtrP, LtrQ, LtrR, LtrS, LtrT,
            LtrU, LtrV, LtrW, LtrX, LtrY, LtrZ, LtrAE, LtrOE, LtrAA;

    Button returnFromGame;
    TextView wordTxtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        returnFromGame = findViewById(R.id.gameBackBtn);
        returnFromGame.setText("Return From Game");

        returnFromGame.setOnClickListener(this);

        declareButtons();

        wordTxtView = findViewById(R.id.wordTxtView);
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
        if (v == returnFromGame) {

            wordTxtView.setText("kage");

            finish();

        }

        if (v != returnFromGame){
            Button btn = findViewById(v.getId());
            String clickedBtnText = btn.getText().toString();
            wordTxtView.setText(clickedBtnText);
        }

    }


        //disable back button on phone
    @Override
    public void onBackPressed() {
    }

    public void declareButtons() {
        if(true){
            LtrA = findViewById(R.id.LtrA);
            LtrB = findViewById(R.id.LtrB);
            LtrC = findViewById(R.id.LtrC);
            LtrD = findViewById(R.id.LtrD);
            LtrE = findViewById(R.id.LtrE);
            LtrF = findViewById(R.id.LtrF);
            LtrG = findViewById(R.id.LtrG);
            LtrH = findViewById(R.id.LtrH);
            LtrI = findViewById(R.id.LtrI);
            LtrJ = findViewById(R.id.LtrJ);
            LtrK = findViewById(R.id.LtrK);
            LtrL = findViewById(R.id.LtrL);
            LtrM = findViewById(R.id.LtrM);
            LtrN = findViewById(R.id.LtrN);
            LtrO = findViewById(R.id.LtrO);
            LtrP = findViewById(R.id.LtrP);
            LtrQ = findViewById(R.id.LtrQ);
            LtrR = findViewById(R.id.LtrR);
            LtrS = findViewById(R.id.LtrS);
            LtrT = findViewById(R.id.LtrT);
            LtrU = findViewById(R.id.LtrU);
            LtrV = findViewById(R.id.LtrV);
            LtrW = findViewById(R.id.LtrW);
            LtrX = findViewById(R.id.LtrX);
            LtrY = findViewById(R.id.LtrY);
            LtrZ = findViewById(R.id.LtrZ);
            LtrAE = findViewById(R.id.LtrAE);
            LtrOE = findViewById(R.id.LtrOE);
            LtrAA = findViewById(R.id.LtrAA);
        }//findViewById
        if(true){
            LtrA.setOnClickListener(this);
            LtrB.setOnClickListener(this);
            LtrC.setOnClickListener(this);
            LtrD.setOnClickListener(this);
            LtrE.setOnClickListener(this);
            LtrF.setOnClickListener(this);
            LtrG.setOnClickListener(this);
            LtrH.setOnClickListener(this);
            LtrI.setOnClickListener(this);
            LtrJ.setOnClickListener(this);
            LtrK.setOnClickListener(this);
            LtrL.setOnClickListener(this);
            LtrM.setOnClickListener(this);
            LtrN.setOnClickListener(this);
            LtrO.setOnClickListener(this);
            LtrP.setOnClickListener(this);
            LtrQ.setOnClickListener(this);
            LtrR.setOnClickListener(this);
            LtrS.setOnClickListener(this);
            LtrT.setOnClickListener(this);
            LtrU.setOnClickListener(this);
            LtrV.setOnClickListener(this);
            LtrW.setOnClickListener(this);
            LtrX.setOnClickListener(this);
            LtrY.setOnClickListener(this);
            LtrZ.setOnClickListener(this);
            LtrAE.setOnClickListener(this);
            LtrOE.setOnClickListener(this);
            LtrAA.setOnClickListener(this);
        }//setOnClickListener
        if(true){
            LtrA.setText("A");
            LtrB.setText("B");
            LtrC.setText("C");
            LtrD.setText("D");
            LtrE.setText("E");
            LtrF.setText("F");
            LtrG.setText("G");
            LtrH.setText("H");
            LtrI.setText("I");
            LtrJ.setText("J");
            LtrK.setText("K");
            LtrL.setText("L");
            LtrM.setText("M");
            LtrN.setText("N");
            LtrO.setText("O");
            LtrP.setText("P");
            LtrQ.setText("Q");
            LtrR.setText("R");
            LtrS.setText("S");
            LtrT.setText("T");
            LtrU.setText("U");
            LtrV.setText("V");
            LtrW.setText("W");
            LtrX.setText("X");
            LtrY.setText("Y");
            LtrZ.setText("Z");
            LtrAE.setText("Æ");
            LtrOE.setText("Ø");
            LtrAA.setText("Å");
        }//setText
    }
}
