package com.copasso.thread.chapter1;

public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
    }
        /*
        运行结束
        MyThread:Thread-0
         */
}
