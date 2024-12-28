package ProblemSolving.BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 여행가자(https://www.acmicpc.net/problem/1976)
public class Main_G4_1976 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] ground = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            String[] tmp = (br.readLine()).split(" ");
            for(int j = 1; j < N+1; j++){
                ground[i][j] = Integer.parseInt(tmp[j-1]);
                ground[j][j] = 1;
            }
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(ground[i][k] == 1 && ground[k][j] == 1){
                        ground[i][j] = 1;
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        String[] routeString = (br.readLine()).split(" ");
        for(String s : routeString){
            q.add(Integer.parseInt(s));
        }

        boolean possible = true;

        int departure = q.poll();

        while(!q.isEmpty()){
            int arrival = q.poll();
            if(ground[departure][arrival] == 0){
                possible = false;
                q.clear();
            }
            departure = arrival;
        }

        if(possible){
            bw.write("YES");
        }else{
            bw.write("NO");
        }
        bw.flush();

    }
}