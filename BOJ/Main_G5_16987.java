package ProblemSolving.BOJ;

import java.io.*;

// 계란으로 계란치기(https://www.acmicpc.net/problem/16987)
public class Main_G5_16987 {

    static int[][] eggInfo;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        eggInfo = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] SW = (br.readLine()).split(" ");
            int S = Integer.parseInt(SW[0]);
            int W = Integer.parseInt(SW[1]);
            eggInfo[i][0] = S;
            eggInfo[i][1] = W;
        }
        bw.write(recur(0)+"");
        bw.flush();
    }

    private static int recur(int handOnEgg){

        int result = 0;

        // 손에 든 계란 깨짐
        while(handOnEgg < N && eggInfo[handOnEgg][0] <= 0){
            handOnEgg++;
        }

        // 더이상 손에 들 계란이 없음
        if(handOnEgg == N){
            return breakEggCheck();
        }

        for(int i = 0; i < N; i++){
           if(eggInfo[i][0] > 0 && handOnEgg != i){
               eggBreak(handOnEgg,i);
               result = Math.max(result,recur(handOnEgg+1));
               eggRestore(handOnEgg,i);
           }
        }

        return Math.max(result,breakEggCheck());
    }

    private static void eggBreak(int egg1, int egg2){
        eggInfo[egg1][0] -= eggInfo[egg2][1];
        eggInfo[egg2][0] -= eggInfo[egg1][1];
    }

    private static void eggRestore(int egg1, int egg2){
        eggInfo[egg1][0] += eggInfo[egg2][1];
        eggInfo[egg2][0] += eggInfo[egg1][1];
    }

    private static boolean isAllEggBreak(int handOnEgg){
        for(int i = 0; i < N; i++){
            if(i != handOnEgg && eggInfo[i][0] > 0){
                return false;
            }
        }
        return true;
    }

    private static int breakEggCheck(){
        int result = 0;
        for(int i = 0; i < N; i++){
            if(eggInfo[i][0] <= 0){
                result++;
            }
        }
        return result;
    }
}