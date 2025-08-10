package wiproPracticeDay1;

public class removeDuplicate {

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};

        if (arr.length == 0) {
            System.out.println("0");
            return;
        }
        int j = 0; 

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j+1] = arr[i];
            }
        }
       
        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println((j + 1));

	}

}
