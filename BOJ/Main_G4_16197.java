package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//두 동전(https://www.acmicpc.net/problem/16197)
public class Main_G4_16197 {

    static String[][] ground;
    static boolean[][][][] visited;
    static int N,M;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        ground = new String[N][M];
        visited = new boolean[N][M][N][M];
        List<Integer> coinIndexList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split("");
            for(int j = 0; j < M; j++){
                ground[i][j] = line[j];
                if(line[j].equals("o")){
                    coinIndexList.add(i);
                    coinIndexList.add(j);
                }
            }
        }

        int[] coinIndex = new int[4];
        for(int i = 0; i < 4; i++){
            coinIndex[i] = coinIndexList.get(i);
        }
        int answer = bfs(coinIndex);
        bw.write(answer+"");
        bw.flush();
    }

    private static int bfs(int[] coinIndex){
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        visit(coinIndex);
        q.add(coinIndex);
        while(!q.isEmpty() && count <= 10){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] pollCoinIndex = q.poll();

                for(int j = 0; j < 4; j++){
                    int[] addCoinIndex = move(pollCoinIndex,j);

                    int coinDrop = coinDrop(addCoinIndex);

                    if(coinDrop == 2){
                        continue;
                    }
                    if(coinDrop == 1){
                        return count;
                    }
                    if(!visited(addCoinIndex)){
                        visit(addCoinIndex);
                        q.add(addCoinIndex);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private static void visit(int[] coinIndex){
        visited[coinIndex[0]][coinIndex[1]][coinIndex[2]][coinIndex[3]] = true;
    }

    private static boolean visited(int[] coinIndex){
        return visited[coinIndex[0]][coinIndex[1]][coinIndex[2]][coinIndex[3]];
    }

    private static int[] move(int[] coinIndex,int direction){
        int[] moveIndex = new int[4];

        int y1 = coinIndex[0];
        int x1 = coinIndex[1];
        int y2 = coinIndex[2];
        int x2 = coinIndex[3];

        int ny1 = y1 + dy[direction];
        int nx1 = x1 + dx[direction];
        int ny2 = y2 + dy[direction];
        int nx2 = x2 + dx[direction];

        if(ny1 >= 0 && ny1 < N && nx1 >= 0 && nx1 < M && ground[ny1][nx1].equals("#")){
            moveIndex[0] = y1;
            moveIndex[1] = x1;
        }else{
            moveIndex[0] = ny1;
            moveIndex[1] = nx1;
        }

        if(ny2 >= 0 && ny2 < N && nx2 >= 0 && nx2 < M && ground[ny2][nx2].equals("#")){
            moveIndex[2] = y2;
            moveIndex[3] = x2;
        }else{
            moveIndex[2] = ny2;
            moveIndex[3] = nx2;
        }

        return moveIndex;
    }

    private static int coinDrop(int[] coinIndex){
        if(coinIndex[0] < 0 || coinIndex[0] >= N || coinIndex[1] < 0 || coinIndex[1] >= M){
            if(coinIndex[2] < 0 || coinIndex[2] >= N || coinIndex[3] < 0 || coinIndex[3] >= M){
                return 2;
            }
            else{
                return 1;
            }
        }

        else if(coinIndex[2] < 0 || coinIndex[2] >= N || coinIndex[3] < 0 || coinIndex[3] >= M){
            return 1;
        }

        return 0;
    }
}