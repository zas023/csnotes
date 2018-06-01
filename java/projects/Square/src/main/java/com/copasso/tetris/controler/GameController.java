package com.copasso.tetris.controler;

import com.copasso.tetris.view.GameJPanel;
import com.copasso.tetris.server.HandleThread;
import com.copasso.tetris.view.MenuJPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_DOWN;

/**
 * 游戏控制器
 */
public class GameController implements KeyListener {

    // 界面
    private GameJPanel gameJPanel;
    private MenuJPanel menuJPanel;
    // 时间控制器，加载GameTask，每过一段时间，界面就变化一次
    private Timer timer;

    private boolean isRunning;
    private boolean isSpeedUp;

    private int score1,score2;

    //远程通信控制器
    private ServerController serverController;

    public GameController(JPanel panel1,JPanel panel2){
        this.gameJPanel= (GameJPanel) panel1;
        this.menuJPanel= (MenuJPanel) panel2;
    }

    private class GameTask extends TimerTask {
        private int speed = 5;
        public void run() {
            System.out.println("game start");
            try {
                toServer.writeInt(score1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!isRunning){
                return ;
            }
            if (gameJPanel.isGameOver()){
                //游戏结束
                System.out.println("begin to end game");
                // 先暂停游戏
                isRunning = false;
                return;
            }else {
                System.out.println("randomBlocks start");
                gameJPanel.randomBlocks();
                while (gameJPanel.canDrop()){
                    gameJPanel.drop(); // 下降
                    if (!gameJPanel.isFall()){
                        break;
                    }
                    gameJPanel.toDown();
                    gameJPanel.repaint();
                    try {
                        // 休眠，加速休眠一毫秒，未加速休眠500毫秒
                        Thread.sleep(isSpeedUp ? 50 : 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 下落到遇到阻碍为止，修改图形方块状态
                gameJPanel.changeBolckState();
                gameJPanel.repaint();
                // 判断是否可消除行
                int score=gameJPanel.getScore();
                if(score>score1){
                    //得分
                    score1=score;
                    menuJPanel.setScore(score1,score2);
                    try {
                        toServer.writeInt(score1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 启动游戏
     */
    public void startGame(){
        timer = new Timer();
        timer.schedule(new GameTask(), 100,30);

        connectToServer();
    }

    public void setRunning(boolean is){
       this.isRunning=is;
    }

    /**
     * 是否正在运行
     * @return
     */
    public boolean isRunning() {
        return isRunning;
    }

    public void setScore(int sore1,int socre2){
        score2=socre2;
        menuJPanel.setScore(score1,score2);
    }

    /***************************NetWork*************************************/
    // Input and output streams from/to server
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    private String host = "localhost";

    private void connectToServer() {
        try {
            // Create a socket to connect to the server
            Socket socket;
            socket = new Socket(host, 8000);
            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());

            serverController =new ServerController(fromServer,this);
            System.out.println("serverController start");
            new Thread(serverController).start();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private void receiveFromServer(){
        // Receive game status
        try {
            int status = fromServer.readInt();
            if (status==1){
                isRunning=true;
            }else {
                score2=status;
                menuJPanel.setScore(score1,score2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***************************Event*************************************/
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case VK_LEFT:
                gameJPanel.toLeft();
                //handleThread.sendMessage("left");
                gameJPanel.repaint();
                break;
            case VK_RIGHT:
                gameJPanel.toRight();
                //handleThread.sendMessage("right");
                gameJPanel.repaint();
                break;
            case VK_DOWN:
                // 标记可以加速下落
                isSpeedUp=true;
                break;
            case VK_UP:
                gameJPanel.toRotate();
                //handleThread.sendMessage("up");
                gameJPanel.repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==VK_DOWN)
            isSpeedUp=false;
    }
}
