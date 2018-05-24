package com.copasso.thread.chapter1.section2;

public class MyThread extends Thread{
    private int count=5;
    public  MyThread(){

    }
    public MyThread(String name){
        setName(name);
    }
    @Override
    public void run() {
        super.run();
        while (count>0){
            System.out.println(currentThread().getName()+": count="+count--);
        }
    }
}
