package com.company;
import transport.Camion;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Vector<Camion> camions = new Vector<Camion>();
        camions.add(new Camion("Renault",10,300,90));
        camions.add(new Camion("Mann",12,350,92));
        camions.add(new Camion("Volvo",8,280,95));

        Iterator<Camion> camion = camions.iterator();
        while(camion.hasNext()) {
            System.out.println(camion.next().getMarque());
        }
    }
}