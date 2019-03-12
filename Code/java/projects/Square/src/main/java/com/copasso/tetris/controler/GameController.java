package com.copasso.tetris.controler;

import com.copasso.tetris.util.Constant;
import com.copasso.tetris.view.GameJPanel;
import com.copasso.tetris.view.MenuJPanel;

import javax.swing.*;
import java.awt.*;
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

    //界面
    private GameJPanel gameJPanel;  //游戏界面
    private GameJPanel gameJPanel2; //对手游戏界面
    private MenuJPanel menuJPanel;  //信息显示界面

    //时间控制器，加载GameTask，每过一段时间，界面就变化一次
    private Timer timer;

    //是否正在游戏中
    private boolean isRunning;
    //是否加速下落
    private boolean isSpeedUp;
    //对手是否结束
    private boolean isEnd;

    //分数
    private int score1,score2;

    //远程通信控制器
    private ServerController serverController;

    public GameController(JPanel panel1,JPanel panel2,JPanel panel3){
        this.gameJPanel= (GameJPanel) panel1;
        this.gameJPanel2= (GameJPanel) panel2;
        this.menuJPanel= (MenuJPanel) panel3;
    }

    /**
     * 游戏定时器
     */
    private class GameTask extends TimerTask {
        private int speed = 5;
        public void run() {
            System.out.println("Running");
            if(!isRunning){
                return ;
            }
            if (gameJPanel.isGameOver()){
                //游戏结束
                System.out.println("begin to end game");
                menuJPanel.setInfo("Waiting for end..." );
                try {
                    toServer.writeInt(Constant.MSG_END);
                    serverController.sendMap(gameJPanel.getMap());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (isEnd){
                    isRunning=false;
                    if (score1>score2)
                        menuJPanel.setInfo("You Win");
                    else if (score2>score1)
                        menuJPanel.setInfo("You lost");
                    else
                        menuJPanel.setInfo("It ends in a draw");
                    return;
                }
            }else {
                //游戏中
                System.out.println("randomBlocks start");
                gameJPanel.randomBlocks();
                while (gameJPanel.canDrop()){
                    gameJPanel.drop(); // 下降
                    if (!gameJPanel.isFall()){
                        break;
                    }
                    gameJPanel.toDown();
                    try {
                        // 休眠，加速休眠一毫秒，未加速休眠500毫秒
                        Thread.sleep(isSpeedUp ? 25 : 500);
                        // 提交地图
                        serverController.sendMap(gameJPanel.getMap());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // 下落到遇到阻碍为止，修改图形方块状态
                gameJPanel.changeBolckState();
                // 判断是否可消除行
                int score=gameJPanel.getScore();
                if(score>score1){
                    //得分
                    score1=score;
                    menuJPanel.setScore(score1,score2);
                    try {
                        serverController.sendScore(score1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /***************************Control*************************************/

    /**
     * 启动游戏
     */
    public void startGame(){
        timer = new Timer();
        timer.schedule(new GameTask(), 100,30);

        connectToServer();
    }

    /**
     * 设置游戏状态：暂停、恢复
     * @param is
     */
    public void setRunning(boolean is){
       this.isRunning=is;
       if (is)
           menuJPanel.setInfo("Running ...");
       else
           menuJPanel.setInfo("Waiting for ...");
    }

    /**
     * 设置结束游戏
     * @param is
     */
    public void setEnd(boolean is){
        this.isEnd=is;
    }

    /**
     * 是否正在运行
     * @return
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * 设置游戏分数
     * @param sore1
     * @param socre2
     */
    public void setScore(int sore1,int socre2){
        score2=socre2;
        menuJPanel.setScore(score1,score2);
    }

    /**
     * 设置对手游戏地图
     * @param map
     */
    public void setMapColor(Color[][] map){
        System.out.println("setMap");
        gameJPanel2.setMapColor(map);
    }

    /***************************NetWork*************************************/
    // Input and output streams from/to server
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    private String host = "localhost";

    /**
     * 连接服务器
     */
    private void connectToServer() {
        try {
            // Create a socket to connect to the server
            Socket socket;
            socket = new Socket(host, 8000);
            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());
            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());

            serverController =new ServerController(fromServer,toServer,this);
            System.out.println("serverController start");
            new Thread(serverController).start();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }

    /***************************Event*************************************/
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case VK_LEFT:
                gameJPanel.toLeft();
                break;
            case VK_RIGHT:
                gameJPanel.toRight();
                break;
            case VK_DOWN:
                // 标记可以加速下落
                isSpeedUp=true;
                break;
            case VK_UP:
                gameJPanel.toRotate();
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==VK_DOWN)
            isSpeedUp=false;
    }
}
