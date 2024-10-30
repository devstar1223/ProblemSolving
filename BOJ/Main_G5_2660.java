package ProblemSolving.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 회장뽑기(https://www.acmicpc.net/problem/2660)
public class Main_G5_2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(rd.readLine());
        int[][] ground = new int[N+1][N+1]; // 1번 회원이 1번 칸에 있도록 설정
        while(true){
            String[] stringArray = (rd.readLine()).split(" ");
            if(stringArray[0].equals("-1") && stringArray[1].equals("-1")){
                break;
            }
            int member1 = Integer.parseInt(stringArray[0]);
            int member2 = Integer.parseInt(stringArray[1]);
            ground[member1][member2] = 1;
            ground[member2][member1] = 1;
        }

        // solve
//        for(int k = 0; k < N+1; k++){
//            for(int i = 1; i < N+1; i++){
//                for(int j = 1; j < N+1; j++){
//                    if(ground[i][k] != 0 && ground[k][j] != 0 && ground[i][j] == 0){
//                        ground[i][j] = Math.min(k+2,ground[i][k]+ground[k][j]);
//                    }
//                }
//            }
//        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (ground[i][k] != 0 && ground[k][j] != 0) {
                        if (ground[i][j] == 0) {
                            ground[i][j] = ground[i][k] + ground[k][j];
                        } else {
                            ground[i][j] = Math.min(ground[i][j], ground[i][k] + ground[k][j]);
                        }
                    }
                }
            }
        }

        // out

        for(int i = 1; i < N+1; i++){
            ground[i][i] = 0;
        }

        int[] answer = new int[N+1];
        for(int i = 1; i < N+1; i++){
            int max = -1;
            for(int j = 1; j < N+1; j++){
                max = Math.max(max,ground[i][j]);
            }
            answer[i] = max;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < answer.length; i++){
            min = Math.min(min,answer[i]);
        }

        List<Integer> answerList = new ArrayList<>();

        for(int i = 1; i < answer.length; i++){
            if(answer[i] == min){
                answerList.add(i);
            }
        }

        wr.write(min + " " + answerList.size());
        wr.newLine();
        wr.flush();
        for(int i = 0; i < answerList.size(); i++) {
            if(i == answerList.size() - 1){
                wr.write(answerList.get(i) + "");
            }
            else{
                wr.write(answerList.get(i) + " ");
            }
        }
        wr.flush();
    }
}