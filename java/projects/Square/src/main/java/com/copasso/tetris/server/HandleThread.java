package com.copasso.tetris.server;

import java.io.*;
import java.net.Socket;

/**
 * 进程通信线程
 */
public class HandleThread implements Runnable{

    private Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public HandleThread (Socket socket) {
        this.socket = socket;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    public void run() {

    }

    public void sendMessage(String str){
        // 这里负责写
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
