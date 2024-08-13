package basics;

import java.util.StringTokenizer;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            str = stringTokenizer.nextToken();
        }
        return str.length();
    }

    public static void main(String[] args) {
        String s1 = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s1));
    }
}
