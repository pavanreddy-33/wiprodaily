import java.util.Arrays;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Banana", "Apple", "Mango", "Cherry", "Orange");

        names.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }
}
