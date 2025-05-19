import java.util.concurrent.Semaphore;

public class H2O extends Thread {
    private final int num;
    private final Semaphore h2oCreated;

    public H2O(int num, Semaphore h2oCreated) {
        this.num = num;
        this.h2oCreated = h2oCreated;
    }

    public void run() {
        System.out.println("NUM=" + num + " H20 Created");
        h2oCreated.release();
    }
}