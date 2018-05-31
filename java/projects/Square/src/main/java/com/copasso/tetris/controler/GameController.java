package com.copasso.tetris.controler;

import com.copasso.tetris.model.GameJPanel;
import com.copasso.tetris.server.HandleThread;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_DOWN;

/**
 * 游戏控制器
 */
public class GameController implements KeyListener {

    // 界面
    private GameJPanel panel;
    // 时间控制器，加载GameTask，每过一段时间，界面就变化一次
    private Timer timer;

    private boolean isRunning;
    private boolean isSpeedUp;

    public GameController(JPanel panel){
        this.panel= (GameJPanel) panel;
    }

    // 远程通信用的线程
    private HandleThread handleThread;

    private class GameTask extends TimerTask {
        private int speed = 5;
        public void run() {
            System.out.println("game start");
            if(!isRunning){
                return ;
            }
            if (panel.isGameOver()){
                //游戏结束
                System.out.println("begin to end game");
                // 先暂停游戏
                isRunning = false;
                handleThread.sendMessage("GameOver");
                return;
            }else {
                System.out.println("randomBlocks start");
                panel.randomBlocks();
                int i=0;
                while (panel.canDrop()){
                    panel.drop(); // 下降
                    if (!panel.isFall()){
                        break;
                    }
                    panel.toDown();
                    panel.repaint();
                    try {
                        // 休眠，加速休眠一毫秒，未加速休眠500毫秒
                        Thread.sleep(isSpeedUp ? 50 : 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i++);
                }
                // 下落到遇到阻碍为止，修改图形方块状态
                System.out.println("changeBolckState start");
                long startTime=System.currentTimeMillis();
                panel.changeBolckState();
                long endTime=System.currentTimeMillis();
                System.out.println(""+(endTime-startTime));
                panel.repaint();
                System.out.println("changeBolckState end");
                // 判断是否可消除行
                int score=panel.getScore();
                System.out.println("judgeBolcks end");
            }
        }
    }

    /**
     * 启动游戏
     */
    public void startGame(){

        isRunning =true;

        timer = new Timer();
        timer.schedule(new GameTask(), 100,30);
    }

    /**
     * 是否正在运行
     * @return
     */
    public boolean isRunning() {
        return isRunning;
    }

    /****************************************************************/
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case VK_LEFT:
                panel.toLeft();
                //handleThread.sendMessage("left");
                panel.repaint();
                break;
            case VK_RIGHT:
                panel.toRight();
                //handleThread.sendMessage("right");
                panel.repaint();
                break;
            case VK_DOWN:
                // 标记可以加速下落
                isSpeedUp=true;
                break;
            case VK_UP:
                panel.toRotate();
                //handleThread.sendMessage("up");
                panel.repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==VK_DOWN)
            isSpeedUp=false;
    }
}
