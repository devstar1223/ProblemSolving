package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 저울(https://www.acmicpc.net/problem/2437)
public class Main_G2_2437 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(rd.readLine());
        String[] tmp = (rd.readLine()).split(" ");
        List<Integer> list = new ArrayList<>();
        for(String s : tmp){
            list.add(Integer.parseInt(s));
        }
        // solve
        Collections.sort(list);
        int total = 0;
        for(int i = 0; i < N; i++){
            if(total+1 != list.get(i) && total < list.get(i)){
                break;
            }
            total += list.get(i);
        }
        wr.write(total+1+"");

        // out
        wr.flush();
    }

}