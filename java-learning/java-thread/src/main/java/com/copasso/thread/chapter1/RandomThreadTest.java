package com.copasso.thread.chapter1;

public class RandomThreadTest {
    public static void main(String[] args) {
        //线程具有随机性，CPU执行哪个线程具有不确定性
        try {
            RandomThread thread=new RandomThread();
            thread.setName("MyThread");
            thread.start();
            for (int i=0;i<10;i++){
                int time=(int) (Math.random()*1000);
                Thread.sleep(time);    //当前线程（主线程）暂停
                System.out.println("main=>"+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}