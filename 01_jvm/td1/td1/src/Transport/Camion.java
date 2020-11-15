package Transport;

public class Camion implements Vehicule {

    public String getMarque() {
        return marque;
    }

    public float getPoids() {
        return poids;
    }

    public int getPuissance() {
        return puissance;
    }

    public float getVitesseMax() {
        return vitesseMax;
    }

    public Boolean getEtat() {
        return etat;
    }

    public float getVitesse() {
        return vitesse;
    }

    /**
     * Marque du camion
     */
    private String marque;

    /**
     * Poids du camion
     */
    private float poids;

    /**
     * Puissance exprimée en chevaux
     */
    private int puissance;

    /**
     * Vitesse maximum que peut atteindre le camion
     */
    private float vitesseMax;
    private Boolean etat = false;
    private float vitesse = 0;


    public Camion(String marque, float poids, int puissance, float vitesseMax) {
        this.marque = marque;
        this.poids = poids;
        this.puissance = puissance;
        this.vitesseMax = vitesseMax;
    }

    public void demarrer() {
        this.etat = true;
    }

    public void rouler() {
        this.vitesse = this.vitesseMax ;
    }

    public void freiner() {
        this.vitesse = 0;
    }

    public void arreter() {
        this.vitesse = 0;
        this.etat = false;
    }
}
