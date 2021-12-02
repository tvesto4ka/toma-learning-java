package helpers;

import java.util.ArrayList;

public class ArrayCreator {

    public static ArrayList<Integer> createArray(int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}
