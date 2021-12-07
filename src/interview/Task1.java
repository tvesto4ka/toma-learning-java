package interview;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1 {
    public static int[] task1(int[] a) {
        if (IntStream.of(a).filter(value -> value < 0).findFirst().isPresent()) {
            throw new RuntimeException("Array contains negative value");
        }
        return IntStream.of(a).filter(value -> value >= 0).distinct().toArray();
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,3,-1,5};
        int[] array2 = task1(array);
        System.out.println(Arrays.toString(array2));
    }
}
