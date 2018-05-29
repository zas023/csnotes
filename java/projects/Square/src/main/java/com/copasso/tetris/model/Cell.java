package com.copasso.tetris.model;

import javax.swing.*;
import java.awt.*;

import static com.copasso.tetris.util.Constant.BLOCK_SIZE;

public class Cell extends JPanel {
    private int row;
    private int column;
    private Color color;

    public Cell(){
        this.color=Color.WHITE;
    }

    public Cell(int row, int column) {
        setSize(BLOCK_SIZE,BLOCK_SIZE);
        this.row = row;
        this.column = column;
        this.color=Color.WHITE;
    }

    public Cell(int row, int column,Color c) {
        setSize(BLOCK_SIZE,BLOCK_SIZE);
        this.row = row;
        this.column = column;
        this.color=c;
    }

    public boolean isActive(){
        return color==Color.RED;
    }

    public boolean isStoped(){
        return color==Color.BLUE;
    }

    public boolean isEmpty(){
        return color==Color.WHITE;
    }

    public void setColor(Color c){
        this.color=c;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(color);
    }
}
