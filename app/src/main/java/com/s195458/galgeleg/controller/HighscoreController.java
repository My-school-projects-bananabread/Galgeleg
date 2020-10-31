package com.s195458.galgeleg.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.s195458.galgeleg.model.Highscore;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class HighscoreController {

    public void setHighscore(Context context, List<Highscore> highscores){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);//aktivitet

        Gson gson = new Gson();
        String highscoreJson = gson.toJson(highscores);

        prefs.edit().putString("highscoreJson", highscoreJson).apply();

    }

    public ArrayList<Highscore> getHighscores (Context context){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);//aktivitet
        Gson gson = new Gson();
        ArrayList<Highscore> entries = gson.fromJson(prefs.getString("highscoreJson","[]"),new TypeToken<ArrayList<Highscore>>(){}.getType());
        return entries;
    }

    public void addhighscore(Context context, int score){
        Highscore myscore = new Highscore(score, new Date());
        ArrayList<Highscore> currentscores = getHighscores(context);
        currentscores.add(myscore);
        currentscores.sort(Comparator.comparingInt(Highscore::getScore).reversed());
        setHighscore(context, currentscores);
    }
}
