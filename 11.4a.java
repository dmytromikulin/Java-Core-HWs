import java.util.stream.Stream;

public static void main(String[] args) {
    long a = 25214903917L;
    long c = 11L;
    long m = (long) Math.pow(2, 48);
    long seed = 0L;

    LinearCongruentialGenerator.generateRandomNumbers(seed, a, c, m)
            .limit(10)
            .forEach(System.out::println);
}