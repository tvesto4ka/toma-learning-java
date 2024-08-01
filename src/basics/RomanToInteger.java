package basics;

//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.

public class RomanToInteger {
    public static int romanToInt(String s) {
        int result = 0;
        char prevLetter = 'o';
        for (int i = 0; i < s.length(); i++) {
            char currLetter = s.charAt(i);
            if (currLetter == 'V' && prevLetter == 'I') result += 3;
            else if (currLetter == 'X' && prevLetter == 'I') result += 8;
            else if (currLetter == 'L' && prevLetter == 'X') result += 30;
            else if (currLetter == 'C' && prevLetter == 'X') result += 80;
            else if (currLetter == 'D' && prevLetter == 'C') result += 300;
            else if (currLetter == 'M' && prevLetter == 'C') result += 800;
            else if (currLetter == 'I') result += 1;
            else if (currLetter == 'V') result += 5;
            else if (currLetter == 'X') result += 10;
            else if (currLetter == 'L') result += 50;
            else if (currLetter == 'C') result += 100;
            else if (currLetter == 'D') result += 500;
            else if (currLetter == 'M') result += 1000;
            prevLetter = s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
