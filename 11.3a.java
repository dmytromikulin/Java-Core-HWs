import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public static void main(String[] args) {
    String[] array = {"1, 2, 0", "4, 5"};

    String result = NumberSorter.sortAndJoinNumbers(array);
    System.out.println(result);
}