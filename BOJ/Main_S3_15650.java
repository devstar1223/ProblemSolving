package ProblemSolving.BOJ;

import java.io.*;

public class Main_S3_15650 {
    static int N, M;
    static BufferedReader rd;
    static BufferedWriter wr;

    public static void main(String[] args) throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = rd.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] answer = new int[M];

        recur(1,0,answer);
        wr.flush();
    }

    public static void recur(int start, int depth,int[] answer) throws IOException{
        if(depth == M){
            for(int i = 0 ; i < M-1; i++){
                wr.write(answer[i]+" ");
            }
            wr.write(answer[M-1]+"\n");
            return;
        }

        for(int i = start; i <= N; i++){
            answer[depth] = i;
            recur(i+1,depth+1,answer);
        }
    }
}
