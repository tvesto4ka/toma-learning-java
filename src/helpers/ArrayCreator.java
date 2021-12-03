package helpers;

import java.util.ArrayList;
import java.util.List;

public class ArrayCreator {

    public static List<Integer> createIntegerArray(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    public static List<String> createStringArray(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + "");
        }
        return list;
    }
}
