package com.company;

import rwressource.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Exercice 1a (Priorité aux writers, 5 readers, 3 writers)

//        int nbReaders = 5;
//        int nbWriters = 3;
//        int maxReadersAllowed = nbReaders;
//        WriterCounter writerCounter = new WriterCounter();
//        ReaderCounter readerCounter = new ReaderCounter(maxReadersAllowed);
//        Ressource r = new Ressource(maxReadersAllowed, readerCounter, writerCounter);

        // Exercice 1b (Nb de lecteurs bornés, 10 readers, 5 writers, 1 reader simultané max)

//        int nbReaders = 20;
//        int nbWriters = 10;
//        int maxReadersAllowed = 1;
//        WriterCounter writerCounter = new WriterCounter();
//        ReaderCounter readerCounter = new ReaderCounter(maxReadersAllowed);
//        Ressource r = new Ressource(maxReadersAllowed, readerCounter, writerCounter);

        // Exercice 2 (un seul rédacteur autorisé à modifier la ressource, ici : "Writer 1")

        int nbReaders = 5;
        int nbWriters = 3;
        int maxReadersAllowed = nbReaders;
        WriterCounter writerCounter = new WriterCounter();
        ReaderCounter readerCounter = new ReaderCounter(maxReadersAllowed);
        Ressource r = new Ressource(maxReadersAllowed, readerCounter, writerCounter, "Writer 1");

        // Code commun aux trois questions

        int nbIterationsReaders = 5;
        int nbIterationsWriters = 10;

        ArrayList<Reader> readers = new ArrayList<Reader>();
        ArrayList<Writer> writers = new ArrayList<Writer>();


        for (int i = 0; i < nbWriters; i++) {
            writers.add(new Writer("Writer " + (i + 1), r, nbIterationsWriters));
        }


        for (int i = 0; i < nbReaders; i++) {
            readers.add(new Reader("Reader " + (i + 1), r, nbIterationsReaders));
        }

        for (Writer writer : writers) {
            writer.start();
        }

        for (Reader reader : readers) {
            reader.start();
        }

        for (Writer writer : writers) {
            try {
                writer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Reader reader : readers) {
            try {
                reader.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

