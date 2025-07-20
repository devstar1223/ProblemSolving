package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 안녕 (https://www.acmicpc.net/problem/1535)
public class Main_S2_1535 {

    public static int[][] dpTable;
    public static int[] happyArray, painArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        painArray = new int[N];
        String[] painString = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            painArray[i] = Integer.parseInt(painString[i]);
        }

        happyArray = new int[N];
        String[] happyString = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            happyArray[i] = Integer.parseInt(happyString[i]);
        }

        // 체력(0~100)과 기쁨도
        dpTable = new int[101][N];
        for(int i = 0; i < 101; i++){
            Arrays.fill(dpTable[i],-1);
        }

        bw.write(knapsack(100,N-1)+"");
        bw.flush();
    }

    public static int knapsack(int HP, int human){

        if(HP <= 0 || human < 0){ // 이걸 시도할 경우 사망 또는 더이상 사람이 없음
            return 0; // 여기선 얻을게 없음
        }

        if(dpTable[HP][human] != -1){
            return dpTable[HP][human];
        }

        int A = 0;
        if( HP > painArray[human]){ // 사망하지 않았을때 기쁨 + 가능한 값을 더함
            A = happyArray[human] + knapsack(HP - painArray[human],human-1);
        }
        int B = knapsack(HP,human-1);

        dpTable[HP][human] = Math.max(A,B);

        return dpTable[HP][human];
    }
}

