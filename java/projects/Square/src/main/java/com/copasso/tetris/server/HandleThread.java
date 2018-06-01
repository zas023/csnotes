package com.copasso.tetris.server;

import java.io.*;
import java.net.Socket;

/**
 * 进程通信线程
 */
public class HandleThread implements Runnable{

    private Socket player1;
    private Socket player2;

    private DataInputStream fromPlayer;
    private DataOutputStream toPlayer;


    public HandleThread (Socket player1, Socket player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void run() {
        try {
            // Create data input and output streams
            fromPlayer = new DataInputStream(player1.getInputStream());
            toPlayer = new DataOutputStream(player2.getOutputStream());

            toPlayer.writeInt(1);

            while (true) {
                // 从客户端中获取得分
                System.out.println("readInt start");
                int score = fromPlayer.readInt();
                toPlayer.writeInt(score);
                System.out.println("writeInt end");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String str){
        try {
            toPlayer.writeChars(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(int i){
        try {
            toPlayer.writeInt(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
