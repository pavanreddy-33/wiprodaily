package wiproPracticeDay1;

public class conditionals2 {
    public static void main(String[] args) {
        float number = 1000000000f;

        if (number == 0) {
            System.out.println("Zero");
            return; 
        }

        System.out.println(number > 0 ? "Positive number" : "Negative number");

        float abs = Math.abs(number);
        if (abs < 1)
            System.out.println("Small number");
        else if (abs > 1_000_000)
            System.out.println("Large number");
    }
}
