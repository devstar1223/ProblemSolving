package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//22574. 높은 곳으로
public class Solution_D3_22574 {
    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(rd.readLine());
        for(int tc = 1; tc <= T; tc++) {
            String[] tmp = (rd.readLine()).split(" ");
            int selectCount = Integer.parseInt(tmp[0]);
            int boom = Integer.parseInt(tmp[1]);
            int answer = 0;
            for(int i = 1; i <= selectCount; i++){
                answer += i;
                if(answer == boom){
                    answer--;
                }
            }
            wr.write(answer+"");
            if(tc != T){
                wr.newLine();
            }
        }
        wr.flush();
        rd.close();
        wr.close();
    }
}