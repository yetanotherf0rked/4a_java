package com.company;
import transport.Camion;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Vector<Camion> camions = new Vector<>();
        Random rand = new Random();
        for (int i=1;i<800;i++) {
            camions.add(new Camion("Truck"+i, rand.nextDouble()*30+15, rand.nextInt(200)+100, rand.nextDouble()*30+70));
            if(i%20==0)
                camions.remove(i-5);
            System.out.println(i + " " + camions.lastElement().getMarque());
        }

        // Iterator<Camion> camion = camions.iterator();
        //while(camion.hasNext()) {
            // System.out.println(camion.next().getMarque() + " : " + camion.next().getPoids() + " t, " + camion.next().getPuissance() + " hp, " + camion.next().getVitesseMax() + " km/h.");
        //}
    }
}