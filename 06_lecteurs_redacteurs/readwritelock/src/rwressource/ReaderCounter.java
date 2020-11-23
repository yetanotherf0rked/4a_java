package rwressource;

import java.util.concurrent.locks.*;

public class ReaderCounter {
    private int nbReaders;
    private int maxReadersAllowed;
    private final Lock lock;
    private final Condition maxReadersAllowedReached;

    public ReaderCounter(int maxReadersAllowed) {
        this.nbReaders = 0;
        this.maxReadersAllowed = maxReadersAllowed;
        this.lock = new ReentrantLock();
        this.maxReadersAllowedReached = lock.newCondition();
    }

    public void increment() {
        lock.lock();

        // If maxReaders is reached, a reader thread waits for the signal allowing him to read
        while (nbReaders >= maxReadersAllowed) {
            try {
                System.out.println("Maximum Readers allowed (" + maxReadersAllowed + ") reached : " + nbReaders);
                this.maxReadersAllowedReached.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.nbReaders++;
        lock.unlock();
    }

    public void decrement() {
        lock.lock();
        this.nbReaders--;
        if (nbReaders < maxReadersAllowed)
            this.maxReadersAllowedReached.signal();
        lock.unlock();
    }
}

