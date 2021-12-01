package jarekjal.codewars.kyu5;

public class ValidParentheses {
    public static boolean validParentheses(String parens)
    {
        int counter = 0;
        for (int i = 0; i < parens.length(); i++){
            char c = parens.charAt(i);
            if (c == '(') counter++;
            if (c == ')') counter--;
            if (counter < 0) return false;
        }
        return counter == 0;
    }
}
