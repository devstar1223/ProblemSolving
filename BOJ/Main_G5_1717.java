package ProblemSolving.BOJ;

import java.io.*;

// 집합의 표현(https://www.acmicpc.net/problem/1717)
public class Main_G5_1717 {

    public static int[] parentInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = (br.readLine()).split(" ");
        int N = Integer.parseInt(NM[0]);
        parentInfo = new int[N+1];
        for(int i = 0; i < N+1; i++){
            parentInfo[i] = i;
        }
        int M = Integer.parseInt(NM[1]);
        for(int i = 0; i < M; i++){
            String[] linkAB = (br.readLine()).split(" ");
            int link = Integer.parseInt(linkAB[0]);
            int A = Integer.parseInt(linkAB[1]);
            int B = Integer.parseInt(linkAB[2]);
            if(link == 0){
                union(A,B);
            }else{
                if(isSameRoot(A,B)){
                    bw.write("YES\n");
                }else{
                    bw.write("NO\n");
                }
            }
        }
        bw.flush();
    }

    private static void union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 != root2){
            if(root1 < root2){
                parentInfo[root2] = root1;
            }else{
                parentInfo[root1] = root2;
            }
        }
    }
    private static int find(int node){
        if(node == parentInfo[node]){
            return node;
        }

        return parentInfo[node] = find(parentInfo[node]);
    }

    private static boolean isSameRoot(int node1, int node2){
        return find(node1) == find(node2);
    }
}

