package jarekjal.codewars.kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreatePhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        List<String> number = Arrays.stream(numbers).mapToObj(i -> "" + i).collect(Collectors.toList());
        number.add(0, "(");
        number.add(4, ") ");
        number.add(8,"-");
        return number.stream().reduce("", String::concat);
    }
}
