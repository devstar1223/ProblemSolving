package ProblemSolving.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 한 줄로 서기 (https://www.acmicpc.net/problem/1138)
public class Main_S2_1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        List<Integer> answerList = new ArrayList<>();

        //solve
        for(int i = N-1; i >= 0; i--){
            answerList.add(array[i],i+1);
        }

        //out
        for(int i = 0; i < N; i++){
            bw.write(answerList.get(i)+"");
            if(i != N-1){
                bw.write(" ");
            }
        }
        bw.flush();
    }
}

