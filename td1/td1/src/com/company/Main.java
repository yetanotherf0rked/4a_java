package com.company;

import Transport.Camion;

public class Main {

    public static void main(String[] args) {
        Camion man = new Camion("Man", 6.50, 130, 100.0);
        System.out.println("Camion : " + man.getMarque() + "\nPoids : " + man.getPoids() + "\nPuissance : " + man.getPuissance() + "\nVitesse max : " + man.getVitesseMax());

    }
}
