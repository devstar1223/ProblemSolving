package ProblemSolving.SWEA;

import java.io.*;

//1946.간단한 압축 풀기
public class Solution_D2_1946 {
    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(rd.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(rd.readLine());
            wr.write("#"+testCase+"\n");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++){
                String[] s = (rd.readLine()).split(" ");
                String alphabet = s[0];
                int repeat = Integer.parseInt(s[1]);
                for(int j = 0; j < repeat; j++){
                    sb.append(alphabet);
                }
            }
            String answer = sb.toString();
            for(int i = 0; i < answer.length(); i += 10){
                wr.write(answer.substring(i,Math.min(i+10,answer.length())));
                if(i+10 < answer.length()){
                    wr.newLine();
                }
            }
            if(testCase != T){
                wr.newLine();
            }
            wr.flush();
        }
    }
}