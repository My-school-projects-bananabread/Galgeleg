package com.example.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/* game loop
1. enters game
2. tries to guess word with total lives = 10
    2.a if word correct reset game/screen and score += 1, total lives -= 2
    2.b if out of lives show score and correct word, then exit
        2.b.a save score to highscore place somehow

*/

public class Game extends AppCompatActivity implements View.OnClickListener{

    //layout
    Button  LtrA, LtrB, LtrC, LtrD, LtrE, LtrF, LtrG, LtrH, LtrI, LtrJ, //keyboard buttons
            LtrK, LtrL, LtrM, LtrN, LtrO, LtrP, LtrQ, LtrR, LtrS, LtrT,
            LtrU, LtrV, LtrW, LtrX, LtrY, LtrZ, LtrAE, LtrOE, LtrAA;
    Button returnFromGame;
    TextView wordTxtView, livesTxtView, scoreTxtView;

    //game variables
    String guessWord;
    String displayedWordString;
    char[] displayedWordArray;
    ArrayList<String> wordList;
    String triedLetters;
    int lives;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        declareButtons();

        //setup the game
        setupGame();

        //random
        returnFromGame = findViewById(R.id.gameBackBtn);
        returnFromGame.setText("Return From Game");
        returnFromGame.setOnClickListener(this);
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
        if (v == returnFromGame) {
            finish();
        }

        //clicked a letter on the keyboard
        if (v != returnFromGame){

            //disable button get text
            boolean guessedAWord = false;

            Button btn = findViewById(v.getId());
            String clickedBtnText = btn.getText().toString();
            char letter = clickedBtnText.charAt(0);
            btn.setEnabled(false);
            btn.setBackgroundColor(555555);

            //show correct letters
            for(int i = 0; i < guessWord.length(); i++){

            }

            //wrong or correct
            if(guessWord.indexOf(letter) >= 0 ){

                displayedWordArray[guessWord.indexOf(letter)] = letter;
                displayedWordString = String.valueOf(displayedWordArray);
                wordTxtView.setText(displayedWordString);

                if(!displayedWordString.contains("_")){
                    score +=1;
                    resetGame();
                }

            } else {
                lives -= 1;
            }
            if (lives < 0){
                //skal gøre så scoren bliver gemt
                finish();
            } else {
                livesTxtView.setText(String.valueOf(lives));
            }
        }

    }

    public void setupGame() {
        //Variables
        wordList = new ArrayList<String>();
        wordTxtView = findViewById(R.id.wordTxtView);

        lives = 10;
        livesTxtView = findViewById(R.id.livesTxtView);
        livesTxtView.setText(String.valueOf(lives));
        score = 0;
        scoreTxtView = findViewById(R.id.scoreTxtView);
        scoreTxtView.setText(String.valueOf(score));

        //fill up word list
        InputStream inputStream = null;
        Scanner WordScanner = null;
        String wordtmp;

        try {
            inputStream = getAssets().open("wordList.txt");
            WordScanner = new Scanner(inputStream);
            while(WordScanner.hasNext()){
                wordtmp = WordScanner.next();
                wordList.add(wordtmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
            //Toast.makeText(this, e.getClass().getSimpleName() + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            if(WordScanner!=null){
                WordScanner.close();
            }
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //shuffle, get first word, remove from list
        Collections.shuffle(wordList);
        resetGame();
    }

    public void resetGame(){
        guessWord = wordList.get(0).toUpperCase();
        wordList.remove(0);

        //display word
        displayedWordArray = guessWord.toCharArray();
        Arrays.fill(displayedWordArray, '_');

        displayedWordString = String.valueOf(displayedWordArray);
        wordTxtView.setText(displayedWordString);
        enableAllButtons();

        //score and lives
        if(score >= 10){
            lives = 0;
        } else {
            lives = 10-score;
        }
        livesTxtView.setText(String.valueOf(lives));
        scoreTxtView.setText(String.valueOf(score));
    }

    //disable back button on phone
    @Override
    public void onBackPressed() {}

    public void enableAllButtons(){
        if(true){
            LtrA.setEnabled(true);
            LtrB.setEnabled(true);
            LtrC.setEnabled(true);
            LtrD.setEnabled(true);
            LtrE.setEnabled(true);
            LtrF.setEnabled(true);
            LtrG.setEnabled(true);
            LtrH.setEnabled(true);
            LtrI.setEnabled(true);
            LtrJ.setEnabled(true);
            LtrK.setEnabled(true);
            LtrL.setEnabled(true);
            LtrM.setEnabled(true);
            LtrN.setEnabled(true);
            LtrO.setEnabled(true);
            LtrP.setEnabled(true);
            LtrQ.setEnabled(true);
            LtrR.setEnabled(true);
            LtrS.setEnabled(true);
            LtrT.setEnabled(true);
            LtrU.setEnabled(true);
            LtrV.setEnabled(true);
            LtrW.setEnabled(true);
            LtrX.setEnabled(true);
            LtrY.setEnabled(true);
            LtrZ.setEnabled(true);
            LtrAE.setEnabled(true);
            LtrOE.setEnabled(true);
            LtrAA.setEnabled(true);
        }
        if(true){
            LtrA.setBackgroundResource(R.drawable.rounded_button);
            LtrB.setBackgroundResource(R.drawable.rounded_button);
            LtrC.setBackgroundResource(R.drawable.rounded_button);
            LtrD.setBackgroundResource(R.drawable.rounded_button);
            LtrE.setBackgroundResource(R.drawable.rounded_button);
            LtrF.setBackgroundResource(R.drawable.rounded_button);
            LtrG.setBackgroundResource(R.drawable.rounded_button);
            LtrH.setBackgroundResource(R.drawable.rounded_button);
            LtrI.setBackgroundResource(R.drawable.rounded_button);
            LtrJ.setBackgroundResource(R.drawable.rounded_button);
            LtrK.setBackgroundResource(R.drawable.rounded_button);
            LtrL.setBackgroundResource(R.drawable.rounded_button);
            LtrM.setBackgroundResource(R.drawable.rounded_button);
            LtrN.setBackgroundResource(R.drawable.rounded_button);
            LtrO.setBackgroundResource(R.drawable.rounded_button);
            LtrP.setBackgroundResource(R.drawable.rounded_button);
            LtrQ.setBackgroundResource(R.drawable.rounded_button);
            LtrR.setBackgroundResource(R.drawable.rounded_button);
            LtrS.setBackgroundResource(R.drawable.rounded_button);
            LtrT.setBackgroundResource(R.drawable.rounded_button);
            LtrU.setBackgroundResource(R.drawable.rounded_button);
            LtrV.setBackgroundResource(R.drawable.rounded_button);
            LtrW.setBackgroundResource(R.drawable.rounded_button);
            LtrX.setBackgroundResource(R.drawable.rounded_button);
            LtrY.setBackgroundResource(R.drawable.rounded_button);
            LtrZ.setBackgroundResource(R.drawable.rounded_button);
            LtrAE.setBackgroundResource(R.drawable.rounded_button);
            LtrOE.setBackgroundResource(R.drawable.rounded_button);
            LtrAA.setBackgroundResource(R.drawable.rounded_button);
        }
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
