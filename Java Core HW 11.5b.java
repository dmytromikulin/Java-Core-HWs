import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterator;
import java.util.Spliterators;

class StreamUtils {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zipIterator = new Iterator<>() {
            boolean toggle = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (toggle) {
                    toggle = !toggle;
                    return firstIterator.next();
                } else {
                    toggle = !toggle;
                    return secondIterator.next();
                }
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(zipIterator, Spliterator.ORDERED),
                false
        );
    }
}
