package EPAM.interview;

import java.util.StringTokenizer;

public class AcronymHelper {
    public static final String message = "Hi my      name is Toma";

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

    public static String getAcronymWithTokenizer(String input) {
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.length() > 0) {
                result.append(word.charAt(0));
            }
        }
        return result.toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(getAcronym(message));
        System.out.println(getAcronymWithTokenizer(message));
    }
}
