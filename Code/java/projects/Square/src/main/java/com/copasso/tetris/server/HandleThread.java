package com.copasso.tetris.server;

import com.copasso.tetris.util.Constant;

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

            toPlayer.writeInt(Constant.MSG_START);

            while (true) {
                // 从客户端中获取消息
                System.out.println("readInt start");
                int status = fromPlayer.readInt();
                // 向客户端传递消息
                toPlayer.writeInt(status);
                System.out.println("writeInt end");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
