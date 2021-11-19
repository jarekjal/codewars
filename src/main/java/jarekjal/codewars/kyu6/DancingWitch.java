package jarekjal.codewars.kyu6;

public class DancingWitch {

    public static String figureOut(String[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            String before = arr[i];
            String after = arr[i+1];
            for (int pos = 0; pos < before.length(); pos++){
                char ch = before.charAt(pos);
                if (ch == ' ') continue;
                if (!isNormalDancer(pos, ch, after)) return "" + ch;
            }
        }
        return null;
    }

    private static boolean isNormalDancer(int pos, char ch, String after){
        int left = pos - 1;
        int right = pos + 1;
        if (left >= 0 && after.charAt(left) == ch) return true;
        if (after.charAt(pos) == ch) return true;
        return right < after.length() && after.charAt(right) == ch;
    }

}
