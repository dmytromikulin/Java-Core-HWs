import java.util.List;
import java.util.stream.Collectors;

class StringProcessor {

    public List<String> toUpperAndSortDescending(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
    }
}
