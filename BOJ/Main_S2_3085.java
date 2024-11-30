package ProblemSolving.BOJ;

import java.io.*;

// 사탕 게임(https://www.acmicpc.net/problem/3085)
public class Main_S2_3085 {

    public static String[][] ground;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // 초기화
        N = Integer.parseInt(rd.readLine());
        ground = new String[N][N];

        for(int i = 0; i < N; i++){
            String[] line = (rd.readLine()).split("");
            for(int j = 0; j < N; j++){
                ground[i][j] = line[j];
            }
        }

        // 풀이
        if(N == returnMaxCandy()){ // 한 판 확인
            wr.write(N+""); // 안바꿔도 최대로 먹는다면 그대로 반환
        }else{
            int maxCandy = 1;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(j+1 < N){
                        changeGroundWidth(i,j);
                        maxCandy = Math.max(maxCandy,changeLineMaxCandy(i,j,i,j+1));
                        changeGroundWidth(i,j);
                    }
                    if(i+1 < N){
                        changeGroundHeight(i,j);
                        maxCandy = Math.max(maxCandy,changeLineMaxCandy(i,j,i+1,j));
                        changeGroundHeight(i,j);
                    }
                }
            }
            wr.write(maxCandy+"");
        }
        wr.flush();
    }

    public static int returnMaxCandy(){
        int maxCandy = 1;
        for(int i = 0; i < N; i++){
            int streak = 0;
            String base = "";
            for(int j = 0; j < N; j++){
                if(!ground[i][j].equals(base)){
                    base = ground[i][j];
                    streak = 1;
                }else{
                    streak++;
                    maxCandy = Math.max(maxCandy,streak);
                }
            }
        }

        for(int i = 0; i < N; i++){
            int streak = 0;
            String base = "";
            for(int j = 0; j < N; j++){
                if(!ground[j][i].equals(base)){
                    base = ground[j][i];
                    streak = 1;
                }else{
                    streak++;
                    maxCandy = Math.max(maxCandy,streak);
                }
            }
        }

        return maxCandy;
    }
    public static int changeLineMaxCandy(int R1, int C1, int R2, int C2){
        int maxCandy = 1;
        for(int i = R1; i <= R2; i++){
            String base = "";
            int streak = 0;
            for(int j = 0; j < N; j++){
                if(!ground[i][j].equals(base)){
                    streak = 1;
                    base = ground[i][j];
                }else{
                    streak++;
                    maxCandy = Math.max(maxCandy,streak);
                }
            }
        }
        for(int i = C1; i <= C2; i++){
            String base = "";
            int streak = 0;
            for(int j = 0; j < N; j++){
                if(!ground[j][i].equals(base)){
                    streak = 1;
                    base = ground[j][i];
                }else{
                    streak++;
                    maxCandy = Math.max(maxCandy,streak);
                }
            }
        }
        return maxCandy;
    }
    public static void changeGroundHeight(int r, int c){
        String tmp = ground[r][c];
        ground[r][c] = ground[r+1][c];
        ground[r+1][c] = tmp;
    }
    public static void changeGroundWidth(int r, int c){
        String tmp = ground[r][c];
        ground[r][c] = ground[r][c+1];
        ground[r][c+1] = tmp;
    }
}