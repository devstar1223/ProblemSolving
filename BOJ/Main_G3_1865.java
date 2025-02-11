package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 웜홀(https://www.acmicpc.net/problem/1865)
public class Main_G3_1865 {

    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testLimit = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < testLimit; tc++){
            String[] NMW = (br.readLine()).split(" ");
            int N = Integer.parseInt(NMW[0]);
            int M = Integer.parseInt(NMW[1]);
            int W = Integer.parseInt(NMW[2]);
            List<Edge> edgeList = new ArrayList<>();
            for(int i = 0; i < M; i++){
                String[] SET = (br.readLine()).split(" ");
                int S = Integer.parseInt(SET[0]);
                int E = Integer.parseInt(SET[1]);
                int T = Integer.parseInt(SET[2]);
                edgeList.add(new Edge(S,E,T));
                edgeList.add(new Edge(E,S,T));
            }
            for(int i = 0; i < W; i++){
                String[] SET = (br.readLine()).split(" ");
                int S = Integer.parseInt(SET[0]);
                int E = Integer.parseInt(SET[1]);
                int T = Integer.parseInt(SET[2]);
                edgeList.add(new Edge(S,E,-T));
            }

            if(BellmanFord(0,edgeList,N)){
                bw.write("YES");
            }else{
                bw.write("NO");
            }

            if(tc != testLimit-1){
                bw.newLine();
            }
        }

        bw.flush();
    }

    public static class Edge{
        int start;
        int end;
        int weight;
        public Edge(int S, int E, int T){
            this.start = S;
            this.end = E;
            this.weight = T;
        }
    }

    public static boolean BellmanFord(int startNode,List<Edge> edgeList, int N){
        int[] dist = new int[N+1];
        Arrays.fill(dist,0);

        for(int i = 0; i < N-1; i++){
            for(Edge edge : edgeList){
                if(dist[edge.start] != INF && (dist[edge.start] + edge.weight) < dist[edge.end]){
                    dist[edge.end] = dist[edge.start] + edge.weight;
                }
            }
        }

        for(Edge edge : edgeList){ // 음의 사이클이 있는지 판별한다.
            if(dist[edge.start] != INF && (dist[edge.start] + edge.weight) < dist[edge.end]){
                return true;
            }
        }

        return false;
    }
}