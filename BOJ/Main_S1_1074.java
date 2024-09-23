package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// Z(https://www.acmicpc.net/problem/1074)
public class Main_S1_1074 {

    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tmp = (rd.readLine()).split(" ");
        int N = Integer.parseInt(tmp[0]);
        int r = Integer.parseInt(tmp[1]);
        int c = Integer.parseInt(tmp[2]);
        answer = 0;
        recur(r,c,N);
        wr.write(answer+"");
        wr.flush();
    }

    public static void recur(int y, int x, int N){
        if(N == 0){ // 재귀 종료
            if(y == 0 && x == 1){
                answer += 1;
            }
            else if(y == 1 && x == 0){
                answer += 2;
            }
            else if(y == 1 && x == 1){
                answer += 3;
            }
        }
        else{
            int len = (int)(Math.pow(2,N)); // 변의 길이
            int half = (len / 2); // 변의 길이의 절반
            int plus = ((len*len) / 4);
            int size = N-1;
            int nY = y;
            int nX = x;
            if(y < half && x >= half){// 1사분면
                answer += plus;
                nX -= half;
            }
            else if(y >= half && x < half){// 3사분면
                answer += plus*2;
                nY -= half;
            }
            else if(y >= half && x >= half){// 4사분면
                answer += plus*3;
                nX -= half;
                nY -= half;
            }
            recur(nY,nX,size);
        }

    }
}