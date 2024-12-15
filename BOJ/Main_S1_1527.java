package ProblemSolving.BOJ;

import java.io.*;

// 금민수의 개수(https://www.acmicpc.net/problem/1527)
public class Main_S1_1527 {

    public static int A;
    public static int B;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] AB = (rd.readLine()).split(" ");
        A = Integer.parseInt(AB[0]);
        B = Integer.parseInt(AB[1]);
        int N = Math.min(AB[1].length()+1,10);
        for(int i = 1; i < N; i++){
            String s = "4".repeat(i);
            recur(s,0);
        }
        wr.write(answer+"");
        wr.flush();
    }

    private static void recur(String s, int depth) {
        if(depth == s.length()){
            if(valid(s)){
                answer++;
            }
            return;
        }
        String newS;
        if(depth+1 != s.length()){
            newS = s.substring(0,depth) + "7" + s.substring(depth+1);
        }else{
            newS = s.substring(0,depth) + "7";
        }
        recur(s,depth+1);
        recur(newS,depth+1);
    }

    private static boolean valid(String s) {
        int value = Integer.parseInt(s);
        return value >= A && value <= B;
    }
}
