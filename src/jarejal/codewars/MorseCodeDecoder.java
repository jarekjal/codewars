package jarejal.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {

    public static String decode(String morseCode) {
        if (morseCode == null || morseCode.trim().isEmpty()) return morseCode;
        String[] words = morseCode.trim().split("   ");
        String result = Arrays.stream(words).map(MorseCodeDecoder::decodeWord).reduce("", (s1, s2) -> s1 + " " + s2);
        return result.trim();
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" ")).map(MorseCode::get).reduce("", String::concat);
    }

    // klasa tylko na potrzeby testow - pelna tablica kodow dostepna (MorseCode::get) w srodowisku codewars (preload)
    private static class MorseCode{
        private static Map<String, String> morseCodeToAsci = new HashMap<>();
        static {
            morseCodeToAsci.put("....", "H");
            morseCodeToAsci.put(".", "E");
            morseCodeToAsci.put("-.--", "Y");
            morseCodeToAsci.put(".---", "J");
            morseCodeToAsci.put("..-", "U");
            morseCodeToAsci.put("-..", "D");
        }
        public static String get(String morseCode){
            return morseCodeToAsci.get(morseCode);
        }
    }

}
