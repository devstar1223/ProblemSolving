package ProblemSolving.BOJ;

import java.io.*;

// 연속합(https://www.acmicpc.net/problem/1912)
public class Main_S2_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        String[] numberStringArray = (rd.readLine()).split(" ");

        int totalSum = Integer.parseInt(numberStringArray[0]);
        int max = totalSum;

        for (int i = 1; i < numberStringArray.length; i++) {
            int number = Integer.parseInt(numberStringArray[i]);
            if (totalSum < 0) {
                if (number > totalSum) {
                    totalSum = number;
                }
            } else {
                totalSum += number;
            }
            max = Math.max(max, totalSum);
        }

        wr.write(max+"");
        wr.flush();
    }

}