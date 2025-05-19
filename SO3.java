import java.util.concurrent.Semaphore;

public class SO3 extends Thread {
    private final int num;
    private final Semaphore so2Created;
    private final Semaphore o2Created;
    private final Semaphore so3Created;

    public SO3(int num, Semaphore so2Created, Semaphore o2Created, Semaphore so3Created) {
        this.num = num;
        this.so2Created = so2Created;
        this.o2Created = o2Created;
        this.so3Created = so3Created;
    }

    public void run() {
        try {
            so2Created.acquire();
            o2Created.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NUM=" + num + " SO3 Created");
        so3Created.release();
    }
}