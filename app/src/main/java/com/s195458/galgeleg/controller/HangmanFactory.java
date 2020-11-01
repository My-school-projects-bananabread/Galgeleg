package com.s195458.galgeleg.controller;

import android.content.Context;

public class HangmanFactory {
    public IGameType createGame(Context context, GameTypes type) {
        switch (type){
            case Standard:
                return new StandardGameController(context);

            default:
                return null;
        }
    }
}
