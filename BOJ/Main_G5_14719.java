package ProblemSolving.BOJ;

import java.io.*;

// 빗물(https://www.acmicpc.net/problem/14719)
public class Main_G5_14719 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] HW = (rd.readLine()).split(" ");
        int H = Integer.parseInt(HW[0]);
        int W = Integer.parseInt(HW[1]);
        String[] wallInfoStringArray = (rd.readLine()).split(" ");
        int[] wallInfoArray = new int[W];
        for(int i = 0; i < wallInfoArray.length; i++){
            wallInfoArray[i] = Integer.parseInt(wallInfoStringArray[i]);
        }
        boolean[][] ground = new boolean[H][W];
        for(int i = 0; i < W; i++){
            for(int j = 0; j < wallInfoArray[i]; j++){
                ground[j][i] = true;
            }
        }

        int answer = 0;

        for(int i = 0; i < H; i++){
            int rain = 0;
            boolean count = false;
            for(int j = 0; j < W; j++){
                if(!count && ground[i][j]){ // 집계 시작 안했는데, 벽이 있다.
                    count = true; // 집계 시작
                }
                else if(count && !ground[i][j]){ // 집계 중인데, 빈 공간이 있다.
                    rain++;
                }else if(count && ground[i][j] && rain > 0){ // 집계 중인데, 벽이 나왔고, 빗물을 모았다.
                    answer += rain;
                    rain = 0;
                }
            }
        }

        wr.write(answer+"");
        wr.flush();
    }

}