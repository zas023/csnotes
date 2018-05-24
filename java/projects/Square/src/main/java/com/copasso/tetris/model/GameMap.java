package com.copasso.tetris.model;

public class GameMap {
    // 游戏地图格子，每个格子保存一个方块，数组纪录方块的状态
    private State map[][];
    private int rows;
    private int cols;

    public GameMap(int row, int col){
        map= new State[row][col];
        this.rows=row;
        this.cols=col;
        initMap();
    }

    /**
     * 初始化所有的方块为空
     */
    private void initMap(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = State.EMPTY;
            }
        }
    }

    public State getState(int row, int col){
        return map[row][col];
    }

    public void setState(State state,int row, int col){
        map[row][col]=state;
    }


    public State[][] getMap() {
        return map;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
