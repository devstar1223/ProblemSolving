package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 행복 유치원 (https://www.acmicpc.net/problem/13164)
public class Main_G5_13164_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //init
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        String[] line = br.readLine().split(" ");
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(line[i]);
        }

        //solve
        int[] diffArray = new int[N-1];
        for(int i = 0; i < N-1; i++){
            diffArray[i] = array[i+1]-array[i];
        }

        Arrays.sort(diffArray);

        int answer = 0;
        for(int i = 0; i < N-K; i++){
            answer += diffArray[i];
        }

        //out

        bw.write(answer+"");
        bw.flush();
    }
}

