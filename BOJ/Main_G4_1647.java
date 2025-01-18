package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 도시 분할 계획(https://www.acmicpc.net/problem/1647)
public class Main_G4_1647 {

    static int V;
    static int[] parentInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] VE = (br.readLine()).split(" ");
        V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        int[][] nodeInfo = new int[E][3];
        for(int i = 0; i < E; i++){
            String[] N1N2C = (br.readLine()).split(" ");
            nodeInfo[i][0] = Integer.parseInt(N1N2C[0]);
            nodeInfo[i][1] = Integer.parseInt(N1N2C[1]);
            nodeInfo[i][2] = Integer.parseInt(N1N2C[2]);
        }

        bw.write(Kruskal(nodeInfo)+"");
        bw.flush();
    }

    private static int Kruskal(int[][] nodeInfo) {
        int result = 0;
        int max = -1;

        parentInfo = new int[V+1];

        for(int i = 0; i < V+1; i++){
            parentInfo[i] = i;
        }

        Arrays.sort(nodeInfo,(a,b) -> Integer.compare(a[2],b[2]));

        for(int i = 0; i < nodeInfo.length; i++){

            int node1 = nodeInfo[i][0];
            int node2 = nodeInfo[i][1];

            if(find(node1) == find(node2)){
                continue;
            }

            union(node1,node2);
            result += nodeInfo[i][2];
            max = Math.max(max,nodeInfo[i][2]);
        }
        return result-max;
    }

    private static void union(int node1,int node2){
        node1 = find(node1);
        node2 = find(node2);

        parentInfo[Math.max(node1,node2)] = Math.min(node1,node2);
    }

    private static int find(int node){
        if(parentInfo[node] == node){
            return node;
        }
        return parentInfo[node] = find(parentInfo[node]);
    }
}