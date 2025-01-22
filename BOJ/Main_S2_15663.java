package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// N과 M (9)(https://www.acmicpc.net/problem/15663)
public class Main_S2_15663 {

    static int[] numberArray;
    static int N,M;
    static Set<String> set = new HashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        String[] tmp = (br.readLine()).split(" ");
        numberArray = new int[N];
        for(int i = 0; i < N; i++){
            numberArray[i] = Integer.parseInt(tmp[i]);
        }
        Arrays.sort(numberArray);

        int[] array = new int[M];
        boolean[] visited = new boolean[N];

        recur(array,visited,0);

        bw.flush();
    }

    public static void recur(int[] array, boolean[] visited, int depth) throws IOException{
        if(depth == M){
            String s = arrayToString(array);
            if(set.add(s)){
                bw.write(s);
                bw.newLine();
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]){
                continue;
            }
            array[depth] = numberArray[i];
            visited[i] = true;
            recur(array,visited,depth+1);
            visited[i] = false;
        }
    }

    public static String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        for(int i : array){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}