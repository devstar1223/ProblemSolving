package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 점수 따먹기(https://www.acmicpc.net/problem/1749)
public class Main_G4_1749 {

    public static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (rd.readLine()).split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = (rd.readLine()).split(" ");
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(row[j]);
            }
        }

        int maxAnswer = Integer.MIN_VALUE;
        //열 범위를 (0,0) 부터 (M-1,M-1) 까지 늘린다.
        for(int i = 0; i < M; i++){
            for(int j = i; j < M; j++){
                List<Integer> sumList = rowSum(i,j);
                //이 리스트에 대해 카데인 알고리즘을 써서 최대값을 담는다.
                maxAnswer = Math.max(maxAnswer,kadane(sumList));
            }
        }

        wr.write(maxAnswer+"");
        wr.flush();
    }

    public static List<Integer> rowSum(int startIndex, int endIndex){
        List<Integer> sumList = new ArrayList<>();
        for(int i = 0; i < ground.length; i++){
            int sum = 0;
            for(int j = startIndex; j <= endIndex; j++){
                sum += ground[i][j];
            }
            sumList.add(sum);
        }
        return sumList;
    }

    public static int kadane(List<Integer> sumList){
        int currentSum = sumList.get(0);
        int maxSum = sumList.get(0);
        for(int i = 1; i < sumList.size(); i++){
            currentSum = Math.max(sumList.get(i),currentSum+sumList.get(i));
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}