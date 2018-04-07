package com.copasso.thread.chapter1;

public class Test {
    public static void main(String[] args) {
        //start()执行顺序不代表线程启动顺序
        for (int i=0;i<10;i++){
            MyThread thread=new MyThread();
            thread.setName("Thread-"+i);
            thread.start();
        }

//        MyThread thread1=new MyThread();
//        thread1.setName("Thread-"+1);
//        MyThread thread2=new MyThread();
//        thread2.setName("Thread-"+2);
//        MyThread thread3=new MyThread();
//        thread3.setName("Thread-"+3);
//        MyThread thread4=new MyThread();
//        thread4.setName("Thread-"+4);
//        MyThread thread5=new MyThread();
//        thread5.setName("Thread-"+5);
//        MyThread thread6=new MyThread();
//        thread6.setName("Thread-"+6);
//        MyThread thread7=new MyThread();
//        thread7.setName("Thread-"+7);
//        MyThread thread8=new MyThread();
//        thread8.setName("Thread-"+8);
//        MyThread thread9=new MyThread();
//        thread9.setName("Thread-"+9);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
//        thread9.start();
    }
}
