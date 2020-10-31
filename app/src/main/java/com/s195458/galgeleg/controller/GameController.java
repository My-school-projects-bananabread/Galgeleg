package com.s195458.galgeleg.controller;

import android.content.Context;
import android.content.res.AssetManager;

import com.s195458.galgeleg.model.Hangman;
import com.s195458.galgeleg.model.Highscore;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;



public class GameController {

    //game variables
    String guessWord;
    String displayedWordString;
    char[] displayedWordArray;
    ArrayList<String> wordList;
    String triedLetters;
    int lives;
    int score;

    Hangman myhangman = new Hangman(guessWord, displayedWordString, displayedWordArray, wordList, triedLetters, lives, score);

    public void setupGame(){
        myhangman.setLives(10);
        myhangman.setScore(10);

        setupWordlist();
        myhangman.setWordList(wordList);

        resetgame();

        //String guessWord, String displayedWordString, char[] displayedWordArray, ArrayList<String> wordList, String triedLetters, int lives, int score
    }

    public void resetgame(){
        guessWord = myhangman.getWordList().get(0).toUpperCase();
        myhangman.setGuessWord(guessWord);

        myhangman.getWordList().remove(0);

        //display word
        displayedWordArray = guessWord.toCharArray();
        Arrays.fill(displayedWordArray, '_');

        //score and lives
        if(score >= 10){
            lives = 0;
        } else {
            lives = 10-score;
        }
    }



    private Context context;
    //inputStream = manager.open("wordList.txt");
    AssetManager manager = context.getAssets();

    //fill up word list
    public void setupWordlist(){

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
    }
}
