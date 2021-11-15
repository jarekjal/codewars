package jarejal.codewars;

import java.util.HashSet;
import java.util.Set;

public class ColouredTriangles {
    public static char triangle(final String row) {
        String r = row != null ? row : "";
        while(r.length() > 1){
            r = simplifyRow(r);
        }
        return r.charAt(0);
    }

    private static String simplifyRow(String row) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < row.length() - 1; i++){
            result.append(simplify(row.charAt(i), row.charAt(i+1)));
        }
        return result.toString();
    }

    private static char simplify(char ch1, char ch2) {
        Set<Character> result =  new HashSet<>(Set.of('R', 'G', 'B'));
        if (ch1 == ch2) return ch1;
        result.remove(ch1);
        result.remove(ch2);
        return result.stream().findFirst().orElseThrow();
    }
}
