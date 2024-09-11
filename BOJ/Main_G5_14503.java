package ProblemSolving.BOJ;

import java.io.*;
public class Main_G5_14503 {

    public static int[][] ground;
    public static int answer;
    public static int[] vY;
    public static int[] vX;
    public static int cY;
    public static int cX;
    public static int cV;
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = (rd.readLine()).split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        ground = new int[N][M];
        answer = 0;
        vY = new int[]{-1,0,1,0};
        vX = new int[]{0,1,0,-1};

        String[] cleanerState = (rd.readLine()).split(" ");
        cY = Integer.parseInt(cleanerState[0]);
        cX = Integer.parseInt(cleanerState[1]);
        cV = Integer.parseInt(cleanerState[2]);

        for(int i = 0; i < N; i++){
            String[] line = (rd.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(line[j]);
            }
        }

        while(true){
            if(ground[cY][cX] == 0){
                thisDirty();
            }

            if(check()){
                if(clean()){
                    break;
                }
            }
            else{
                thatDirty();
            }
        }

        wr.write(String.valueOf(answer));
        wr.flush();
    }

    public static void thisDirty(){
        ground[cY][cX] = -1;
        answer++;
    }

    public static boolean clean(){
        if(ground[cY - vY[cV]][cX - vX[cV]] == 1){ // 후진 불가능(벽)
            return true; // 종료 하기 위한 true
        }
        else{ // 후진 가능
            cY -= vY[cV]; // 후진
            cX -= vX[cV];
            return false; // 종료 X
        }
    }

    public static void thatDirty(){
        if(cV == 0){ // 방향 전환
            cV = 3;
        }
        else{
            cV -= 1;
        }

        if(ground[cY + vY[cV]][cX + vX[cV]] == 0){ // 앞이 더러우면
            cY += vY[cV]; // 전진
            cX += vX[cV];
        }
    }

    public static boolean check(){ // 주변이 깨끗하면 true 더러우면 false
        for(int i = 0; i < 4; i++){
            int nY = cY + vY[i];
            int nX = cX + vX[i];
            if(nY >= 0 && nX >= 0 && nY < N && nX < M){
                if(ground[nY][nX] == 0){ // 주변 더러움
                    return false;
                }
            }
        }
        return true; // 더러움 없음 = 깨끗함
    }
}