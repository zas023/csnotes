package com.copasso.thread.chapter1.section3;

public class Run {
    public static void main(String[] args) {
        MyThread thread=new MyThread();
        thread.start();
        thread.run();
    }
}
