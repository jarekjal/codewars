package jarejal.codewars;

import java.util.*;
import java.util.stream.Collectors;

public class TopWords {
    public static List<String> top3(String s) {
        String text = s.toLowerCase(Locale.ROOT)    // TODO: Poprawic zachowanie dla wielokrotnych apostrofow w slowie
                .replaceAll("[^a-z' ]", " ")
                .replaceAll("'+", "'")
                .replaceAll(" ' ", " ")
                .replaceAll(" '$", "")
                .replaceAll("^' ", "")
                .replaceAll(" +", " ")
                .trim();
        //System.out.println(text);
        Map<String, Integer> wordToCount = new HashMap<>();
        Arrays.stream(text.split(" ")).forEach(w -> {
            if (wordToCount.containsKey(w)) {
                wordToCount.put(w, wordToCount.get(w) + 1);
            } else if (!w.equals("")){
                wordToCount.put(w, 1);
            }
        });
        return wordToCount.entrySet().stream().sorted((f1, f2) -> Integer.compare(f2.getValue(), f1.getValue()))
                .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
