import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class NumberSorter {

    public static String sortAndJoinNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
