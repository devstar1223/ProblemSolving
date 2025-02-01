package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//스타트와 링크(https://www.acmicpc.net/problem/14889)
public class Main_S1_14889 {

    static int[][] graph;
    static int N, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        graph = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            String[] line = (br.readLine()).split(" ");
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(line[j-1]);
            }
        }
        List<Integer> myTeam = new ArrayList<>();
        List<Integer> yourTeam = new ArrayList<>();

        recur(1,myTeam,yourTeam);

        bw.write(min+"");
        bw.flush();
    }

    private static void recur(int number,List<Integer> myTeam, List<Integer> yourTeam){

        if(myTeam.size() > N/2 || yourTeam.size() > N/2){
            return;
        }

        if(number == N+1){
            min = Math.min(min,calculateScore(myTeam,yourTeam));
            return;
        }

        myTeam.add(number);
        recur(number+1,myTeam,yourTeam);
        myTeam.remove(myTeam.size()-1);

        yourTeam.add(number);
        recur(number+1,myTeam,yourTeam);
        yourTeam.remove(yourTeam.size()-1);
    }

    private static int calculateScore(List<Integer> myTeam, List<Integer> yourTeam){
        int myScore = 0;
        int yourScore = 0;
        int len = N/2;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                myScore += graph[myTeam.get(i)][myTeam.get(j)];
                yourScore += graph[yourTeam.get(i)][yourTeam.get(j)];
            }
        }
        return Math.abs(myScore-yourScore);
    }
}