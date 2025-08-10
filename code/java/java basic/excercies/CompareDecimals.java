package wiproPracticeDay1;

public class CompareDecimals {

	public static void main(String[] args) {
		float num1 = 25.586f;
        float num2 = 25.5899f;

        
        int n1 = Math.round(num1 * 1000); // 25586
        int n2 = Math.round(num2 * 1000); // 25589
        if (n1 == n2) {
            System.out.println("They are the same up to three decimal places");
        } else {
            System.out.println("They are different");
        }

	}

}
