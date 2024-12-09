package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 문자열 폭발(https://www.acmicpc.net/problem/9935)
public class Main_G4_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sArray = (rd.readLine()).split("");
        String[] bombArray = (rd.readLine()).split("");
        int bombLen = bombArray.length;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < sArray.length; i++){
            stack.push(sArray[i]);
            if(stack.size() >= bombLen){
                boolean pop = true;
                for(int j = 0; j < bombLen; j++){
                    if(!stack.get(stack.size()-1-j).equals(bombArray[bombLen-1-j])){
                        pop = false;
                        break;
                    }
                }
                if(pop){
                    for(int j = 0; j < bombLen; j++){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()){
            wr.write("FRULA");
        }else{
            for(String s : stack){
                wr.write(s+"");
            }
        }
        wr.flush();
    }
}
