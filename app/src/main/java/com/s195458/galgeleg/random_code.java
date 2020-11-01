package com.s195458.galgeleg;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class random_code {

    /*
    public void setupGame() {
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

        //Variables for game mechanics
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
    */

    /*
    public void guessLetter(char letter){
        displayedWordString = String.valueOf(displayedWordArray);
        wordTxtView.setText(displayedWordString);

        //if correct letter
        if(guessWord.indexOf(letter) >= 0 ){
            //show correct letters
            for(int i = 0; i < displayedWordArray.length; i++){
                if(guessWord.charAt(i) == letter){
                    displayedWordArray[i] = letter;
                }
            }


            //if all letters guessed
            if(!displayedWordString.contains("_")){
                score +=1;
                resetGame();
                updateHangmanImage();
            }

        } else {
            lives -= 1;
        }
    }
     */


    /*

    public void endgame() {
        gc.endgame(getApplicationContext());
        hangmanImgView.setImageResource(R.drawable.dead10);

        //skal gøre så scoren bliver gemt og vindeskærm/tabeskærm i guess
        if(lives < 0){
            System.out.println("BIB BUB SAVING SCORE");
            disableAllButtons();
            saveScore();

            //skift skærm i stedet....
            Intent i = new Intent(this, GameoverScreen.class);
            i.putExtra("score", score);
            i.putExtra("guessWord", guessWord);
            startActivity(i);
            finish();

            //gameOverDialog();
            //Meget sejere om mere logisk måde at gøre det på men skifter activity for at vise det med
            //at flytte data fra en activity til en anden så ignorer den her metode for nu.
            //kan forhåbentlig bruges i stedet til det endelige spil.
            //
}
// you lost part make something :D

        hangmanImgView.setImageResource(R.drawable.dead10);
                //finish();
                }

//save score
public void saveScore(){
        if (score > 0) {
        hc.addhighscore(getApplicationContext(), score);
        }
        }

     */
}


