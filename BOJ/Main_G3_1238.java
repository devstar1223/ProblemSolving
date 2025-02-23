package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//파티(https://www.acmicpc.net/problem/1238)
public class Main_G3_1238 {

    static int N,M,X;
    static int INF = Integer.MAX_VALUE;
    static int[][] ground;
    static int[] xToAnotherTown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NMX = (br.readLine()).split(" ");
        N = Integer.parseInt(NMX[0]);
        M = Integer.parseInt(NMX[1]);
        X = Integer.parseInt(NMX[2]);

        ground = new int[N+1][N+1];
        for(int[] array : ground){
            Arrays.fill(array,INF);
        }

        for(int i = 0; i < M; i++){
            String[] startEndTime = (br.readLine()).split(" ");
            int start = Integer.parseInt(startEndTime[0]);
            int end = Integer.parseInt(startEndTime[1]);
            int time = Integer.parseInt(startEndTime[2]);
            ground[start][end] = time;
        }

        int[] anotherToXTown = new int[N+1];

        //다익스트라 메서드로, 각각의 점에서 X로 가는 시간 알아오기
        for(int i = 1; i < N+1; i++){
            anotherToXTown[i] = dijkstra(i);
        }
        int answer = -1;
        for(int i = 1; i < N+1; i++){
            answer = Math.max(answer,anotherToXTown[i]+xToAnotherTown[i]);
        }

        bw.write(answer+"");
        bw.flush();
    }

    private static class Node implements Comparable<Node>{
        public int number;
        public int distance;

        public Node(int number, int distance){
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o){
            if(this.distance < o.distance){
                return -1;
            }
            if(this.distance > o.distance){
                return 1;
            }
            return 0;
        }
    }

    private static int dijkstra(int startNodeNumber){
        int[] distanceInfo = new int[N+1];
        Arrays.fill(distanceInfo,INF);
        distanceInfo[startNodeNumber] = 0;

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(startNodeNumber,0));

        while(!heap.isEmpty()){
            Node currentNode = heap.poll();
            int currentNumber = currentNode.number;
            int currentDistance = currentNode.distance;

            if(distanceInfo[currentNumber] < currentDistance){
                continue;
            }

            for(int i = 0; i < N+1; i++){
                if(ground[currentNumber][i] != INF){
                    int newRoute = ground[currentNumber][i]+currentDistance;
                    if(newRoute < distanceInfo[i]){
                        distanceInfo[i] = newRoute;
                        heap.add(new Node(i,newRoute));
                    }
                }
            }
        }

        if(startNodeNumber == X){
            xToAnotherTown = new int[N+1];
            for(int i = 0; i < N+1; i++){
                xToAnotherTown[i] = distanceInfo[i];
            }
        }

        return distanceInfo[X];
    }
}