package wiproPracticeDay1;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3, 7, 1, 9, 4, 6};

        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * 2;
        }

        
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

	}

}
