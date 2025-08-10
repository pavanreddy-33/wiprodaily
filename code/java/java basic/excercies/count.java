package wiproPracticeDay1;

public class count {

	public static void main(String[] args) {
		String str = "chandrasekhIar";
        int vC = 0;
        int cC = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            ch = Character.toLowerCase(ch);
            
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vC++;
                } else {
                    cC++;
                }
            
        }

        System.out.println("Vowels: " + vC);
        System.out.println("Consonants: " + cC);
	}

}
