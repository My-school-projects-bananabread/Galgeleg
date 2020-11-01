package com.s195458.galgeleg.controller;

import android.content.Context;
import android.content.res.AssetManager;

import com.s195458.galgeleg.model.Hangman;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class StandardGameController implements IGameType {

    //game variables
    String guessWord;
    String displayedWordString;
    char[] displayedWordArray;
    ArrayList<String> wordList;
    int lives;
    int score;

    private Context context;
    //inputStream = manager.open("wordList.txt");
    AssetManager manager;

    HighscoreController hc;
    Hangman myhangman;

    public StandardGameController(Context context) {
        //this.myhangman = myhangman;
        this.context = context;
        this.hc = new HighscoreController();
        this.manager = context.getAssets();
        this.myhangman = new Hangman(guessWord, displayedWordString, displayedWordArray, wordList, lives, score);
    }

    public void setupGame(){
        myhangman.setLives(10);
        myhangman.setScore(0);

        setupWordlist();
        //String guessWord, String displayedWordString, char[] displayedWordArray, ArrayList<String> wordList, String triedLetters, int lives, int score
    }

    public void resetgame(){
        guessWord = myhangman.getWordList().get(0).toUpperCase();
        myhangman.getWordList().remove(0);

        myhangman.setGuessWord(guessWord);

        //display word
        myhangman.setDisplayedWordArray(myhangman.getGuessWord().toCharArray());
        Arrays.fill(myhangman.getDisplayedWordArray(), '_');

        myhangman.setDisplayedWordString(String.valueOf(myhangman.getDisplayedWordArray()));

        //score and lives
        if(myhangman.getScore() >= 10){
            myhangman.setLives(0);
        } else {
            myhangman.setLives(10-myhangman.getScore());
        }
    }

    //fill up word list
    public void setupWordlist(){
        wordList = new ArrayList<String>();
        InputStream inputStream = null;
        Scanner WordScanner = null;
        String wordtmp;

        try {
            inputStream = manager.open("wordList.txt");
            WordScanner = new Scanner(inputStream);
            while(WordScanner.hasNext()){
                wordtmp = WordScanner.next();
                wordList.add(wordtmp);
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally{
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
        myhangman.setWordList(wordList);
    }

    public boolean guessLetter(char letter){
        //if correct letter
        if(myhangman.getGuessWord().indexOf(letter) >= 0 ){
            //show correct letters
            for(int i = 0; i < myhangman.getDisplayedWordArray().length; i++){
                if(myhangman.getGuessWord().charAt(i) == letter){
                    myhangman.getDisplayedWordArray()[i] = letter;
                }
            }
            myhangman.setDisplayedWordString(String.valueOf(myhangman.getDisplayedWordArray()));
            return true;
        } else {
            int tmpLives = myhangman.getLives()-1;
            myhangman.setLives(tmpLives);
            return false;
        }
    }

    public boolean wordIsGuessed(){
        //if all letters guessed
        if(!myhangman.getDisplayedWordString().contains("_")){
            int tmpScore = myhangman.getScore()+1;
            myhangman.setScore(tmpScore);
            resetgame();
            return true;
        } else {
            return false;
        }
    }

    public boolean checkGameOver(){
        return myhangman.getLives() < 0;
    }

    //save score
    public void saveScore(){
        if (checkGameOver()) {
            hc.addhighscore(this.context, myhangman.getScore());
        }
    }



    public String getGuessWord() {
        return myhangman.getGuessWord();
    }

    public String getDisplayedWordString() {
        return myhangman.getDisplayedWordString();
    }

    public char[] getDisplayedWordArray() {
        return myhangman.getDisplayedWordArray();
    }

    public ArrayList<String> getWordList() {
        return myhangman.getWordList();
    }

    public int getLives() {
        return myhangman.getLives();
    }

    public int getScore() {
        return myhangman.getScore();
    }
}
