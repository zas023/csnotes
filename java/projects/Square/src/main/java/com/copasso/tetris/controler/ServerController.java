package com.copasso.tetris.controler;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * 接收服务器消息控制器
 */
public class ServerController implements Runnable{

    private GameController controller;
    private DataInputStream fromServer;

    public ServerController(DataInputStream fromServer,GameController controller){
        this.fromServer=fromServer;
        this.controller=controller;
    }

    public void run() {
        while (true){
            try {
                int status=fromServer.readInt();
                System.out.println(status);
                if (status==1){
                    controller.setRunning(true);
                }else {
                    controller.setScore(0,status);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
