package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 접두사(https://www.acmicpc.net/problem/1141)
public class Main_S1_1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        int answer = N;
        String[] array = new String[N];
        for(int i = 0; i < N; i++){
            array[i] = rd.readLine();
        }
        Arrays.sort(array,(a,b) -> Integer.compare(a.length(),b.length()));
        for(int i = 0; i < N; i++) {
            int len = array[i].length();
            for(int j = i+1; j < N; j++){
                if(array[j].substring(0,len).equals(array[i])){
                    answer--;
                    break;
                }
            }
        }
        wr.write(answer+"");
        wr.flush();
    }
}
