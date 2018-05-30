package com.copasso.tetris.view;

import com.copasso.tetris.controler.GameController;
import com.copasso.tetris.model.GameJPanel;

import javax.swing.*;

import static com.copasso.tetris.util.Constant.BLOCK_SIZE;
import static com.copasso.tetris.util.Constant.NUM_COL;
import static com.copasso.tetris.util.Constant.NUM_ROW;

public class GameJFrame extends JFrame {

    private GameJPanel panel;
    private GameController controller;

    public GameJFrame(){
        setTitle("俄罗斯方块");
        setSize(NUM_COL * BLOCK_SIZE, NUM_ROW * BLOCK_SIZE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel=new GameJPanel();
        controller=new GameController(panel);
        panel.setController(controller);

        setContentPane(panel);
        setVisible(true);

        addKeyListener(controller);

        controller.startGame();
    }
}
