package mythread;

public class MyThread extends Thread {

    private String threadName;
    private int n;

    public MyThread(String threadName, int n) {
        this.threadName = threadName;
        this.n = n;
    }

    public void run(){
        for(int i=0; i<3; i++) {
            System.out.println(i + " : " + threadName);
            try {
                sleep(this.n*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
