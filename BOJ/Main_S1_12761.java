package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 돌다리(https://www.acmicpc.net/problem/12761)
public class Main_S1_12761 {

    public static int powerA,powerB,departure,arrival;
    public static boolean[] visit = new boolean[100001];
    public static int[] DX,POWER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ABNM = (br.readLine()).split(" ");
        powerA = Integer.parseInt(ABNM[0]);
        powerB = Integer.parseInt(ABNM[1]);
        departure = Integer.parseInt(ABNM[2]);
        arrival = Integer.parseInt(ABNM[3]);
        DX = new int[]{-1,1,powerA,-powerA,powerB,-powerB};
        POWER = new int[]{powerA,powerB};
        bw.write(bfs()+"");
        bw.flush();
    }

    private static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(departure);

        int count = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int num = q.poll();
                if(num == arrival){
                    return count;
                }
                for(int j = 0; j < 6; j++){
                    int nx = num + DX[j];
                    if(nx >= 0 && nx <= 100000 && !visit[nx]){
                        visit[nx] = true;
                        q.add(nx);
                    }
                }
                for(int j = 0; j < 2; j++){
                    int nx = num * POWER[j];
                    if(nx <= 100000 && !visit[nx]){
                        visit[nx] = true;
                        q.add(nx);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}