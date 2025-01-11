package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 사회망 서비스(SNS)(https://www.acmicpc.net/problem/2533)
public class Main_G3_2533 {

    static List<List<Integer>> linkInfoList;
    static int[][] dpTable;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        linkInfoList = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            linkInfoList.add(new ArrayList<>());
        }
        dpTable = new int[N+1][2];
        visited = new boolean[N+1];

        for(int i = 0; i < N-1; i++){
            String[] UV = (br.readLine()).split(" ");
            int U = Integer.parseInt(UV[0]);
            int V = Integer.parseInt(UV[1]);
            linkInfoList.get(U).add(V);
            linkInfoList.get(V).add(U);
        }

        dfs(1,-1);
        bw.write(Math.min(dpTable[1][0],dpTable[1][1])+"");
        bw.flush();
    }

    private static void dfs(int node, int parent){
        visited[node] = true;
        List<Integer> linkInfo = linkInfoList.get(node);

        dpTable[node][0] = 0;
        dpTable[node][1] = 1;

        for(int child : linkInfo){
            if(child == parent){
                continue;
            }
            if(!visited[child]){
                dfs(child,node);
            }
            dpTable[node][0] += dpTable[child][1];
            dpTable[node][1] += Math.min(dpTable[child][0],dpTable[child][1]);
        }
    }
}