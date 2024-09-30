package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// AC(https://www.acmicpc.net/problem/5430)
public class Main_G5_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(rd.readLine());
        for(int i = 0; i < T; i++){
            // 입력부
            String[] func = (rd.readLine()).split("");
            int len = Integer.parseInt(rd.readLine());
            String X = rd.readLine();
            String subX = X.substring(1,X.length()-1);
            String[] arr = (subX).split(",");
            Deque<String> d = new LinkedList<>();
            for(String s : arr){
                if(!s.equals("")){
                    d.addLast(s);
                }
            }
            StringBuilder answer = new StringBuilder();
            boolean reverse = false;
            // 로직
            for(String s : func){
                if(d.isEmpty() && s.equals("D")){
                    answer.append("error");
                    break;
                }
                if(s.equals("D")){
                    if(reverse){
                        d.removeLast();
                    }
                    else{
                        d.removeFirst();
                    }
                }
                else{
                    reverse = !reverse;
                }
            }

            // 출력
            if(answer.isEmpty()){
                answer.append("[");
                int size = d.size();
                for(int j = 0; j < size; j++){
                    if(reverse){
                        answer.append(d.removeLast());
                    }
                    else{
                        answer.append(d.removeFirst());
                    }
                    if(j != size-1){
                        answer.append(",");
                    }
                }
                answer.append("]");
            }
            wr.write(answer+"\n");
        }
        wr.flush();
    }

}
