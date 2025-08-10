package wiproPracticeDay1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintNum {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            int taskId = i; 
            executor.submit(() -> {
                for (int j = 1; j <= 10; j++) {
                    System.out.println("Task " + taskId + ": " + j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Task " + taskId + " interrupted");                       
                    }
                }
            });
        }

        
    }
}
