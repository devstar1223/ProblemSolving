package ProblemSolving.BOJ;

import java.io.*;

// 항체 인식(https://www.acmicpc.net/problem/22352)
public class Main_G5_22352 {

    public static int N;
    public static int M;
    public static boolean[][] visit;
    public static int[][] beforeGround;
    public static int[][] afterGround;
    public static int[] dy = {1,-1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (rd.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        beforeGround = new int[N][M];
        afterGround = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String[] tmp = (rd.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                beforeGround[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for(int i = 0; i < N; i++){
            String[] tmp = (rd.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                afterGround[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        boolean answer = true;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visit[i][j] && beforeGround[i][j] != afterGround[i][j]){
                    int afterValue = afterGround[i][j];
                    int[][] newGround = newGroundSet();

                    dfs(i,j,afterValue,newGround);

                    if(!check(newGround)){
                        answer = false;
                        break;
                    }
                }
            }
            if(!answer){
                break;
            }
        }

        if(answer){
            wr.write("YES");
        }else{
            wr.write("NO");
        }
        wr.flush();

    }

    public static boolean check(int[][] newGround){

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(newGround[i][j] != afterGround[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] newGroundSet(){
        int[][] ground = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                ground[i][j] = beforeGround[i][j];
            }
        }
        return ground;
    }

    public static void dfs(int r, int c, int value,int[][] newGround){
        int preValue = newGround[r][c];
        newGround[r][c] = value;

        for(int i = 0; i < 4; i++){
            int nr = r + dy[i];
            int nc = c + dx[i];
            if(nr < N && nc < M && nr >= 0 && nc >= 0 && !visit[nr][nc] && newGround[nr][nc] == preValue){
                visit[nr][nc] = true;
                dfs(nr,nc,value,newGround);
            }
        }
    }
}

