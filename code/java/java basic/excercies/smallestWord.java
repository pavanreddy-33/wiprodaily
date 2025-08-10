package wiproPracticeDay1;

public class smallestWord {

	public static void main(String[] args) {
		String str = "Wipro coding challenge interesting";
        String[] words = str.split(" ");
        String shortest = words[0]; 
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }
        System.out.println(shortest);
	}

}
