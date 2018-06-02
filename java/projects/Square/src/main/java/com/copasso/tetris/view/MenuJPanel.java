package com.copasso.tetris.view;

import javax.swing.*;
import java.awt.*;

import static com.copasso.tetris.util.Constant.BLOCK_SIZE;
import static com.copasso.tetris.util.Constant.NUM_COL;
import static com.copasso.tetris.util.Constant.NUM_ROW;

/**
 * 菜单信息栏
 */
public class MenuJPanel extends JPanel{

    private JLabel lblScroe1,lblScroe2,lblInfo;
    private int score1,score2;

    public MenuJPanel(){
        setSize(100,100);
        setLayout(new GridLayout(2,2));

        //您的分数
        lblScroe1 = new JLabel();
        lblScroe1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblScroe1.setForeground(Color.BLACK);
        lblScroe1.setText("Your Score: "+score1);
        add(lblScroe1);

        //对手的分数
        lblScroe2 = new JLabel();
        lblScroe2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblScroe2.setForeground(Color.BLACK);
        lblScroe2.setText("His Score: "+score2);
        add(lblScroe2);

        //游戏状态信息
        lblInfo = new JLabel();
        lblInfo.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblInfo.setForeground(Color.BLACK);
        lblInfo.setText("Waiting for ...");
        add(lblInfo);
    }

    /**
     *设置分数
     * @param score1
     * @param score2
     */
    public void setScore(int score1,int score2){
        this.score1=score1;
        this.score2=score2;

        lblScroe1.setText("Your Score: "+score1);
        lblScroe2.setText("His Score: "+score2);
    }

    /**
     * 设置状态信息
     * @param s
     */
    public void setInfo(String s){
        lblInfo.setText(s);
    }

}
