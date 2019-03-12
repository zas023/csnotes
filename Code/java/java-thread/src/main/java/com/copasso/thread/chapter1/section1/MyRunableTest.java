package com.copasso.thread.chapter1.section1;

public class MyRunableTest {
    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
        System.out.println("运行结束");
    }
}
