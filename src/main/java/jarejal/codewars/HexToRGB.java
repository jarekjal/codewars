package jarejal.codewars;

import java.util.Locale;

public class HexToRGB {
    final static int RADIX = 16;
    public static int[] hexStringToRGB(String hex) {
        hex = hex.toLowerCase(Locale.ROOT);
        int r = Integer.parseUnsignedInt(hex.substring(1,3), RADIX);
        int g = Integer.parseUnsignedInt(hex.substring(3,5), RADIX);
        int b = Integer.parseUnsignedInt(hex.substring(5,7), RADIX);
        return new int[]{r, g, b};
    }
}
