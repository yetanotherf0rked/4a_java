package rwressource;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

public class Ressource {

    private String myRessource;
    private final Lock lock;
    private final Semaphore s;
    private final Condition freeToWrite;
    private WriterCounter writerCounter;
    private ReaderCounter readerCounter;
    private int maxReadersAllowed;
    private boolean hasUniqueOwner;
    private String ownerName;

    // Exercice 1a et 1b : nombre de rédacteurs variable
    public Ressource (int maxReadersAllowed, ReaderCounter readerCounter, WriterCounter writerCounter){
        this.myRessource= "Blank for now";
        this.readerCounter = readerCounter;
        this.writerCounter = writerCounter;
        this.maxReadersAllowed = maxReadersAllowed;
        this.lock = new ReentrantLock();
        this.freeToWrite = lock.newCondition();
        this.s = new Semaphore(maxReadersAllowed, true);
        this.hasUniqueOwner = false;
        this.ownerName = null;
    }


    // Exercice 2 : un seul rédacteur autorisé
    public Ressource (int maxReadersAllowed, ReaderCounter readerCounter, WriterCounter writerCounter, String ownerName){
        this.myRessource= "Blank for now";
        this.readerCounter = readerCounter;
        this.writerCounter = writerCounter;
        this.lock = new ReentrantLock();
        this.freeToWrite = lock.newCondition();
        this.s = new Semaphore(maxReadersAllowed, true);
        this.hasUniqueOwner = true;
        this.ownerName = ownerName;
    }

    public boolean write(String newRessource, String writerName) throws InterruptedException {
        if (hasUniqueOwner && !ownerName.equals(writerName)) {
            System.out.println(writerName + " is not allowed to write in the ressource. Aborting...");
            return false;
        }
        try {
            this.writerCounter.increment();
            lock.lock();
            this.myRessource = newRessource;
            this.writerCounter.decrement();
            if (this.writerCounter.getNbWriters() == 0) {
                this.freeToWrite.signalAll();
            }
        } finally {
            lock.unlock();
            return true;
        }
    }

    public String read() throws InterruptedException {
        try {
            // We make sure that no writer is currently writing
            lock.lock();
            while(this.writerCounter.getNbWriters() > 0) {
                System.out.println("Reader is trying to read, but a writer is actually writing");
                this.freeToWrite.await();
            }
            lock.unlock();

            // We make sure that maxReadersAllowed isn't reached
            s.acquire();
            this.readerCounter.increment();
            return this.myRessource;
        } finally {
            s.release();
            this.readerCounter.decrement();
        }
    }
}
