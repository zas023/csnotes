package com.copasso.tetris.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 */
public class Constant {
    /************************Client**************************/
    // 每个方块的边长
    public static final int BLOCK_SIZE = 30;
    // 游戏空间行数
    public static final int NUM_ROW = 20;
    // 游戏空间列数
    public static final int NUM_COL = 15;

    /************************Server**************************/
    public static int PLAYER1 = 1; // Indicate player 1
    public static int PLAYER2 = 2; // Indicate player 2
    public static int PLAYER1_WON = 1; // Indicate player 1 won
    public static int PLAYER2_WON = 2; // Indicate player 2 won
    public static int PLAYER_DRAW = 3; // Indicate a draw
    public static int PLAYER_START = 4; // Indicate to start

    public static final Map<Integer, String> CONST_INFO = new HashMap<Integer, String>();

    static {
        CONST_INFO.put(BLOCK_SIZE,"每个方块的边长");
        CONST_INFO.put(NUM_ROW,"游戏空间行数");
        CONST_INFO.put(NUM_COL,"游戏空间列数");
    }
}
