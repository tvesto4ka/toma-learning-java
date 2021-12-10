import helpers.ArrayCreator;
import helpers.ListPrinter;
import helpers.Greeting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Starter {
    public static void main(String[] args) {

        Greeting greeting = new Greeting();
        greeting.sayHi();

        int arraySize = 10;
        List<Integer> myArray = ArrayCreator.createIntegerArray(arraySize);

        ListPrinter printer = new ListPrinter();
        if (printer.print(myArray)) {
            System.out.println("All good");
        } else {
            System.out.println("Have problems");
        }

        List<String> myStringArray = ArrayCreator.createStringArray(arraySize);
        sort(myStringArray);

        printer.print(myStringArray);

        Stream
                .of(1, 2, 3, 2, 1)
                .map(s -> s * s)
                .distinct()
                .forEach(System.out::println);

        myArray.stream().mapToInt(a->a).min().ifPresent(System.out::println);

        greeting.sayBye();
    }

    public static void sort(List<String> list) {
        list.sort(Comparator.reverseOrder());
    }
}
