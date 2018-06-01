package com.copasso.tetris.view;

import javax.swing.*;
import java.awt.*;

/**
 * 菜单信息栏
 */
public class MenuJPanel extends JPanel{

    private JLabel lblScroe1,lblScroe2;
    private int score1,score2;

    public MenuJPanel(){
        setSize(100,600);
        setLayout(new GridLayout(2,1));

        lblScroe1 = new JLabel();
        lblScroe1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblScroe1.setForeground(Color.BLACK);
        lblScroe1.setText("Your Score: "+score1);
        add(lblScroe1);

        lblScroe2 = new JLabel();
        lblScroe2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblScroe2.setForeground(Color.BLACK);
        lblScroe2.setText("His Score: "+score2);
        add(lblScroe2);
    }

    public void setScore(int score1,int score2){
        this.score1=score1;
        this.score2=score2;

        lblScroe1.setText("Your Score: "+score1);
        lblScroe2.setText("His Score: "+score2);
    }

}
