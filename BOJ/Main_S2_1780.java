package ProblemSolving.BOJ;

import java.io.*;

public class Main_S2_1780 {

    public static int[][] ground;
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(rd.readLine());
        ground = new int[N][N];
        answer = new int[3]; // answer[0] = -1, answer[1] = 0, answer[2] = 1

        for (int i = 0; i < N; i++) {
            String[] tmp = rd.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                ground[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        recur(0,0,N);

        wr.write(answer[0] + "\n");
        wr.write(answer[1] + "\n");
        wr.write(answer[2] + "\n");

        wr.flush();
        wr.close();
        rd.close();
    }

    public static void recur(int y, int x, int n){
        if(sameCheck(y,x,n)){
            answer[ground[y][x]+1] += 1;
        }
        else{ // 9개로 쪼개기
            int size = n / 3;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    recur(y+(size*i),x+(size*j),size);
                }
            }
        }
    }

    public static boolean sameCheck(int y, int x, int n){
        int num = ground[y][x];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(ground[y+i][x+j] != num){
                    return false;
                }
            }
        }
        return true;
    }
}
