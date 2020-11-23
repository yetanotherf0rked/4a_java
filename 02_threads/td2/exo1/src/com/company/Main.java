package com.company;
import mythread.MyThread;

public class Main {
    public static void main(String[] arg){
        MyThread myThread = new MyThread("myThread", 1);
        myThread.start();
    }
}
