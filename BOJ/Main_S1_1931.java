package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 회의실 배정(https://www.acmicpc.net/problem/1931)
public class Main_S1_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] ground = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] tmp = (br.readLine()).split(" ");
            int start = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            ground[i][0] = start;
            ground[i][1] = end;
        }
        List<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(new Integer[]{ground[i][0],ground[i][1]});
        }
        list.sort((a, b) -> {
            int compareSecond = Integer.compare(a[1], b[1]); // 두 번째 원소 오름차순 비교
            if (compareSecond != 0) {
                return compareSecond;
            } else {
                return Integer.compare(a[0], b[0]); // 첫 번째 원소 내림차순 비교
            }
        });

        int time = 0;
        int answer = 0;
        for(int i = 0; i < N; i++){
            if(list.get(i)[0] >= time){
                answer++;
                time = list.get(i)[1];
            }
        }
        wr.write(answer+"");
        wr.flush();
    }
}
