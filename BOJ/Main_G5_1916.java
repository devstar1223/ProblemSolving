package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 최소비용 구하기(https://www.acmicpc.net/problem/1916)
public class Main_G5_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        int M = Integer.parseInt(rd.readLine());
        int INF = Integer.MAX_VALUE;

        // 각 도시 간의 연결 비용을 INF로 초기화 (연결되지 않은 경우)
        int[][] ground = new int[N+1][N+1];

        for(int i = 0; i <= N; i++){
            Arrays.fill(ground[i],INF);
        }

        // 연결 정보 입력
        for(int i = 0; i < M; i++){
            String[] AtoBTime = (rd.readLine()).split(" ");
            int A = Integer.parseInt(AtoBTime[0]);
            int B = Integer.parseInt(AtoBTime[1]);
            int time = Integer.parseInt(AtoBTime[2]);
            ground[A][B] = Math.min(time,ground[A][B]); // 비용 재정의
        }

        // 출발/도착지 설정
        String[] DA = (rd.readLine()).split(" ");
        int departures = Integer.parseInt(DA[0]); // 출발지
        int arrivals = Integer.parseInt(DA[1]); // 도착지

        // 비용 배열 초기화
        int[] costInfo = new int[N+1]; // 비용 배열
        Arrays.fill(costInfo,INF); // 초기 비용 INF 초기화
        costInfo[departures] = 0; // 출발지 기준. 자기 자신은 0

        // 힙선언
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.add(new Node(departures,0)); // 출발 노드 넣기.

        // 갱신 반복
        while(!minHeap.isEmpty()){
            Node thisNode = minHeap.poll(); // 최소 비용 도시 cityNumber 꺼냄
            int cityNumber = thisNode.cityNumber; // 출발지 기준. cityNumber 번호로 가는데
            int cost = thisNode.cost; // 이만큼의 비용이 든다.

            // 근데 이 비용이. 이미 최소 비용 보다 크다면. (이 루트는 비효율이라면)
            if (cost > costInfo[cityNumber]){
                continue;
            }

            // 이 cityNumber 노드를 최소의 방법으로 올 수 있었다면.
            for(int i = 1; i <= N; i++){ // 이 cityNumber와 연결된 노드들을 살펴본다.
                if(ground[cityNumber][i] != INF){ // cityNumber와 연결된 새로운 노드가 있다면.
                    int newCost = cost + ground[cityNumber][i]; // 새로운 노드로 가는 새로운 루트를 만들었다.
                    if (newCost < costInfo[i]) {  // 새로운 루트가, 기존의 루트보다 적게 걸린다면.
                        costInfo[i] = newCost; // 루트(비용)를 갱신한다.
                        minHeap.add(new Node(i, newCost));  // 그 새로운 노드로 가는 새로운 비용 추가.
                    }
                }
            }
        }

        wr.write(costInfo[arrivals]+"");
        wr.flush();
    }

    static class Node implements Comparable<Node>{
        int cityNumber;
        int cost;

        Node(int cityNumber, int cost){
            this.cityNumber = cityNumber;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node otherNode) {
            // cost 값이 작은 순으로 우선순위를 결정
            return Integer.compare(this.cost, otherNode.cost);
        }
    }
}
