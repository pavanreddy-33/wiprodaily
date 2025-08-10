public class Exercise1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Number: " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        Thread t2 = new Thread(() -> {
            for (char c = 'A'; c <= 'J'; c++) {
                System.out.println("Alphabet: " + c);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        });

        t1.start();
        t2.start();
    }
}