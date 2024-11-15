package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 촌수계산(https://www.acmicpc.net/problem/2644)
public class Main_S2_2644 {

    public static int[][] ground;
    public static int N;
    public static boolean[][] visitBfs;
    public static boolean[][] visitDfs;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        N = Integer.parseInt(rd.readLine());
        ground = new int[N+1][N+1];
        visitBfs = new boolean[N+1][N+1];
        visitDfs = new boolean[N+1][N+1];
        String[] targetNumArray = (rd.readLine()).split(" ");
        int target1 = Integer.parseInt(targetNumArray[0]);
        int target2 = Integer.parseInt(targetNumArray[1]);
        int m = Integer.parseInt(rd.readLine());
        for(int i = 0; i < m; i++){
            String[] relation = (rd.readLine()).split(" ");
            int human1 = Integer.parseInt(relation[0]);
            int human2 = Integer.parseInt(relation[1]);
            ground[human1][human2] = 1;
            ground[human2][human1] = 1;
        }

        // solve
        int answer1 = bfs(target1, target2);
        int answer2 = dfs(target1, target2, 1);

        // out
        wr.write(answer1+"");
        wr.newLine();
        wr.write(answer2+"");
        wr.flush();
    }

    public static int bfs(int target1, int target2){
        if(ground[target1][target2] == 1){
            return 1;
        }
        int relation = 2;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < N+1; i++){
            if(ground[target1][i] == 1){
                q.add(i);
                visitBfs[target1][i] = true;
                visitBfs[i][target1] = true;
            }
        }
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int qNum = q.poll();
                if(ground[qNum][target2] == 1){
                    return relation;
                }
                for(int j = 1; j < N+1; j++){
                    if(ground[qNum][j] == 1 && !visitBfs[qNum][j] && !visitBfs[j][qNum]){
                        visitBfs[j][qNum] = true;
                        visitBfs[qNum][j] = true;
                        q.add(j);
                    }
                }
            }
            relation++;
        }
        return -1;
    }
    public static int dfs(int target1, int target2, int depth){
        if(ground[target1][target2] == 1){
            return depth;
        }
        for(int i = 1; i < N+1; i++){
            if(ground[target1][i] == 1 && !visitDfs[target1][i] && !visitDfs[i][target1]){
                visitDfs[target1][i] = true;
                visitDfs[i][target1] = true;
                int result = dfs(i, target2, depth+1);
                if(result != -1){
                    return result;
                }
            }
        }
        return -1;
    }
}