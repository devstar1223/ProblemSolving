package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 트리의 부모 찾기(https://www.acmicpc.net/problem/11725)
public class Main_S2_11725 {

    static List<List<Integer>> linkInfoList = new ArrayList<>();
    static int[] answer;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        answer = new int[N+1];
        visit = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            linkInfoList.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++){
            String[] UV = (br.readLine()).split(" ");
            int U = Integer.parseInt(UV[0]);
            int V = Integer.parseInt(UV[1]);
            linkInfoList.get(U).add(V);
            linkInfoList.get(V).add(U);
        }

        dfs(1);

        for(int i = 2; i < N+1; i++){
            if(i != N){
                bw.write(answer[i]+"\n");
            }else{
                bw.write(answer[i]+"");
            }
        }
        bw.flush();
    }

    private static int dfs(int node){
        visit[node] = true;
        List<Integer> linkInfo = linkInfoList.get(node);

        for(int child : linkInfo){
            if(!visit[child]){
                answer[dfs(child)] = node;
            }
        }

        return node;
    }
}