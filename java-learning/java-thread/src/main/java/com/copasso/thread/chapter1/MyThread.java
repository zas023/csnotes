package com.copasso.thread.chapter1;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread:"+getName());
    }
}
