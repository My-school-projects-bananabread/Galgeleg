package com.s195458.galgeleg.model;

import java.util.Date;

public class Highscore {
    private int score;
    private Date date;

    public Highscore(int score, Date date) {
        this.score = score;
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
