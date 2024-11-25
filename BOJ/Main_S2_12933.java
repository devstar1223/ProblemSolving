package ProblemSolving.BOJ;

import java.io.*;

// 오리(https://www.acmicpc.net/problem/12933)
public class Main_S2_12933 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        // init
        String[] quackArray = (rd.readLine()).split("");
        int[] quack = new int[5];

        // solve
        int duckAmount = 0;
        for(String s : quackArray){
            if(s.equals("q")){
                quack[0]++;
            }else if(s.equals("u")){
                if(quack[0] <= quack[1]){
                    duckAmount = -1;
                    break;
                }
                quack[1]++;
            }else if(s.equals("a")){
                if(quack[1] <= quack[2]){
                    duckAmount = -1;
                    break;
                }
                quack[2]++;
            }else if(s.equals("c")){
                if(quack[2] <= quack[3]){
                    duckAmount = -1;
                    break;
                }
                quack[3]++;
            }else if(s.equals("k")){
                if(quack[3] <= quack[4]){
                    duckAmount = -1;
                    break;
                }
                duckAmount = Math.max(duckAmount,quack[0]);
                for(int i = 0; i < 4; i++){
                    quack[i] -= 1;
                }
            }
        }

        // out
        if(quack[0] == 0 && quack[1] == 0 && quack[2] == 0 && quack[3] == 0 && quack[4] == 0){
            wr.write(duckAmount+"");
        }else{
            wr.write(-1+"");
        }
        wr.flush();
    }

}