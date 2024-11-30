package ProblemSolving.BOJ;

import java.io.*;

// LCS (https://www.acmicpc.net/problem/9251)
public class Main_G5_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String A = rd.readLine();
        String B = rd.readLine();

        int aLen = A.length();
        int bLen = B.length();
        int[][] DP = new int[aLen+1][bLen+1];
        String[] aArray = new String[aLen + 1];
        for (int i = 1; i < aArray.length; i++) {
            aArray[i] = String.valueOf(A.charAt(i - 1));
        }
        String[] bArray = new String[bLen + 1];
        for (int i = 1; i < bArray.length; i++) {
            bArray[i] = String.valueOf(B.charAt(i - 1));
        }

        for (int i = 1; i < aLen+1; i++) {
            for (int j = 1; j < bLen+1; j++) {
                if (aArray[i].equals(bArray[j])) {
                    DP[i][j] = 1 + DP[i - 1][j - 1];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }

        wr.write(DP[aLen][bLen]+"");
        wr.flush();
    }
}