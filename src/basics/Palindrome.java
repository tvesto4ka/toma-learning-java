package basics;

public class Palindrome {
    public static boolean isPalindrome(int number) {
        String numToStr = Integer.toString(number);
        StringBuilder reverseNum = new StringBuilder();
        for (int i = numToStr.length() - 1; i >= 0; i--) {
            reverseNum.append(numToStr.charAt(i));
        }
        return reverseNum.toString().equals(numToStr);
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
