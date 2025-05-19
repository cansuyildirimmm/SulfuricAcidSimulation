import java.util.concurrent.Semaphore;

public class SulfuricAcidFactory {
    private final int number;

    private final Semaphore sCreated = new Semaphore(0);
    private final Semaphore o2Created = new Semaphore(0);
    private final Semaphore h2oCreated = new Semaphore(0);
    private final Semaphore so2Created = new Semaphore(0);
    private final Semaphore so3Created = new Semaphore(0);

    public SulfuricAcidFactory(int number) {
        this.number = number;
    }

    public void startProduction() {
        Thread s = new S(number, sCreated);
        Thread o2_1 = new O2_1(number, o2Created);
        Thread o2_2 = new O2_2(number, o2Created);
        Thread h2o = new H2O(number, h2oCreated);
        Thread so2 = new SO2(number, sCreated, o2Created, so2Created);
        Thread so3 = new SO3(number, so2Created, o2Created, so3Created);
        Thread h2so4 = new H2SO4(number, so3Created, h2oCreated);

        s.start();
        o2_1.start();
        o2_2.start();
        h2o.start();
        so2.start();
        so3.start();
        h2so4.start();

        try {
            s.join();
            o2_1.join();
            o2_2.join();
            h2o.join();
            so2.join();
            so3.join();
            h2so4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}