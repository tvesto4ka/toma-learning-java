package helpers;

import java.util.ArrayList;

public class ArrayPrinter {
    private ArrayList<Integer> arrayList;

    public ArrayPrinter(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public boolean print() {
        try {
            if (arrayList.contains(100)) {
                throw new RuntimeException();
            }
            for (int i : arrayList) {
                System.out.print(i + " ");
            }
            System.out.println();
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }
}
