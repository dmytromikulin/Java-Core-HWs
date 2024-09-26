import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public static void main(String[] args) {
    List<String> names = List.of("Ivan", "John", "Peter", "Maria", "Alice");

    String result = NameFormatter.formatNamesWithOddIndexes(names);
    System.out.println(result);
}