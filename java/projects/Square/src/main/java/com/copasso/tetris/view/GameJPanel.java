package com.copasso.tetris.view;

import com.copasso.tetris.controler.GameController;
import com.copasso.tetris.model.Cell;
import com.copasso.tetris.model.GameListener;

import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static com.copasso.tetris.util.Constant.BLOCK_SIZE;
import static com.copasso.tetris.util.Constant.NUM_COL;
import static com.copasso.tetris.util.Constant.NUM_ROW;

/**
 * 游戏界面
 */
public class GameJPanel extends JPanel {

    private GameController controller;
    private GameListener listener;

    // 游戏地图格子，每个格子保存一个方块，数组纪录方块的状态
    private Cell map[][] = new Cell[NUM_ROW][NUM_COL];
    // 图形最下一行在地图中所在行数的索引
    private int rowIndex = 0;
    // 生成的图形行数
    private int blockRows = 0;
    //游戏是否结束
    private boolean isGameOver;
    //是否可以下落
    private boolean isFall;
    //图形形状
    private int shape;
    //玩家得分
    private int score;

    public GameJPanel(){
        setSize(NUM_COL * BLOCK_SIZE, NUM_ROW * BLOCK_SIZE);
        setLayout(new GridLayout(NUM_ROW, NUM_COL));
        //初始化地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                add(map[i][j] = new Cell(i,j));
            }
        }
    }

    public void setController(GameController controller){
        this.controller=controller;
    }

    public void setListener(GameListener listener){this.listener=listener;}

    /**
     * 向下移动
     */
    public void toDown(){
        rowIndex++;
    }

    /**
     * 向左移动
     */
    public void toLeft() {

        // 标记左边是否有阻碍
        boolean hasBlock = false;

        //判断是否左边有阻碍
        for (int i = 0; i < blockRows; i++) {
            if (map[rowIndex - i][0].isActive()) { // 判断左边是否为墙
                hasBlock = true;
                break; // 有阻碍，不用再循环判断行
            } else {
                for (int j = 1; j < NUM_COL; j++) { // 判断左边是否有其它块
                    if (map[rowIndex - i][j].isActive() && map[rowIndex - i][j - 1].isStoped()) {
                        hasBlock = true;
                        break; // 有阻碍，不用再循环判断列
                    }
                }
                if (hasBlock)
                    break; // 有阻碍，不用再循环判断行
            }
        }

        //左边没有阻碍，则将图形向左移动一个块的距离
        if (!hasBlock) {
            for (int i = 0; i < blockRows; i++) {
                for (int j = 1; j < NUM_COL; j++) {
                    if (map[rowIndex - i][j].isActive()) {
                        map[rowIndex - i][j].setColor(Color.WHITE);
                        map[rowIndex - i][j - 1].setColor(Color.RED);
                    }
                }
            }
        }
    }

    /**
     * 向右移动
     */
    public void toRight() {
        // 标记右边是否有阻碍
        boolean hasBlock = false;

        //判断是否右边有阻碍
        for (int i = 0; i < blockRows; i++) {
            if (map[rowIndex - i][NUM_COL - 1].isActive()) { // 判断右边是否为墙
                hasBlock = true;
                break; // 有阻碍，不用再循环判断行
            } else {
                for (int j = 0; j < NUM_COL - 1; j++) { // 判断右边是否有其它块
                    if (map[rowIndex - i][j].isActive() && map[rowIndex - i][j + 1].isStoped()) {
                        hasBlock = true;
                        break; // 有阻碍，不用再循环判断列
                    }
                }
                if (hasBlock)
                    break; // 有阻碍，不用再循环判断行
            }
        }

        //右边没有阻碍，则将图形向右移动一个块的距离
        if (!hasBlock) {
            for (int i = 0; i < blockRows; i++) {
                for (int j = NUM_COL - 2; j >= 0; j--) {
                    if (map[rowIndex - i][j].isActive()) {
                        map[rowIndex - i][j].setColor(Color.WHITE);
                        map[rowIndex - i][j + 1].setColor(Color.RED);
                    }
                }
            }
        }
    }

    /**
     * 旋转方块图形
     */
    public void toRotate() {
        try {
            if (shape == 4) { // 方形，旋转前后是同一个形状
                return;
            } else if (shape == 0) { // 条状
                // 临时数组，放置旋转后图形
                Cell[][] tmp = new Cell[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        tmp[i][j]=new Cell(i,j);
                    }
                }
                int startColumn = 0;
                // 找到图形开始的第一个方块位置
                for (int i = 0; i < NUM_COL; i++) {
                    if (map[rowIndex][i].isActive()) {
                        startColumn = i;
                        break;
                    }
                }
                // 查找旋转之后是否有阻碍，如果有阻碍，则不旋转
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (map[rowIndex - 3 + i][j + startColumn].isStoped()) {
                            return;
                        }
                    }
                }

                if (map[rowIndex][startColumn + 1].isActive()) { // 横向条形，变换为竖立条形
                    for (int i = 0; i < 4; i++) {
                        tmp[i][0].setColor(Color.RED);
                        for (int j = 1; j < 4; j++) {
                            tmp[i][j].setColor(Color.WHITE);
                        }
                    }
                    blockRows = 4;
                } else { // 竖立条形，变换为横向条形
                    for (int j = 0; j < 4; j++) {
                        tmp[3][j].setColor(Color.RED);
                        for (int i = 0; i < 3; i++) {
                            tmp[i][j].setColor(Color.WHITE);
                        }
                    }
                    blockRows = 1;
                }
                // 将原地图中图形修改为变换后图形
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        map[rowIndex - 3 + i][startColumn + j].setColor(tmp[i][j].getColor());
                    }
                }
            } else {
                // 临时数组，放置旋转后图形
                Cell[][] tmp = new Cell[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        tmp[i][j]=new Cell(i,j);
                    }
                }
                int startColumn = NUM_COL;
                // 找到图形开始的第一个方块位置
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < NUM_COL; i++) {
                        if (map[rowIndex - j][i].isActive()) {
                            startColumn = i < startColumn ? i : startColumn;
                        }
                    }
                }
                // 判断变换后是否会遇到阻碍
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (map[rowIndex - 2 + j][startColumn + 2 - i].isStoped())
                            return;
                    }
                }
                // 变换
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        tmp[2 - j][i].setColor(map[rowIndex - 2 + i][startColumn + j].getColor());
                    }
                }
                // 将原地图中图形修改为变换后图形
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        map[rowIndex - 2 + i][startColumn + j].setColor(tmp[i][j].getColor());
                    }
                }

                // 重绘
                repaint();
                // 重新修改行指针
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (map[rowIndex - i][startColumn + j] != null
                                || !map[rowIndex - i][startColumn + j].isEmpty()) {
                            rowIndex = rowIndex - i;
                            blockRows = 3;
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            // 遇到数组下标越界，说明不能变换图形形状，不作任何处理
            e.printStackTrace();
        }
    }

    /************************************************************/

    /**
     * 判断能否下落
     */
    public void drop() {
        isFall = true; // 是否能够下落
        // 从当前行检查，如果遇到阻碍，则停止下落
        for (int i = 0; i < blockRows; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                // 遍历到行中块为活动块，而下一行块为静止块，则遇到阻碍
                if (map[rowIndex - i][j].isActive() && map[rowIndex - i + 1][j].isStoped()) {
                    isFall = false; // 停止下落
                    break;
                }
            }
            if (!isFall)
                break;
        }

        if (isFall) { // 可以下落
            // 图形下落一行
            for (int i = 0; i < blockRows; i++) {
                for (int j = 0; j < NUM_COL; j++) {
                    if (map[rowIndex - i][j].isActive()) { // 活动块向下移动一行
                        map[rowIndex - i][j].setColor(Color.WHITE); // 原活动块变成空块
                        map[rowIndex - i + 1][j].setColor(Color.RED); // 下一行块变成活动块
                    }
                }
            }
        } else if (rowIndex < blockRows) {
            // 行索引小于生成的图形行数，说明图形刚出现就遇到阻碍，已经顶到地图最上方了，游戏结束
            isGameOver=true;
        }
    }

    public boolean canDrop(){
        return rowIndex < NUM_ROW - 1;
    }
    public boolean isGameOver(){
        return isGameOver;
    }
    public boolean isFall(){
        return isFall;
    }

    /**
     * 生成随机的方块图形
     */
    public void randomBlocks() {
        Random rand = new Random();
        shape = rand.nextInt(7);// 随机形状
        // 随机图形出现的中间位置
        int randPos = rand.nextInt(NUM_COL - 4) + 2;
        //System.out.println("随机图形"+shape+"随机位置"+randPos);
        // 根据随机数产生不同的图形
        switch (shape) {
            case 0: // ─型
                map[0][randPos].setColor(Color.red);
                map[0][randPos - 1].setColor(Color.red);
                map[0][randPos + 1].setColor(Color.red);
                map[0][randPos + 2].setColor(Color.red);
                blockRows = 1;
                break;
            case 1: // ┗型
                map[0][randPos].setColor(Color.red);
                map[1][randPos].setColor(Color.red);
                map[2][randPos].setColor(Color.red);
                map[2][randPos + 1].setColor(Color.red);
                blockRows = 3;
                break;
            case 2: // ┛型
                map[0][randPos].setColor(Color.red);
                map[1][randPos].setColor(Color.red);
                map[2][randPos].setColor(Color.red);
                map[2][randPos - 1].setColor(Color.red);
                blockRows = 3;
                break;
            case 3: // ┷型
                map[1][randPos].setColor(Color.red);
                map[1][randPos - 1].setColor(Color.red);
                map[1][randPos + 1].setColor(Color.red);
                map[0][randPos].setColor(Color.red);
                blockRows = 2;
                break;
            case 4: // ■型
                map[0][randPos].setColor(Color.red);
                map[0][randPos + 1].setColor(Color.red);
                map[1][randPos].setColor(Color.red);
                map[1][randPos + 1].setColor(Color.red);
                blockRows = 2;
                break;
            case 5: // Z型
                map[0][randPos - 1].setColor(Color.red);
                map[0][randPos].setColor(Color.red);
                map[1][randPos].setColor(Color.red);
                map[1][randPos + 1].setColor(Color.red);
                blockRows = 2;
                break;
            case 6: // 反Z型
                map[0][randPos + 1].setColor(Color.red);
                map[0][randPos].setColor(Color.red);
                map[1][randPos].setColor(Color.red);
                map[1][randPos - 1].setColor(Color.red);
                blockRows = 2;
                break;
        }

        rowIndex = blockRows - 1;
    }

    /**
     * 判断是否能消除行
     */
    public int getScore() {
        int[] blocksCount = new int[NUM_ROW]; // 记录每行有方块的列数
        int eliminateRows = 0; // 消除的行数
        //计算每行方块数量
        for (int i = 0; i < NUM_ROW; i++) {
            blocksCount[i] = 0;
            for (int j = 0; j < NUM_COL; j++) {
                if (map[i][j].isStoped())
                    blocksCount[i]++;
            }
        }
        //实现有满行的方块消除操作
        for (int i = 0; i < NUM_ROW; i++) {
            if (blocksCount[i] == NUM_COL) {
                // 清除一行
                for (int m = i; m >= 0; m--) {
                    for (int n = 0; n < NUM_COL; n++) {
                        map[m][n].setColor((m == 0) ? Color.WHITE : map[m - 1][n].getColor());
                    }
                }
                eliminateRows++; // 记录消除行数
            }
        }
        // 计算积分并返回
        score += eliminateRows == 1 ? 10 : (
                       eliminateRows == 2 ? 30 : (eliminateRows == 3 ? 60 : (eliminateRows == 0 ? 0 : 100)));
        return score;
    }

    /**
     * 修改图形方块状态
     */
    public void changeBolckState() {
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                if (map[i][j].isActive()) // 将活动状态改为静止状态
                    map[i][j].setColor(Color.BLUE);
            }
        }
    }

}
