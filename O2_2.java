import java.util.concurrent.Semaphore;

public class O2_2 extends Thread {
    private final int num;
    private final Semaphore o2Created;

    public O2_2(int num, Semaphore o2Created) {
        this.num = num;
        this.o2Created = o2Created;
    }

    public void run() {
        System.out.println("NUM=" + num + " O2 (2) Created");
        o2Created.release();
    }
}