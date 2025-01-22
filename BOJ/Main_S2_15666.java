package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// N과 M(12)(https://www.acmicpc.net/problem/15666)
public class Main_S2_15666 {

    static int[] numberArray;
    static int N,M;
    static Set<String> set = new HashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = (br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        String[] arrayString = (br.readLine()).split(" ");
        numberArray = new int[N];
        for(int i = 0; i < N; i++){
            numberArray[i] = Integer.parseInt(arrayString[i]);
        }
        Arrays.sort(numberArray);
        int[] array = new int[M];
        recur(array,0);
        bw.flush();
    }

    private static void recur(int[] array, int depth) throws IOException{
        if(depth == M){
            String s = arrayToString(array);
            if(set.add(s)){
                bw.write(s);
                bw.newLine();
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(depth != 0 && array[depth-1] > numberArray[i]){
                continue;
            }
            array[depth] = numberArray[i];
            recur(array,depth+1);
        }
    }

    private static String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        for(int i : array){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}