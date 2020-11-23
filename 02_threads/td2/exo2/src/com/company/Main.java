package com.company;
import mythread.MyThread;

public class Main {
    public static void main(String[] args){
        try {
            if (args.length != 2) {
                System.err.println("usage : Main n1 n2");
                System.exit(1);
            }
            MyThread myThread1 = new MyThread("myThread1", 1);
            MyThread myThread2 = new MyThread("myThread2", 1);
            myThread1.start();
            myThread2.start();
            myThread1.join();
            myThread2.join();
        } catch (Exception e) {
            System.err.println("Exception in main " + e);
        }
    }
}
