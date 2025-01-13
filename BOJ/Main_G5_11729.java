package ProblemSolving.BOJ;

import java.io.*;

// 하노이 탑 이동 순서(https://www.acmicpc.net/problem/11729)
public class Main_G5_11729 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2,N)-1+"\n");
        hanoi(N,1,2,3);
        bw.flush();
    }

    public static void hanoi(int N,int start, int mid, int end) throws IOException{
        if(N == 1){
            bw.write(start + " " + end+"\n");
            return;
        }
        hanoi(N-1,start,end,mid);
        bw.write(start + " " + end+"\n");
        hanoi(N-1,mid,start,end);
    }
}