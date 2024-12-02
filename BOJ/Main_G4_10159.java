package ProblemSolving.BOJ;

import java.io.*;

// 저울(https://www.acmicpc.net/problem/10159)
public class Main_G4_10159 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        int[][] ground = new int[N+1][N+1];
        int M = Integer.parseInt(rd.readLine());
        for(int i = 0 ; i < M; i++){
            String[] lineInfo = (rd.readLine()).split(" ");
            int A = Integer.parseInt(lineInfo[0]);
            int B = Integer.parseInt(lineInfo[1]);
            // 무게는 A > B 이다.
            ground[A][B] = 1;
            ground[B][A] = -1;
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(ground[i][k] == 1 && ground[k][j] == 1){
                        ground[i][j] = 1;
                    }
                    if(ground[i][k] == -1 && ground[k][j] == -1){
                        ground[i][j] = -1;
                    }
                }
            }
        }

        for(int i = 1; i < N+1; i++){
            int answer = -1; // 자기 자신도 추가되므로, 미리 -1로 한다.
            for(int j = 1; j < N+1; j++){
                if(ground[i][j] == 0){
                    answer++;
                }
            }
            wr.write(answer+"");
            wr.newLine();
        }

        wr.flush();
    }

}