package ProblemSolving.BOJ;

import java.io.*;

// IOIOI(https://www.acmicpc.net/problem/5525)
public class Main_S1_5525 {

    static boolean timeI;
    static int streak;
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(rd.readLine());
        int M = Integer.parseInt(rd.readLine());
        String S = rd.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append("IO");
        }
        sb.append("I");
        String P = sb.toString();
        int answer = 0;
        timeI = true;
        streak = 0;
        String[] ground = S.split("");
        for(int i = 0; i < M; i++){
            boolean tf = check(ground[i]);
            if(tf){
                streak++;
            }
            else{
                streak = (ground[i].equals("I")) ? 1 : 0;
            }
            if(streak >= (2*N)+1 && streak % 2 == 1){
                answer++;
            }
        }
        wr.write(answer+"");
        wr.flush();
    }

    public static boolean check(String s){
        if(timeI && s.equals("I")){
            timeI = false;
            return true;
        }
        else if(!timeI && s.equals("O")){
            timeI = true;
            return true;
        }
        return false;
    }
}
