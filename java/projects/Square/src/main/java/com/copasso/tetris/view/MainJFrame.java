package com.copasso.tetris.view;

import com.copasso.tetris.controler.GameController;

import javax.swing.*;

import java.awt.*;

import static com.copasso.tetris.util.Constant.BLOCK_SIZE;
import static com.copasso.tetris.util.Constant.NUM_COL;
import static com.copasso.tetris.util.Constant.NUM_ROW;

/**
 * 主界面JFrame
 */
public class MainJFrame extends JFrame {
    //Player1's gamePanel
    private GameJPanel gameJPanel;
    //Player2's gamePanel
    private GameJPanel gameJPanel2;
    //Menu and Score
    private MenuJPanel menuJPanel;
    //controller
    private GameController controller;

    public MainJFrame(){
        //初始化窗体
        setTitle("俄罗斯方块");
        setSize(2*NUM_COL * BLOCK_SIZE+60, NUM_ROW * BLOCK_SIZE+160);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //初始化游戏地图
        gameJPanel=new GameJPanel();
        gameJPanel2=new GameJPanel();

        //初始化菜单
        menuJPanel=new MenuJPanel();
        menuJPanel.setPreferredSize(new Dimension(2*NUM_COL * BLOCK_SIZE,100));

        JPanel p=new JPanel();
        p.setSize(2*NUM_COL * BLOCK_SIZE, NUM_ROW * BLOCK_SIZE);
        setLayout(new GridLayout(1,3));
        gameJPanel.setPreferredSize(new Dimension(NUM_COL * BLOCK_SIZE, NUM_ROW * BLOCK_SIZE));
        gameJPanel2.setPreferredSize(new Dimension(NUM_COL * BLOCK_SIZE, NUM_ROW * BLOCK_SIZE));
        p.add(gameJPanel);
        p.add(gameJPanel2);
        p.add(menuJPanel);
        getContentPane().add("Center",p);

        //初始化游戏控制器
        controller=new GameController(gameJPanel,gameJPanel2,menuJPanel);
        gameJPanel.setController(controller);

        setVisible(true);

        //设置监听键盘事件
        addKeyListener(controller);
        //启动游戏
        controller.startGame();
    }
}
