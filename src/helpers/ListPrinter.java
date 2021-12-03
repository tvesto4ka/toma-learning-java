package helpers;

import java.util.List;

public class ListPrinter {

    public boolean print(List<?> list) {
        try {
            if (list.contains(100)) {
                throw new RuntimeException();
            }
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println();
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }
}
