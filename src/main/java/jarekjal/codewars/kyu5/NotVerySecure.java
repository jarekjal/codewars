package jarekjal.codewars.kyu5;

import java.util.regex.Pattern;

public class NotVerySecure {

    public static boolean alphanumeric(String s){
        return s.isEmpty() ? false : Pattern.matches("[a-zA-Z0-9]+", s);
    }
}
