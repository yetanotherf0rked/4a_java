package com.company;
import transport.Camion;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Vector<Camion> camions = new Vector<Camion>();
        Random rand = new Random();
        for (int i=0;i<500;i++) {
            camions.add(new Camion("Truck"+i, rand.nextDouble()*30+15, rand.nextInt(200)+100, rand.nextDouble()*30+70));
        }

        Iterator<Camion> camion = camions.iterator();
        while(camion.hasNext()) {
            System.out.println(camion.next().getMarque() + " : " + camion.next().getPoids() + " t, " + camion.next().getPuissance() + " hp, " + camion.next().getVitesseMax() + " km/h.");
        }
    }
}