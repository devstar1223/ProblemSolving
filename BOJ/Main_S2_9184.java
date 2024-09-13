package ProblemSolving.BOJ;

import java.io.*;

public class Main_S2_9184 {

    public static int[][][] dpTable;

    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        dpTable = new int[101][101][101];
        while(true){
            String s = rd.readLine();
            if(s.equals("-1 -1 -1")){
                break;
            }
            else{
                String[] tmp = s.split(" ");
                int a = Integer.parseInt(tmp[0]);
                int b = Integer.parseInt(tmp[1]);
                int c = Integer.parseInt(tmp[2]);
                int d = w(a,b,c);
                String answer = "w(" + a + ", " + b + ", " + c + ") = " + d + "\n";
                wr.write(answer);
                wr.flush();
            }
        }
    }

    public static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0){
            dpTable[a+50][b+50][c+50] = 1;
            return 1;
        }
        else if(a > 20 || b > 20 || c > 20){
            if(dpTable[a+50][b+50][c+50] != 0){
                return dpTable[a+50][b+50][c+50];
            }
            else{
                int d = w(20,20,20);
                dpTable[a+50][b+50][c+50] = d;
                return d;
            }
        }
        else if(a < b && b < c){
            if(dpTable[a+50][b+50][c+50] != 0){
                return dpTable[a+50][b+50][c+50];
            }
            else{
                int d = w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1, c);
                dpTable[a+50][b+50][c+50] = d;
                return d;
            }

        }
        else{
            if(dpTable[a+50][b+50][c+50] != 0){
                return dpTable[a+50][b+50][c+50];
            }
            else{
                int d = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
                dpTable[a+50][b+50][c+50] = d;
                return d;
            }
        }
    }
}
