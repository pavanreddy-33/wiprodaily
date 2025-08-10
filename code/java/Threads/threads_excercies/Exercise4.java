import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                for (int j = 1; j <= 10; j++) {
                    System.out.println(Thread.currentThread().getName() + " -> " + j);
                    try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            });
        }
        executor.shutdown();
    }
}