package ProblemSolving.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 리모컨(https://www.acmicpc.net/problem/1107)
public class Main_G5_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int targetNumber = Integer.parseInt(rd.readLine());
        int M = Integer.parseInt(rd.readLine());

        List<String> breakButtonList = new ArrayList<>();
        if (M > 0) {
            String[] breakButtonStringArray = (rd.readLine()).split(" ");
            breakButtonList.addAll(Arrays.asList(breakButtonStringArray));
        }

        int min = Math.abs(targetNumber - 100);

        for (int i = 0; i <= 1000000; i++) {
            String numberString = String.valueOf(i);
            boolean isBroken = false;

            for (String breakButton : breakButtonList) {
                if (numberString.contains(breakButton)) {
                    isBroken = true;
                    break;
                }
            }

            if (!isBroken) {
                int pressCount = numberString.length() + Math.abs(targetNumber - i);
                min = Math.min(min, pressCount);
            }
        }

        wr.write(min + "");
        wr.flush();
    }
}
