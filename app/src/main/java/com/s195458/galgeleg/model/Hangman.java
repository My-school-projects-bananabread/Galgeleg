package com.s195458.galgeleg.model;

import java.util.ArrayList;

public class Hangman {
    private String guessWord;
    private String displayedWordString;
    private char[] displayedWordArray;
    private ArrayList<String> wordList;
    private String triedLetters;
    private int lives;
    private int score;

    public Hangman(String guessWord, String displayedWordString, char[] displayedWordArray, ArrayList<String> wordList, int lives, int score) {
        this.guessWord = guessWord;
        this.displayedWordString = displayedWordString;
        this.displayedWordArray = displayedWordArray;
        this.wordList = wordList;
        this.lives = lives;
        this.score = score;
    }

    public String getGuessWord() {
        return guessWord;
    }

    public void setGuessWord(String guessWord) {
        this.guessWord = guessWord;
    }

    public String getDisplayedWordString() {
        return displayedWordString;
    }

    public void setDisplayedWordString(String displayedWordString) {
        this.displayedWordString = displayedWordString;
    }

    public char[] getDisplayedWordArray() {
        return displayedWordArray;
    }

    public void setDisplayedWordArray(char[] displayedWordArray) {
        this.displayedWordArray = displayedWordArray;
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<String> wordList) {
        this.wordList = wordList;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
