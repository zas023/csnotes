package com.copasso.java.thread;

public class NewThread1 extends Thread{
    NewThread1() {
        // 创建第二个新线程
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        start(); // 开始线程
    }

    // 第二个线程入口
    public void run() {
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                // 让线程休眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}
