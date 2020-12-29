package com.s195458.galgeleg.controller;

import android.content.Context;

import com.s195458.galgeleg.model.Hangman;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public interface IGameType {

    void setupGame(String WordsType ,IThreadCallback callback);

    void resetgame();

    //fill up word list bye bye

    boolean guessLetter(char letter);

    boolean wordIsGuessed();

    boolean checkGameOver();

    //save score
    void saveScore();

    String getGuessWord();
    String getDisplayedWordString();
    char[] getDisplayedWordArray();
    ArrayList<String> getWordList();
    int getLives();
    int getScore();

}
