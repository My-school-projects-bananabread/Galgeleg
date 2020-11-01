package com.s195458.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.s195458.galgeleg.controller.GameController;

import java.util.ArrayList;


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
    TextView scoreTitleTxtView, livesTitleTxtView;
    ImageView hangmanImgView;

    //game variables
    String guessWord;
    String displayedWordString;
    char[] displayedWordArray;
    ArrayList<String> wordList;
    int lives;
    int score;

    GameController gc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        declareButtons();

        gc = new GameController(getApplicationContext());

        //setup the game
        setupGame();
        //setupGame();
    }

    public void onClick(View v) {
        System.out.println("Der blev trykket på en knap");
        if (v == returnFromGame) {
            finish();
        }

        //clicked a letter on the keyboard
        if (v != returnFromGame /*&& v != exitGameBtn && v != againGameBtn*/){

            //disable button and get text
            Button btn = findViewById(v.getId()); //temp button
            String clickedBtnText = btn.getText().toString();
            char letter = clickedBtnText.charAt(0);
            btn.setEnabled(false);
            btn.setBackgroundColor(555555);

            //wrong or correct
            guessLetter(letter);
            checkGameOver();
        }
    }

    public void guessLetter(char letter){
        if(gc.guessLetter(letter)){
            wordTxtView.setText(String.valueOf(gc.getDisplayedWordString()));
            if(gc.wordIsGuessed()){
                resetGame();
            }
        }
    }

    public void checkGameOver(){
        if(gc.checkGameOver()){
            endgame();
        } else{
            livesTxtView.setText(String.valueOf(gc.getLives()));
            updateHangmanImage();
        }
    }

    public void endgame() {
        gc.saveScore();

        disableAllButtons();
        hangmanImgView.setImageResource(R.drawable.dead10);

        Intent i = new Intent(this, GameoverScreen.class);
        i.putExtra("score", gc.getScore());
        i.putExtra("guessWord", gc.getGuessWord());
        startActivity(i);
        finish();
    }



/*
//really cool popup when you lose but can't use it :(

    //gameoverdialog
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Button exitGameBtn, againGameBtn;
    private TextView popupScoreTxtView;
    private String yourFinalScoreTxt;

    public void gameOverDialog(){
        //how to do popup "https://www.youtube.com/watch?v=4GYKOzgQDWI&ab_channel=CodingMark"
        dialogBuilder = new AlertDialog.Builder(this);
        final View gameOverPopupView = getLayoutInflater().inflate(R.layout.popup_lose,null);

        exitGameBtn = (Button) gameOverPopupView.findViewById(R.id.exitGameBtn);
        againGameBtn = (Button) gameOverPopupView.findViewById(R.id.againGameBtn);
        popupScoreTxtView = (TextView) gameOverPopupView.findViewById(R.id.popupScoreTxtView);

        dialogBuilder.setView(gameOverPopupView);
        dialog = dialogBuilder.create();
        if(!dialog.isShowing()){
            dialog.show();
            yourFinalScoreTxt = "Score: " + score;
            popupScoreTxtView.setText(yourFinalScoreTxt);
        }

        againGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                setupGame();
            }
        });
        exitGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });
    }
     */

    public void setupGame(){
        //General stuff, gameBackBtn and score+lives text_fields
        hangmanImgView = findViewById(R.id.hangmanImgView);
        hangmanImgView.setImageResource(R.drawable.emptyimg);

        scoreTitleTxtView = findViewById(R.id.scoreTitleTxtView);
        scoreTitleTxtView.setText("Score:");

        livesTitleTxtView = findViewById(R.id.livesTitleTxtView);
        livesTitleTxtView.setText("Lives:");

        returnFromGame = findViewById(R.id.gameBackBtn);
        returnFromGame.setText("x");
        returnFromGame.setOnClickListener(this);

        wordTxtView = findViewById(R.id.wordTxtView);

        gc.setupGame();

        livesTxtView = findViewById(R.id.livesTxtView);
        livesTxtView.setText(String.valueOf(gc.getLives()));

        scoreTxtView = findViewById(R.id.scoreTxtView);
        scoreTxtView.setText(String.valueOf(gc.getScore()));

        resetGame();
    }


    public void resetGame(){
        gc.resetgame();

        String tmpString = gc.getDisplayedWordString();
        wordTxtView.setText(tmpString);
        enableAllButtons();

        livesTxtView.setText(String.valueOf(gc.getLives()));
        scoreTxtView.setText(String.valueOf(gc.getScore()));
    }

    public void updateHangmanImage() {
        switch(gc.getLives()) {
            case 9:
            case 8:
                // code block
                hangmanImgView.setImageResource(R.drawable.stolpesupport1);
                break;
            case 7:
                // code block
                hangmanImgView.setImageResource(R.drawable.stolpelodret2);
                break;
            case 6:
                // code block
                hangmanImgView.setImageResource(R.drawable.stolpevandret3);
                break;
            case 5:
                // code block
                hangmanImgView.setImageResource(R.drawable.stol4);
                break;
            case 4:
                // code block
                hangmanImgView.setImageResource(R.drawable.rope5);
                break;
            case 3:
                // code block
                hangmanImgView.setImageResource(R.drawable.legs6);
                break;
            case 2:
                // code block
                hangmanImgView.setImageResource(R.drawable.body7);
                break;
            case 1:
                // code block
                hangmanImgView.setImageResource(R.drawable.arms8);
                break;
            case 0:
                // code block
                hangmanImgView.setImageResource(R.drawable.head9);
                break;
            default:
                break;
            // code block
        }
    }

    //disable back button on phone
    @Override
    public void onBackPressed() {
        finish();
    }

    public void disableAllButtons(){
        if(true) {
            LtrA.setEnabled(false);
            LtrB.setEnabled(false);
            LtrC.setEnabled(false);
            LtrD.setEnabled(false);
            LtrE.setEnabled(false);
            LtrF.setEnabled(false);
            LtrG.setEnabled(false);
            LtrH.setEnabled(false);
            LtrI.setEnabled(false);
            LtrJ.setEnabled(false);
            LtrK.setEnabled(false);
            LtrL.setEnabled(false);
            LtrM.setEnabled(false);
            LtrN.setEnabled(false);
            LtrO.setEnabled(false);
            LtrP.setEnabled(false);
            LtrQ.setEnabled(false);
            LtrR.setEnabled(false);
            LtrS.setEnabled(false);
            LtrT.setEnabled(false);
            LtrU.setEnabled(false);
            LtrV.setEnabled(false);
            LtrW.setEnabled(false);
            LtrX.setEnabled(false);
            LtrY.setEnabled(false);
            LtrZ.setEnabled(false);
            LtrAE.setEnabled(false);
            LtrOE.setEnabled(false);
            LtrAA.setEnabled(false);
        }
    }

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
