package jarejal.codewars;

import java.util.Arrays;

public class RailFenceCipher {
    private static StringBuilder[] encoderRails;
    private static String[] decoderRails;

    static String encode(String s, int n) {
        initiateRails(n);
        int cnt = 0;
        int period = (2 * n) - 2;
        while (cnt < s.length()) {
            int index = calculateIndex(cnt, n, period);
            encoderRails[index] = encoderRails[index].append(s.charAt(cnt));
            cnt++;
        }
        return getResult().toString();
    }

    private static int calculateIndex(int cnt, int n, int period){
        int numInPeriod = cnt % period;
        return numInPeriod < n ? numInPeriod : period - numInPeriod;
    }

    private static void initiateRails(int n) {
        encoderRails = new StringBuilder[n];
        for (int i = 0; i < encoderRails.length; i++) {
            encoderRails[i] = new StringBuilder();
        }
    }

    private static StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : encoderRails) {
            result.append(sb);
        }
        return result;
    }

    static String decode(String s, int n) {
            decoderRails = new String[n];
            Arrays.fill(decoderRails, "");
            initiateRails(n);
            int cnt = 0;
            int period = (2 * n) - 2;
            while (cnt < s.length()) {
               int index = calculateIndex(cnt, n, period);
               encoderRails[index] = encoderRails[index].append(s.charAt(cnt));
               cnt++;
            }
            int[] railLenghts = new int[encoderRails.length];
            for (int j = 0; j < encoderRails.length; j++){
                railLenghts[j] = encoderRails[j].length();
            }
            int i;
            int start = 0;
            int stop = railLenghts[0];
            for (i = 0; i < n - 1; i++) {
                decoderRails[i] = s.substring(start, stop);
                start = stop;
                stop += railLenghts[i+1];
            }
            decoderRails[i] = s.substring(start);
            return buildResult(s, n, period).toString();
    }

    private static StringBuilder buildResult(String s, int n, int period) {
        int[] counters = new int[n];
        int cnt = 0;
        StringBuilder result = new StringBuilder();
        while(cnt < s.length()){
            int index = calculateIndex(cnt, n, period);
            result.append(decoderRails[index].charAt(counters[index]));
            counters[index]++;
            cnt++;
        }
        return result;
    }
}
