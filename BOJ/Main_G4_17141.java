package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 연구소(https://www.acmicpc.net/problem/17141)
public class Main_G4_17141 {

    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static List<int[]> installIndexList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        int[][] ground = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] row = (br.readLine()).split(" ");
            for(int j = 0; j < N; j++){
                ground[i][j] = Integer.parseInt(row[j]);
                if(ground[i][j] == 2){
                    installIndexList.add(new int[]{i,j});
                }
            }
        }

        virusSelect(0, 0,new int[M][2],ground);

        if(answer == Integer.MAX_VALUE){
            bw.write("-1");
        }else{
            bw.write(answer-1+"");
        }
        bw.flush();
    }

    private static void virusSelect(int count, int startIndex, int[][] indexArray, int[][] ground) {
        if(count == M){
            answer = Math.min(answer,virusSpreadBfs(indexArray,ground));
            return;
        }

        for(int i = startIndex; i < installIndexList.size(); i++){
            int[] array = installIndexList.get(i);
            indexArray[count][0] = array[0];
            indexArray[count][1] = array[1];
            virusSelect(count+1,i+1,indexArray,ground);
        }
    }

    private static int virusSpreadBfs(int[][] indexArray,int[][] ground) {
        int count = 0;
        boolean[][] visited = new boolean[N][N];

        Queue<int[]> q = new LinkedList<>();
        for(int[] array : indexArray){
            q.add(new int[]{array[0],array[1]});
            visited[array[0]][array[1]] = true;
        }

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] index = q.poll();
                int y = index[0];
                int x = index[1];
                for(int j = 0; j < 4; j++){
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if(ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx] && ground[ny][nx] != 1){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                    }
                }
            }
            count++;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(ground[i][j] != 1 && !visited[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        return count;
    }

}