import helpers.ArrayCreator;
import helpers.ArrayPrinter;
import helpers.Greeting;

import java.util.ArrayList;

public class Simple {
    public static void main(String[] args) {

        Greeting greeting = new Greeting();
        greeting.sayHi();

        int arraySize = 100;
        ArrayList<Integer> myArray = ArrayCreator.createArray(arraySize);

        ArrayPrinter printer = new ArrayPrinter(myArray);
        if (printer.print()) {
            System.out.println("All good");
        } else {
            System.out.println("Have problems");
        }

        greeting.sayBye();
    }
}
