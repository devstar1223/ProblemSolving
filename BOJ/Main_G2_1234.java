package ProblemSolving.BOJ;

import java.io.*;

// 크리스마스 트리(https://www.acmicpc.net/problem/1234)
public class Main_G2_1234 {

    public static long answer = 0;
    public static int N = 0;
    public static long[][][][] dpTable;
    public static long[] factorial;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NColor = (br.readLine()).split(" ");
        N = Integer.parseInt(NColor[0]);
        int R = Integer.parseInt(NColor[1]);
        int G = Integer.parseInt(NColor[2]);
        int B = Integer.parseInt(NColor[3]);
        dpTable = new long[N+1][111][111][111];

        factorial = new long[N+1];
        factorial[1] = 1;
        for(int i = 2; i < N+1; i++){
            factorial[i] = factorial[i-1] * i;
        }

        dp(N,R,G,B);
        bw.write(dpTable[N][R+10][G+10][B+10]+"");
        bw.flush();
    }

    public static long dp(int level,int r, int g, int b){

        long total = 0;

        if(dpTable[level][r+10][g+10][b+10] == -1){
            return 0;
        }

        if(r < 0 || g < 0 || b < 0){
            dpTable[level][r+10][g+10][b+10] = -1;
            return 0;
        }

        if(level == 0){
            dpTable[level][r][g][b] = 1;
            return 1;
        }

        if(dpTable[level][r+10][g+10][b+10] != 0){
            return dpTable[level][r+10][g+10][b+10];
        }

        if (level % 2 == 0){ // 두 장난감 배치
            total += combination(level,level/2) * dp(level-1,r-level/2,g-level/2,b);
            total += combination(level,level/2) * dp(level-1,r,g-level/2,b-level/2);
            total += combination(level,level/2) * dp(level-1,r-level/2,g,b-level/2);
        }
        if (level % 3 == 0){ // 세 장난감 배치
            total += comb3colors(level) * dp(level-1,r-level/3,g-level/3,b-level/3);
        }
            // 공통
            total += dp(level-1,r-level,g,b);
            total += dp(level-1,r,g-level,b);
            total += dp(level-1,r,g,b-level);

            dpTable[level][r+10][g+10][b+10] = total;
            return total;
    }

    public static long combination(int total, int select){ // 2가지 색 장난감 배치시, N칸을 N/2개의 장난감으로 채운다.
        return factorial[total] / (factorial[select] * factorial[total-select]);
    }

    public static long comb3colors(int K) { // 3가지 색 장난감 배치시. 다항 계수 사용
        int each = K / 3;
        return factorial[K] / (factorial[each] * factorial[each] * factorial[each]);
    }

}