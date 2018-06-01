package com.copasso.tetris.model;

public interface GameListener {
    void gameOver();
    void nextBlock();
    void onChangeScore(int score1,int score2);
}
