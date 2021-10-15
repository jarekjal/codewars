package jarejal.codewars;

import java.util.stream.IntStream;

public class PangramChecker {
    public boolean check(String sentence){
        boolean result = IntStream.range('a', 'a' + 26).mapToObj(i -> "" + (char) i)
                .map(sentence.toLowerCase()::contains).anyMatch(b -> !b);
        return !result;
    }
}
