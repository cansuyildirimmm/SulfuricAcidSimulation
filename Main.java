public class Main {
    public static final int TOTAL = 1000;

    public static void main(String[] args) {
        for (int i = 1; i <= TOTAL; i++) {
            int finalI = i;
            Thread t = new Thread(() -> new SulfuricAcidFactory(finalI).startProduction());
            t.start();
            try {
                t.join(); // Sırayla üretim için (istersen kaldırabiliriz)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}