import java.util.concurrent.Semaphore;

public class S extends Thread {
    private final int num;
    private final Semaphore sCreated;

    public S(int num, Semaphore sCreated) {
        this.num = num;
        this.sCreated = sCreated;
    }

    public void run() {
        System.out.println("NUM=" + num + " S Created");
        sCreated.release();
    }
}