import java.util.concurrent.Semaphore;

public class SO2 extends Thread {
    private final int num;
    private final Semaphore sCreated;
    private final Semaphore o2Created;
    private final Semaphore so2Created;

    public SO2(int num, Semaphore sCreated, Semaphore o2Created, Semaphore so2Created) {
        this.num = num;
        this.sCreated = sCreated;
        this.o2Created = o2Created;
        this.so2Created = so2Created;
    }

    public void run() {
        try {
            sCreated.acquire();
            o2Created.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NUM=" + num + " SO2 Created");
        so2Created.release();
    }
}