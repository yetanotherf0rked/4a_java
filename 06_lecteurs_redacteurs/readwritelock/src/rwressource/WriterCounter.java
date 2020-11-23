package rwressource;

import java.util.concurrent.locks.*;

public class WriterCounter {
    private int nbWriters;
    private final Lock lock;

    public WriterCounter() {
        this.nbWriters = 0;
        this.lock = new ReentrantLock();
    }

    public void increment(){
        lock.lock();
        this.nbWriters++;
        lock.unlock();
    }

    public void decrement(){
        lock.lock();
        this.nbWriters--;
        lock.unlock();
    }

    public int getNbWriters() {
        return nbWriters;
    }
}
