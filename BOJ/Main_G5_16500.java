package ProblemSolving.BOJ;

import java.io.*;

public class Main_G5_16500 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = rd.readLine();
        int N = Integer.parseInt(rd.readLine());
        String[] wordArray = new String[N];
        for (int i = 0; i < N; i++) {
            wordArray[i] = rd.readLine();
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0; i < dp.length-1; i++){
            if(dp[i]){
                for(int j = 0; j < N; j++){
                    String word = wordArray[j];
                    String newString = s.substring(i,Math.min(s.length(),i+word.length()));
                    if(newString.equals(word)){
                        dp[i+word.length()] = true;
                    }
                }
            }
        }

        if(dp[s.length()]){
            wr.write("1");
        }else{
            wr.write("0");
        }
        wr.flush();
    }
}
