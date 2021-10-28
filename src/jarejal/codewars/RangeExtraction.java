package jarejal.codewars;

public class RangeExtraction {
    public static String rangeExtraction(int[] arr) {

        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < arr.length){
            int startIndex = index;
            int stopIndex = index;
            while(index < arr.length -1 && arr[index] + 1 == arr[index+1]){
                index++;
                stopIndex = index;
            }
            if(startIndex == stopIndex) {
                result.append(arr[startIndex]).append(",");
            } else if (startIndex + 1 == stopIndex){
                result.append(arr[startIndex]).append(",");
                result.append(arr[stopIndex]).append(",");
            } else {
                result.append(arr[startIndex]).append("-").append(arr[stopIndex]).append(",");
            }
            index++;
        }
        String answer = result.toString();
        return answer.substring(0, answer.length()-1);
    }
}
