package wiproPracticeDay1;

public class largest {

	public static void main(String[] args) {
		int[] numbers = {100, 67, 98, 678, 45, 123};

        int max = numbers[0]; 

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i]; 
            }
        }

        System.out.println(max);

	}

}
