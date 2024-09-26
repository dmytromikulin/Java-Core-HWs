import java.util.stream.Stream;

class LinearCongruentialGenerator {

    public static Stream<Long> generateRandomNumbers(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}
