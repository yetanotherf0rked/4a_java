package rwressource;

public class Writer extends Thread {

    private String threadName;
    private final Ressource ressource;
    private int nbIterations;

    public Writer (String threadName, Ressource ressource, int nbIterations){
        this.threadName = threadName;
        this.ressource = ressource;
        this.nbIterations = nbIterations;
    }

    public void run(){
        String newRessource = "Last modified by " + this.threadName;
        try {
            for(int i=0; i<nbIterations; i++){
                if(ressource.write(newRessource, threadName) == true) {
                    System.out.println(this.threadName + " writes: " + newRessource);
                    sleep(100);
                }
                else
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
