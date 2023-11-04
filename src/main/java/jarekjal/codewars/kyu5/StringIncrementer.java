package jarekjal.codewars.kyu5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringIncrementer {

    public static String incrementString(String str) {
        String endingNumber = endingNumber(str);
        String leadingString;
        if (endingNumber == null) {
            return str + 1;
        } else {
            leadingString = str.substring(0, str.lastIndexOf(endingNumber));
            int zeroesCount = leadingZeroes(endingNumber);
            String numberWithoutZeroes = endingNumber.substring(zeroesCount);
            BigInteger bi = new BigInteger(numberWithoutZeroes.isEmpty() ? "0" : numberWithoutZeroes);
            bi = bi.add(BigInteger.ONE);
            String incrementedNumber = bi.toString();
            int incrementedNumberLength = incrementedNumber.length();
            if (incrementedNumberLength >= endingNumber.length()) {
                return leadingString + incrementedNumber;
            } else {
                return leadingString + zeroes(endingNumber.length() - incrementedNumberLength) + incrementedNumber;
            }
        }
    }

    private static String zeroes(int z) {
        return "0".repeat(Math.max(0, z));
    }

    private static int leadingZeroes(String endingNumber) {
        int cnt = 0;
        for (int i = 0; i < endingNumber.length(); i++) {
            if (endingNumber.charAt(i) == '0') {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    private static String endingNumber(String str) {
        int cursor = str.length() - 1;
        List<Character> digits = new ArrayList<>();
        while (cursor >= 0) {
            if (Character.isDigit(str.charAt(cursor))) {
                digits.add(str.charAt(cursor));
            } else {
                break;
            }
            cursor--;
        }
        if (digits.isEmpty()) {
            return null;
        } else {
            Collections.reverse(digits);
            return digits.stream().map(ch -> "" + ch).reduce("", (a, b) -> a + b);
        }
    }
}
