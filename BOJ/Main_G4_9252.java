package ProblemSolving.BOJ;

import java.io.*;

// LCS 2(https://www.acmicpc.net/problem/9252)
public class Main_G4_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = rd.readLine();
        String s2 = rd.readLine();
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] dp = new int[s2Len+1][s1Len+1];
        for (int i = 1; i <= s2Len; i++) {
            for (int j = 1; j <= s1Len; j++) {
                if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        wr.write(dp[s2Len][s1Len]+"");
        if(dp[s2Len][s1Len] != 0){
            wr.newLine();
            char[] answerArray = new char[dp[s2Len][s1Len]];
            int index = answerArray.length-1;

            while (s2Len > 0 && s1Len > 0) {
                if (s2.charAt(s2Len - 1) == s1.charAt(s1Len - 1)) {
                    answerArray[index--] = s2.charAt(s2Len - 1);
                    s2Len--;
                    s1Len--;
                } else if (dp[s2Len - 1][s1Len] >= dp[s2Len][s1Len - 1]) {
                    s2Len--;
                } else {
                    s1Len--;
                }
            }
            wr.write(new String(answerArray)+"");
        }
        wr.flush();
        wr.close();
    }
}
