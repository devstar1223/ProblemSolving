package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 최단경로(https://www.acmicpc.net/problem/1753)
public class Main_G4_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int INF = Integer.MAX_VALUE;

        String[] VE = (rd.readLine()).split(" ");
        int V = Integer.parseInt(VE[0]); // 노드의 수
        int E = Integer.parseInt(VE[1]); // 간선의 수

        int departures = Integer.parseInt(rd.readLine()); // 출발지

        List<List<LinkInfo>> ground = new ArrayList<>();
        for(int i = 0; i <= V; i++){
            ground.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) { // 간선 정보 초기화
            String[] UVW = (rd.readLine()).split(" ");
            int uInfo = Integer.parseInt(UVW[0]);
            int vInfo = Integer.parseInt(UVW[1]);
            int wInfo = Integer.parseInt(UVW[2]);
            ground.get(uInfo).add(new LinkInfo(vInfo,wInfo));
        }

        int[] costInfo = new int[V+1]; // 최소 비용 배열 선언
        Arrays.fill(costInfo, INF); // 초기화

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(departures,0));

        //다익스트라
        while(!minHeap.isEmpty()){
            Node pollNode = minHeap.poll();
            int number = pollNode.number;
            int cost = pollNode.cost;

            if(cost > costInfo[number]){
                continue;
            }
            costInfo[number] = cost;

            if(ground.get(number).isEmpty()){ // 이 노드와 연결된 노드가 없다.
                continue;
            }

            for(LinkInfo linkInfo : ground.get(number)){
                int thisNodeLinkAnotherNode = linkInfo.arrivals;
                int thisNodeLinkAnotherNodeCost = linkInfo.cost;
                int newCost = cost + thisNodeLinkAnotherNodeCost;
                if(newCost < costInfo[thisNodeLinkAnotherNode]){
                    minHeap.add(new Node(thisNodeLinkAnotherNode,newCost));
                    costInfo[thisNodeLinkAnotherNode] = newCost;
                }
            }
        }

        costInfo[departures] = 0;

        // 출력
        for(int i = 1; i <= V; i++){
            if(costInfo[i] == INF){
                wr.write("INF");
            }else{
                wr.write(costInfo[i]+"");
            }

            if(i != V){
                wr.newLine();
            }
        }
        wr.flush();
    }

    static class Node implements Comparable<Node>{
        int number;
        int cost;

        public Node(int number, int cost){
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node otherNode){
            return Integer.compare(this.cost, otherNode.cost);
        }

    }

    static class LinkInfo{
        int arrivals;
        int cost;

        public LinkInfo(int arrivals, int cost){
            this.arrivals = arrivals;
            this.cost = cost;
        }
    }
}
