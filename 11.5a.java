import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterator;
import java.util.Spliterators;

public static void main(String[] args) {
    Stream<String> firstStream = Stream.of("A", "B", "C");
    Stream<String> secondStream = Stream.of("1", "2", "3", "4");

    Stream<String> zippedStream = StreamUtils.zip(firstStream, secondStream);
    zippedStream.forEach(System.out::println);
}