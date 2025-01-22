package ProblemSolving.BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

// 서강그라운드(https://www.acmicpc.net/problem/14938) - 다익스트라
public class Main_G4_14938_2 {

    static int[] itemInfo;
    static int[][] ground;
    static int N,M,R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NMR = (br.readLine()).split(" ");
        N = Integer.parseInt(NMR[0]); // 지역갯수
        M = Integer.parseInt(NMR[1]); // 수색범위
        R = Integer.parseInt(NMR[2]); // 길의개수
        String[] itemInfoString = (br.readLine()).split(" ");
        itemInfo = new int[N+1];
        ground = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            itemInfo[i] = Integer.parseInt(itemInfoString[i-1]);
        }

        for(int[] array : ground){
            Arrays.fill(array,-1);
        }

        for(int i = 0; i < R; i++){
            String[] ABL = (br.readLine()).split(" ");
            int A = Integer.parseInt(ABL[0]);
            int B = Integer.parseInt(ABL[1]);
            int L = Integer.parseInt(ABL[2]); // 거리
            ground[A][B] = L;
            ground[B][A] = L;
        }
        
        int answer = -1;
        for(int i = 1; i < N+1; i++){
            answer = Math.max(answer,dijkstra(i));
        }
        bw.write(answer+"");
        bw.flush();
    }
    
    static class Area implements Comparable<Area>{

        int areaNumber;
        int roadLength;
        
        @Override
        public int compareTo(Area o) {
            return Integer.compare(this.roadLength,o.roadLength);
        }

        public Area(int areaNumber, int roadLength) {
            this.areaNumber = areaNumber;
            this.roadLength = roadLength;
        }
    }
    
    public static int dijkstra(int areaNumber){
        int result = 0;

        int[] distanceInfo = new int[N+1];
        Arrays.fill(distanceInfo,Integer.MAX_VALUE);
        distanceInfo[areaNumber] = 0;

        PriorityQueue<Area> heap = new PriorityQueue<>();
        heap.add(new Area(areaNumber,0));

        while(!heap.isEmpty()){
            Area area = heap.poll();
            int currentAreaNumber = area.areaNumber;
            int currentAreaRoadLength = area.roadLength;

            if(currentAreaRoadLength > distanceInfo[currentAreaNumber]){
                continue;
            }

            for(int i = 1; i < N+1; i++){
                if(ground[currentAreaNumber][i] != -1){
                    int newRoute = currentAreaRoadLength+ground[currentAreaNumber][i];
                    if(newRoute < distanceInfo[i]){
                        distanceInfo[i] = newRoute;
                        heap.add(new Area(i,newRoute));
                    }
                }
            }
        }

        for(int i = 1; i < N+1; i++){
            if(distanceInfo[i] <= M){
                result += itemInfo[i];
            }
        }

        return result;
    }
}