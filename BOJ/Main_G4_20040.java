package ProblemSolving.BOJ;

import java.io.*;

// 사이클 게임(https://www.acmicpc.net/problem/20040)
public class Main_G4_20040 {

    public static int[] parentInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        int N = Integer.parseInt(NM[0]); // 0 ~ N-1
        int M = Integer.parseInt(NM[1]);
        parentInfo = new int[N];
        for(int i = 0; i < N; i++){
            parentInfo[i] = i;
        }
        int answer = 0;
        for(int i = 0; i < M; i++){
            String[] twoNode = (br.readLine()).split(" ");
            if(answer != 0){
                continue;
            }

            int node1 = Integer.parseInt(twoNode[0]);
            int node2 = Integer.parseInt(twoNode[1]);

            if(union(node1,node2)){
                answer = i+1;
            }
        }
        bw.write(answer+"");
        bw.flush();
    }

    private static boolean union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);

        if(node1 < node2){
            parentInfo[node2] = node1;
            return false;
        }
        if(node1 > node2){
            parentInfo[node1] = node2;
            return false;
        }

        return true;
    }

    private static int find(int node) {
        if(node == parentInfo[node]){
            return node;
        }
        return parentInfo[node] = find(parentInfo[node]);
    }

}