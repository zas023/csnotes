package com.copasso.tetris.controler;

import com.copasso.tetris.model.Cell;
import com.copasso.tetris.util.Constant;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 服务控制器
 */
public class ServerController implements Runnable{

    private GameController controller;
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    public ServerController(DataInputStream fromServer,DataOutputStream toServer,
                            GameController controller){
        this.fromServer=fromServer;
        this.toServer=toServer;
        this.controller=controller;
    }

    /**
     * 新线程接收消息
     */
    public void run() {
        while (true){
            try {
                int status=fromServer.readInt();
                if (status==Constant.MSG_START){
                    //对手上线，看是游戏
                    System.out.println("MSG_START");
                    controller.setRunning(true);
                }else if (status==Constant.MSG_SCORE){
                    //对手得分，刷新分数
                    System.out.println("MSG_SCORE");
                    controller.setScore(0,fromServer.readInt());
                }else if (status==Constant.MSG_MAP){
                    //对手游戏地图
                    System.out.println("MSG_MAP");
                    Color[][] mapColor= new Color[Constant.NUM_ROW][Constant.NUM_COL];
                    for (int i=0;i<mapColor.length;i++){
                        for (int j=0;j<mapColor[0].length;j++){
                            try {
                                int color=fromServer.readInt();
                                if (color==Constant.COLOR_RED)
                                    mapColor[i][j]=Color.RED;
                                if (color==Constant.COLOR_BLUE)
                                    mapColor[i][j]=Color.BLUE;
                                if (color==Constant.COLOR_WHITE)
                                    mapColor[i][j]=Color.WHITE;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    controller.setMapColor(mapColor);
                }else if (status==Constant.MSG_END){
                    //对手游戏结束
                    System.out.println("MSG_END");
                    controller.setEnd(true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 向服务器发送得分
     * @param score
     * @throws IOException
     */
    public void sendScore(int score) throws IOException {
        toServer.writeInt(Constant.MSG_SCORE);
        toServer.writeInt(score);
    }

    /**
     * 向服务器发送游戏地图
     * @param map
     * @throws IOException
     */
    public void sendMap(Cell[][] map) throws IOException {
        toServer.writeInt(Constant.MSG_MAP);
        for (int i=0;i<map.length;i++){
            for (int j=0;j<map[0].length;j++){
                if (map[i][j].getColor()== Color.RED)
                    toServer.writeInt(Constant.COLOR_RED);
                else if (map[i][j].getColor()==Color.BLUE)
                    toServer.writeInt(Constant.COLOR_BLUE);
                else
                    toServer.writeInt(Constant.COLOR_WHITE);
            }
        }
    }
}
