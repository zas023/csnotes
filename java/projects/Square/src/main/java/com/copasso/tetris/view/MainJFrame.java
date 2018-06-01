package com.copasso.tetris.view;

import com.copasso.tetris.controler.GameController;
import com.copasso.tetris.model.GameListener;

import javax.swing.*;

import java.awt.*;

import static com.copasso.tetris.util.Constant.BLOCK_SIZE;
import static com.copasso.tetris.util.Constant.NUM_COL;
import static com.copasso.tetris.util.Constant.NUM_ROW;

/**
 * 主界面JFrame
 */
public class MainJFrame extends JFrame {

    private GameJPanel gameJPanel;
    private MenuJPanel menuJPanel;
    private GameController controller;

    public MainJFrame(){
        setTitle("俄罗斯方块");
        setSize(NUM_COL * BLOCK_SIZE+100, NUM_ROW * BLOCK_SIZE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        gameJPanel=new GameJPanel();

        menuJPanel=new MenuJPanel();
        getContentPane().add("Center",gameJPanel);
        getContentPane().add("East", menuJPanel);

        controller=new GameController(gameJPanel,menuJPanel);
        gameJPanel.setController(controller);

        setVisible(true);

        addKeyListener(controller);

        controller.startGame();
    }
}
