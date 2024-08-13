package basics;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] tokens = s.split(" ");
        String lastWord = "";
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (!tokens[i].isEmpty()) {
                lastWord = tokens[i];
                break;
            }
        }
        return lastWord.length();
    }

    public static void main(String[] args) {
        String s1 = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s1));
    }
}
