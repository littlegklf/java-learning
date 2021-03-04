package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kuanglifang
 * @date 2021/3/1 17:12
 */
public class StreamExercise {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        words.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);
    }
}
