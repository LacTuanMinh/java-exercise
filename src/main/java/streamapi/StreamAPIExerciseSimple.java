package streamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class StreamAPIExerciseSimple {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamAPIExerciseSimple.class);

    public static void main(String[] args) {
        StreamAPIExerciseSimple excercise = new StreamAPIExerciseSimple();
        LOGGER.info("{}", excercise.exercise1());
        LOGGER.info("{}", excercise.exercise2());
        LOGGER.info("{}", excercise.exercise3());
        LOGGER.info("{}", excercise.exercise4());
    }

    public Set<Integer> exercise1() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        // TODO: divide each number by 2 (ignoring the reminder) and collect to set
        Set<Integer> result = numbers.stream().map(number -> number / 2).collect(Collectors.toSet());
        return result;
    }

    public List<Integer> exercise2() {
        List<String> strings = asList("9", "4", "5", "6", "2", "3", "9", "4", "3", "4", "5");
        // TODO: find all distinct reminders of division by 13 and collect them sorted
        // [2, 3, 4, 5, 6, 9]

        List<Integer> result = strings.stream().map(string -> {
            int value = Integer.parseInt(string);
            return value % 13;
        }).distinct().sorted().collect(Collectors.toList());

        return result;
    }

    public int exercise3() {
        List<String> strings = asList("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit.");
        // TODO: find the length of the longest string

        Optional<String> result = strings.stream().max(Comparator.comparingInt(String::length));
        return result.get().length();
    }

    public List<Integer> exercise4() {
        IntStream numbers = new Random(0).ints().map(Math::abs);

        List<Integer> collected = numbers.filter(n -> n % 17 == 0).limit(5).boxed().collect(Collectors.toList());
        // TODO: find first 5 numbers divisible by 17 generate by an infinite stream
        // [938301587, 100082026, 356750287, 798819494, 1412716779]
        return collected;
    }
}
