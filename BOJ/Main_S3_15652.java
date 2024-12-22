package ProblemSolving.BOJ;

import java.io.*;

// N과 M (4)(https://www.acmicpc.net/problem/15652)
public class Main_S3_15652 {

    public static int N,M;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        for(int i = 1; i <= N; i++){
            int[] answer = new int[M];
            dfs(i,0,answer);
        }
        bw.flush();
    }

    private static void dfs(int i, int depth,int[] answer) throws IOException{
        if(depth == M-1){
            answer[depth] = i;
            for(int j = 0; j < answer.length; j++){
                if(j != answer.length-1){
                    bw.write(answer[j]+" ");
                }else{
                    bw.write(answer[j]+"\n");
                }
            }
            return;
        }

        answer[depth] = i;

        for(int j = i; j <= N; j++){
            dfs(j,depth+1,answer);
        }

    }
}