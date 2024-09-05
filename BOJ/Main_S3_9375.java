package ProblemSolving.BOJ;

import java.util.*;

// 패션왕 신해빈(https://www.acmicpc.net/problem/9375)
public class Main_S3_9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            Map<String, Integer> map = new HashMap<>();
            int N = sc.nextInt();
            sc.nextLine();
            for(int j = 0; j < N; j++){
                String[] tmp = (sc.nextLine()).split(" ");
                map.put(tmp[1],map.getOrDefault(tmp[1],1)+1);
            }
            int answer = 1;
            for(int v : map.values()){
                answer *= v;
            }
            System.out.println(answer-1);
        }
    }
}