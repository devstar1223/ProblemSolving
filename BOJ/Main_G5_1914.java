package ProblemSolving.BOJ;

import java.io.*;
import java.math.BigInteger;

public class Main_G5_1914 {
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 원판의 개수 입력
        BigInteger answer = BigInteger.valueOf(1);

        for(int i = 0; i < n; i++){
            answer = answer.multiply(BigInteger.valueOf(2));
        }
        answer = answer.subtract(BigInteger.valueOf(1));
        wr.write(answer+"\n");

        if(n <= 20){
            hanoi(n,1,2,3);
        }
        wr.flush();
    }

    public static void hanoi(int n, int start, int mid, int end) throws IOException {
        if(n == 1){
            wr.write(start + " " + end+"\n");
        }else{
            hanoi(n-1,start,end,mid);
            wr.write(start + " " + end+"\n");
            hanoi(n-1,mid,start,end);
        }
    }
}
