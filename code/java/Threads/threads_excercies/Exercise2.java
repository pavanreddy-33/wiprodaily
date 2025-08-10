import java.util.Arrays;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) throws InterruptedException {
        List<String> names = Arrays.asList("Amit", "Jayanta", "Suresh", "Anita");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if ("AEIOUaeiou".indexOf(name.charAt(0)) != -1) {
                    names.set(i, name.toUpperCase());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if ("AEIOUaeiou".indexOf(name.charAt(0)) == -1) {
                    names.set(i, name.toLowerCase());
                }
            }
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final List: " + names);
    }
}