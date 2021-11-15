package jarejal.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Runes {
    //(number)[operator](number)=(number)
    //Unknown digit will not be the same as any other digits used in expression

    private enum Operation {
        PLUS("\\+"), MINUS("-"), MULTIPLY("\\*");
        private final String operator;

        Operation(String operator) {
            this.operator = operator;
        }
    }

    private static Operation operation;
    private static String result;
    private static String[] arguments;
    private static List<String> digits;

    public static int solveExpression(final String expression) {
        if (expression.isEmpty()) return -1;
        parse(expression);
        digits = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Set<String> digitsExistingInExpresion = digits.stream()
                .filter(d -> existInOperands(d, List.of(arguments[0], arguments[1], result)))
                .collect(Collectors.toSet());
        digits.removeAll(digitsExistingInExpresion);
        if (isPossibleLeadingZeroOrMinusZero(List.of(arguments[0], arguments[1], result))) {
            digits.remove("0");
        }
        int answer = -1;
        for (String digit : digits) {
            String arg0 = arguments[0].replaceAll("\\?", digit);
            String arg1 = arguments[1].replaceAll("\\?", digit);
            String res = result.replaceAll("\\?", digit);
            long outcome = calculate(Long.parseLong(arg0), Long.parseLong(arg1));
            if (outcome == Long.parseLong(res)) {
                answer = Integer.parseInt(digit);
                break;
            }
        }
        return answer;
    }

    private static boolean existInOperands(String d, List<String> arguments) {
        return arguments.stream().anyMatch(arg -> arg.contains(d));
    }

    private static long calculate(long arg1, long arg2) {
        long outcome = 0;
        switch (operation) {
            case PLUS:
                outcome = arg1 + arg2;
                break;
            case MINUS:
                outcome = arg1 - arg2;
                break;
            case MULTIPLY:
                outcome = arg1 * arg2;
        }
        return outcome;
    }

    private static boolean isPossibleLeadingZeroOrMinusZero(List<String> operands) {
        return operands.stream().anyMatch(o -> (o.startsWith("?") && o.length() > 1) || o.startsWith("-?"));
    }

    private static void parse(String expression) {
        expression = expression.replace("--", "+");
        String[] expressionAndResult = expression.split("=");
        result = expressionAndResult[1];
        if (expressionAndResult[0].contains("*")) {
            operation = Operation.MULTIPLY;
        } else if (expressionAndResult[0].contains("+")) {
            operation = Operation.PLUS;
        } else {
            operation = Operation.MINUS;
            if (expressionAndResult[0].startsWith("-")) {
                expressionAndResult[0] = expressionAndResult[0].replaceFirst("-", "!");
            }
        }
        arguments = expressionAndResult[0].split(operation.operator);
        arguments[0] = arguments[0].replace("!", "-");
    }

}
