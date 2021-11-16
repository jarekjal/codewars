package jarekjal.codewars;

public class Diamond {
    public static String print(int n) {
        if(n % 2 == 0 || n < 0) return null;
        StringBuilder result = new StringBuilder();
        int increment = 2;
        for (int lineNum = 1; lineNum <= n && lineNum > 0; lineNum += increment){
            final int headSpacesCount = (n - lineNum) / 2;
            String line = " ".repeat(headSpacesCount) + "*".repeat(lineNum) + "\n";
            result.append(line);
            if(lineNum == n) {
                increment = -2;
            }
        }
        //System.out.println(result);
        return result.toString();
    }
}
