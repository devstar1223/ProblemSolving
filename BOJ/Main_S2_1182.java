package ProblemSolving.BOJ;

import java.io.*;

// 부분수열의 합 (https://www.acmicpc.net/problem/1182)
public class Main_S2_1182 {

    public static int N,S;
    public static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] NS = br.readLine().split(" ");
        N = Integer.parseInt(NS[0]);
        S = Integer.parseInt(NS[1]);

        String[] line = br.readLine().split(" ");
        array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(line[i]);
        }

        // solve
        int answer = dfs(0,0);
        if(S == 0){
            answer--;
        }

        // output
        bw.write(answer+"");
        bw.flush();
    }

    private static int dfs(int index, int sum){
        int result = 0;
        if(index == N){
            if(sum == S){
                return 1;
            }
            return 0;
        }

        result += dfs(index+1,sum+array[index]);
        result += dfs(index+1,sum);
        return result;
    }
}

