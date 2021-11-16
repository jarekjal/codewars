package jarekjal.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservedPin {

    private static final Map<String, List<String>> digitToDigitWithNeighbours;
    private static List<String> results;

    static {
        digitToDigitWithNeighbours = new HashMap<>(10);
        digitToDigitWithNeighbours.put("0", List.of("0", "8"));
        digitToDigitWithNeighbours.put("1", List.of("1", "2", "4"));
        digitToDigitWithNeighbours.put("2", List.of("2", "1", "3", "5"));
        digitToDigitWithNeighbours.put("3", List.of("3", "2", "6"));
        digitToDigitWithNeighbours.put("4", List.of("4", "1", "5", "7"));
        digitToDigitWithNeighbours.put("5", List.of("5", "2", "4", "6", "8"));
        digitToDigitWithNeighbours.put("6", List.of("6", "3", "5", "9"));
        digitToDigitWithNeighbours.put("7", List.of("7", "4", "8"));
        digitToDigitWithNeighbours.put("8", List.of("8", "5", "7", "9", "0"));
        digitToDigitWithNeighbours.put("9", List.of("9", "6", "8"));
    }

    public static List<String> getPINs(String observed) {
        results = new ArrayList<>();
        String d0 = getLettersAsListOfStrings(observed).get(0);
        results.addAll(digitToDigitWithNeighbours.get(d0));
        run(0, observed);
        return results;
    }

    private static void run(int cnt, String observed) {
        List<String> tmp = new ArrayList<>();
        int position = cnt + 1;
        if (position >= observed.length()) return;
        results.forEach(digits -> {
            digitToDigitWithNeighbours.get(Character.toString(observed.charAt(position)))
                    .forEach(nextDigit -> tmp.add(digits + nextDigit));
        });
        results = tmp;
        cnt++;
        if (cnt < observed.length() - 1) {
            run(cnt, observed);
        }
    }

    private static List<String> getLettersAsListOfStrings(String input) {
        List<String> result = new ArrayList<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            String s = "" + input.charAt(i);
            result.add(s);
        }
        return result;
    }
}

