package basics;

public class FirstOccurrence {
    public static int firstOccurrenceOfSubstring(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String sub = haystack.substring(i, i + needle.length());
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstOccurrenceOfSubstring("sadbutsad", "sad"));
        System.out.println(firstOccurrenceOfSubstring("leetcode", "leeto"));
        System.out.println(firstOccurrenceOfSubstring("a", "a"));
    }
}
