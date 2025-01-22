package ProblemSolving.BOJ;

import java.io.*;
import java.util.Arrays;

// 서강그라운드(https://www.acmicpc.net/problem/14938)
public class Main_G4_14938 {

    static int[] itemInfo;
    static int[][] ground;
    static int N,M,R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NMR = (br.readLine()).split(" ");
        N = Integer.parseInt(NMR[0]); // 지역갯수
        M = Integer.parseInt(NMR[1]); // 수색범위
        R = Integer.parseInt(NMR[2]); // 길의개수
        String[] itemInfoString = (br.readLine()).split(" ");
        itemInfo = new int[N+1];
        ground = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            itemInfo[i] = Integer.parseInt(itemInfoString[i-1]);
        }

        for(int[] array : ground){
            Arrays.fill(array,-1);
        }

        for(int i = 0; i < R; i++){
            String[] ABL = (br.readLine()).split(" ");
            int A = Integer.parseInt(ABL[0]);
            int B = Integer.parseInt(ABL[1]);
            int L = Integer.parseInt(ABL[2]); // 거리
            ground[A][B] = L;
            ground[B][A] = L;
        }

        for(int k = 1; k < N+1; k++){
            for(int i = 1; i < N+1; i++){
                for(int j = 1; j < N+1; j++){
                    if(ground[i][k] != -1 && ground[k][j] != -1){
                        if(ground[i][j] == -1){
                            ground[i][j] = ground[i][k] + ground[k][j];
                        }else{
                            ground[i][j] = Math.min(ground[i][j],ground[i][k] + ground[k][j]);
                        }
                    }
                }
            }
        }

        int maxItem = -1;
        for(int i = 1; i < N+1; i++){ // i부터 N까지의 지역에 떨어지면
            int item = itemInfo[i]; // 일단 i지역에서 아이템을 줍고
            for(int j = 1; j < N+1; j++){
                if(ground[i][j] <= M && ground[i][j] != -1 && i !=j ){
                    item += itemInfo[j];
                }
            }
            maxItem = Math.max(maxItem,item);
        }
        bw.write(maxItem+"");
        bw.flush();
    }
}