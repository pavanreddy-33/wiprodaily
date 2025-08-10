package wiproPracticeDay1;

public class Polindrome {

	public static void main(String[] args) {
//		String s = "madam";
//		String rev = "";
//		for(int i =0; i<s.length(); i++) {
//			rev = s.charAt(i)+rev;
//		}
//		
//		if (s.equalsIgnoreCase(rev)) {
//            System.out.println("palindrome.");
//        } else {
//            System.out.println("not");
//        }
		StringBuilder s = new StringBuilder("madaam");
        String str = s.reverse().toString();
        System.out.println(s.toString().equals(str));
    }
		

	}

}
