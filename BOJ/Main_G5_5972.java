package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//택배 배송(https://www.acmicpc.net/problem/5972)
public class Main_G5_5972 {

    static List<Map<Integer,Integer>> linkInfoList = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        for(int i = 0; i < N+1; i++){
            linkInfoList.add(new HashMap<>());
        }

        for(int i = 0; i < M; i++){
            String[] ABC = (br.readLine()).split(" ");
            int nodeA = Integer.parseInt(ABC[0]);
            int nodeB = Integer.parseInt(ABC[1]);
            int cost = Integer.parseInt(ABC[2]);
            Integer originCost = linkInfoList.get(nodeA).get(nodeB);
            if(originCost == null || originCost > cost){
                linkInfoList.get(nodeA).put(nodeB,cost);
                linkInfoList.get(nodeB).put(nodeA,cost);
            }
        }

        bw.write(dijkstra(1,N)+"");
        bw.flush();
    }

    private static int dijkstra(int start, int end){
        int[] distanceInfo = new int[N+1];
        Arrays.fill(distanceInfo,INF);
        distanceInfo[start] = 0;

        PriorityQueue<Node> heap = new PriorityQueue<>();

        heap.add(new Node(start,0));

        while(!heap.isEmpty()){
            Node pollNode = heap.poll();
            int number = pollNode.nodeNumber;
            int distance = pollNode.distance;

            if(distance > distanceInfo[number]){
                continue;
            }

            for(int i : linkInfoList.get(number).keySet()){
                Integer linkNodeCost = linkInfoList.get(number).get(i);
                int newRoute = distance + linkNodeCost;
                if(newRoute < distanceInfo[i]){
                    distanceInfo[i] = newRoute;
                    heap.add(new Node(i,distanceInfo[i]));
                }
            }
        }

        return distanceInfo[end];
    }

    static class Node implements Comparable<Node>{
        public int nodeNumber;
        public int distance;

        public Node(int nodeNumber, int distance){
            this.nodeNumber = nodeNumber;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o){
            if(this.distance < o.distance){
                return -1;
            }
            else if(this.distance > o.distance){
                return 1;
            }
            return 0;
        }

    }
}