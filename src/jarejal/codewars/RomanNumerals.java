package jarejal.codewars;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class RomanNumerals {

    private static final String[] digitPatterns = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final Map<String, Integer> romanToInteger;

    static {
        romanToInteger = new TreeMap<>();
        IntStream.range(1, 4000).forEach(i -> {
            romanToInteger.put(toRoman(i), i);
        });
    }

    public static String toRoman(int n) {
        if (n < 1 || n >= 4000) throw new IllegalArgumentException("Argument to convert must be integer <1-4000)");
        String number = String.valueOf(n);
        int[] digits = new int[4];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(number.charAt(number.length() - i - 1)));
        }
        StringBuilder result = new StringBuilder();
        for (int i = digits.length - 1; i >= 0 ; i--) {
            result.append(getRomanDigit(digits[i], i));
        }
        //System.out.println(result);
        return result.toString();
    }

    public static int fromRoman(String romanNumeral) {
        return romanToInteger.get(romanNumeral);
    }

    private static String getRomanDigit(int digit, int position) {
        String result = digitPatterns[digit];
        switch (position) {
            case 1:
                result = insertIntoPattern(result, "C", "L", "X");
                break;
            case 2:
                result = insertIntoPattern(result, "M", "D", "C");
                break;
            case 3:
                result = insertIntoPattern(result, "X", "V", "M");
                break;
            default:
                break;
        }
        return result;
    }

    private static String insertIntoPattern(String digitPattern, String x, String v, String i){
        return digitPattern.replaceAll("X", x)
                .replaceAll("V", v)
                .replaceAll("I", i);
    }
}
