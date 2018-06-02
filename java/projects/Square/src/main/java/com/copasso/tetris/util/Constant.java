package com.copasso.tetris.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 */
public class Constant {
    /************************Client**************************/
    // 每个方块的边长
    public static final int BLOCK_SIZE = 20;
    // 游戏空间行数
    public static final int NUM_ROW = 20;
    // 游戏空间列数
    public static final int NUM_COL = 15;

    /************************Server**************************/
    public static int PLAYER1 = 1; // Indicate player 1
    public static int PLAYER2 = 2; // Indicate player 2

    public static int MSG_START = 1;
    public static int MSG_END = 2;
    public static int MSG_WAIT = 3;
    public static int MSG_MAP = 4;
    public static int MSG_SCORE = 5;

    public static int COLOR_RED = 11;
    public static int COLOR_BLUE = 12;
    public static int COLOR_WHITE = 13;

    public static final Map<Integer, String> CONST_INFO = new HashMap<Integer, String>();

    static {
        CONST_INFO.put(BLOCK_SIZE,"每个方块的边长");
        CONST_INFO.put(NUM_ROW,"游戏空间行数");
        CONST_INFO.put(NUM_COL,"游戏空间列数");
    }
}
