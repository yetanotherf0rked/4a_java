package rwressource;

public class Reader extends Thread {
    private final Ressource ressource;
    private String threadName;
    private Integer nbIterations;

    public Reader(String threadName, Ressource ressource, Integer nbIterations) {
        this.threadName = threadName;
        this.ressource = ressource;
        this.nbIterations = nbIterations;
    }

    @Override
    public void run() {
        String read;
        try {
            for (int i = 0; i < nbIterations; i++) {
                read = ressource.read();
                System.out.println(this.threadName + " reads: " + read);
                sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.threadName + ": finished reading " + nbIterations + " times");
    }
}
