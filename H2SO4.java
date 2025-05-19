import java.util.concurrent.Semaphore;

public class H2SO4 extends Thread {
    private final int num;
    private final Semaphore so3Created;
    private final Semaphore h2oCreated;

    public H2SO4(int num, Semaphore so3Created, Semaphore h2oCreated) {
        this.num = num;
        this.so3Created = so3Created;
        this.h2oCreated = h2oCreated;
    }

    public void run() {
        try {
            so3Created.acquire();
            h2oCreated.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NUM=" + num + " H2SO4 Created");
    }
}