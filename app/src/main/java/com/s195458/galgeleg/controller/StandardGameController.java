package com.s195458.galgeleg.controller;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;

import com.s195458.galgeleg.model.Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


public class StandardGameController implements IGameType {

    //game variables
    String guessWord;
    String displayedWordString;
    char[] displayedWordArray;
    int lives;
    int score;

    private Context context;
    //inputStream = manager.open("wordList.txt");
    AssetManager manager;

    HighscoreController hc;
    Hangman myhangman;

    Executor bgThread = Executors.newSingleThreadExecutor(); // håndtag til en baggrundstråd
    Handler uiThread = new Handler(Looper.getMainLooper());  // håndtag til forgrundstråden

    public StandardGameController(Context context) {
        //this.myhangman = myhangman;
        this.context = context;
        this.hc = new HighscoreController();
        this.manager = context.getAssets();
        this.myhangman = new Hangman(guessWord, displayedWordString, displayedWordArray, new ArrayList<String>(), lives, score);
    }

    public void setupGame(IThreadCallback callback){
        myhangman.setLives(10);
        myhangman.setScore(0);

        //setupWordlist();
        setupWordlistAsync(callback);
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

    public void setupWordlistAsync(IThreadCallback callback) {

        bgThread.execute(() -> {
            try {
                hentOrdFraDr();
            }catch (Exception e) {
                local_list();
            }

            uiThread.post(callback::callback);
        });



    }

    public void local_list(){
        ArrayList<String> wordList = new ArrayList<String>();

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
            if (myhangman.getScore() > 0) {
                hc.addhighscore(this.context, myhangman.getScore());
            }
        }
    }


    //hente ord fra nettet fis, obviosuly kode fra jakob, kommer til at savne ham som lærer :( han var nice.
    public static String hentUrl(String url) throws IOException {
        System.out.println("Henter data fra " + url);
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString();
    }

    public void hentOrdFraDr() throws Exception {
        String data = hentUrl("https://dr.dk");
        //System.out.println("data = " + data);

        data = data.substring(data.indexOf("<body")). // fjern headere
                replaceAll("<.+?>", " ").toLowerCase(). // fjern tags
                replaceAll("&#198;", "æ"). // erstat HTML-tegn
                replaceAll("&#230;", "æ"). // erstat HTML-tegn
                replaceAll("&#216;", "ø"). // erstat HTML-tegn
                replaceAll("&#248;", "ø"). // erstat HTML-tegn
                replaceAll("&oslash;", "ø"). // erstat HTML-tegn
                replaceAll("&#229;", "å"). // erstat HTML-tegn
                replaceAll("[^a-zæøå]", " "). // fjern tegn der ikke er bogstaver
                replaceAll(" [a-zæøå] "," "). // fjern 1-bogstavsord
                replaceAll(" [a-zæøå][a-zæøå] "," "); // fjern 2-bogstavsord

        System.out.println("data = " + data);
        System.out.println("data = " + Arrays.asList(data.split("\\s+")));
        myhangman.getWordList().addAll(new HashSet<String>(Arrays.asList(data.split(" "))));
        System.out.println("muligeOrd = " + myhangman.getWordList());
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
