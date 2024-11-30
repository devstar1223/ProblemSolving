package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 도전 숫자왕(https://www.acmicpc.net/problem/23057)
public class Main_S2_23057 {

    public static Set<Integer> set;
    public static int[] numArray;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        N = Integer.parseInt(rd.readLine());
        String[] numberArrayTmp = (rd.readLine()).split(" ");
        numArray = new int[N];
        int limit = 0; // 이하의 만들수 없는 자연수
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(numberArrayTmp[i]);
            limit += num;
            numArray[i] = num;
        }
        // solve
        set = new HashSet<>();
        boolean[] visit = new boolean[N];
        dfs(limit,visit);

        // out
        int answer = limit - set.size();
        wr.write(answer+"");
        wr.flush();
    }

    public static void dfs(int sumNum,boolean[] visit){
        for(int i = 0; i < N; i++){
            if(!visit[i] && !set.contains(sumNum-numArray[i])){
                visit[i] = true;
                set.add(sumNum-numArray[i]);
                dfs(sumNum-numArray[i],visit);
                visit[i] = false;
            }
        }
    }

}