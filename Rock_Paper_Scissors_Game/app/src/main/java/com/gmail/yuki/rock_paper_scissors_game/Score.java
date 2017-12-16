package com.gmail.yuki.rock_paper_scissors_game;

/**
 * Created by yuki on 2017/12/11.
 */

public class Score {

    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = this.score + score;
    }

    public void resetScore() {
        this.score = 0;
    }

}
