package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 문자열 잘라내기(https://www.acmicpc.net/problem/2866)
public class Main_G5_2866 {

    public static String[][] ground;
    public static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        ground = new String[N+1][M];

        for(int i = 0; i < N; i++){
            String[] tmp = (br.readLine()).split("");
            for(int j = 0; j < M; j++){
                ground[i][j] = tmp[j];
            }
        }
        Arrays.fill(ground[N]," ");

        // 받는것 : 최초 중복 지점
        int dupStart = binarySearch(0,N);
        // 최고점수 N-1
        int bestScore = N-1;
        // 중복 갯수 : N - 중복지점
        int dupAmount = N - dupStart;
        // 중복 한줄당 -1점
        int score = bestScore - dupAmount;

        bw.write(score+"");
        bw.flush();
    }

    private static boolean duplication(int mid) {
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0; i < M; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = mid; j < N+1; j++){
                sb.append(ground[j][i]);
            }
            if(hashSet.contains(sb.toString())){
                return true;
            }else{
                hashSet.add(sb.toString());
            }
        }
        return false;
    }

    private static int binarySearch(int left, int right){
        while(left < right){
            int mid = (left+right)/2;
            if(duplication(mid)){ // 중복 발생
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}