import java.util.List;
import java.util.stream.Collectors;
public static void main(String[] args) {
    StringProcessor processor = new StringProcessor();

    List<String> strings = List.of("Ivan", "John", "Peter", "Maria", "Alice");

    List<String> result = processor.toUpperAndSortDescending(strings);
    System.out.println(result);
}
