package jarekjal.codewars;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;
        int x = 0;
        int y = 0;
        for (char ch : walk){
            if (ch == 'n') y++;
            if (ch == 's') y--;
            if (ch == 'e') x++;
            if (ch == 'w') x--;
        }
        return x == 0 && y == 0;
    }
}
