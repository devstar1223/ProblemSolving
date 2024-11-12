package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1220.Magnetic
public class Solution_D3_1220 {

    public static int ground[][];

    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            int answer = 0;
            int N = Integer.parseInt(rd.readLine());
            ground = new int[N][N];
            for(int i = 0; i < N; i++){
                String[] groundLine = (rd.readLine()).split(" ");
                for(int j = 0; j < N; j++){
                    ground[i][j] = Integer.parseInt(groundLine[j]);
                }
            }

            //테이블의 원소를 N과 S로 이동
            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    sUp(y,x);
                    nDown(y,x);
                }
            }

            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    if(findDeadlock(y,x)){
                     answer++;
                    }
                }
            }

            wr.write("#"+tc+" "+answer);


            if(tc != T){
                wr.newLine();
            }
        }
        wr.flush();
        rd.close();
        wr.close();
    }

    public static void sUp(int y, int x){ // 2는 올라가야한다.
        if(ground[y][x] != 2){ // s극이 아니면 탈출
            return;
        }
        while(y > 0){
            if(ground[y-1][x] == 0){
                ground[y-1][x] = 2;
                ground[y][x] = 0;
                y--;
            }
            else{
                return;
            }
        }
        ground[y][x] = 0;
    }
    public static void nDown(int y, int x){ // 1은 내려가야한다.
        if(ground[y][x] != 1){ // s극이 아니면 탈출
            return;
        }
        while(y < 99){
            if(ground[y+1][x] == 0){
                ground[y+1][x] = 1;
                ground[y][x] = 0;
                y++;
            }
            else{
                return;
            }
        }
        ground[y][x] = 0;
    }
    public static boolean findDeadlock(int y, int x){
        return ground[y][x] == 1 && y < 99 && ground[y + 1][x] == 2;
    }
}