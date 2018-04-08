package com.copasso.thread.chapter1.section2;

public class MyThreadTest1 {

    public static void main(String[] args) {
        MyThread thread=new MyThread();
        Thread a = new Thread(thread,"A");
        Thread b = new Thread(thread,"B");
        Thread c = new Thread(thread,"C");
        a.start();
        b.start();
        c.start();

    }
}
