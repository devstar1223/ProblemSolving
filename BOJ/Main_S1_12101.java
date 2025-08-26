package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 1, 2, 3 더하기 2 (https://www.acmicpc.net/problem/12101)
public class Main_S1_12101 {

    public static int K, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] NK = (br.readLine()).split(" ");
        int N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        // solve
        List<Integer> answerList = new ArrayList<>();
        dfs(N,answerList);

        // out
        bw.write("-1");
        bw.flush();
    }

    private static void dfs(int N, List<Integer> answerList){
        if(N == 0){
            count++;
            if(count == K){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < answerList.size(); i++){
                    sb.append(answerList.get(i));
                    if(i != answerList.size()-1){
                        sb.append("+");
                    }
                }
                System.out.print(sb.toString());
                System.exit(0);
            }
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(N-i >= 0){
                answerList.add(i);
                dfs(N-i,answerList);
                answerList.remove(answerList.size()-1);
            }
        }
    }
}

