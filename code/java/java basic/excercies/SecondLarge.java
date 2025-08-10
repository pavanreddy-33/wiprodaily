package wiproPracticeDay1;

public class SecondLarge {

	public static void main(String[] args) {
		int[] arr = {10, 5, 20, 8, 15};

        int first = 0;
        int second = 0;

        for (int i = 0; i<arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if (second == Integer.MIN_VALUE) {
            System.out.println("single element in the array");
        } else {
            System.out.println(second);
        }
	}

}
