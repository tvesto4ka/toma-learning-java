package EPAM.interview;

public class AcronymHelper {
    public static String getAcronym(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(word.charAt(0));
            }
        }
        return result.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(getAcronym("Hi my      name is Toma"));
    }
}
