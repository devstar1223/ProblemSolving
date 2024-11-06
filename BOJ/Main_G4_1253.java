package ProblemSolving.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 좋다(https://www.acmicpc.net/problem/1253)
public class Main_G4_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(rd.readLine());
        String[] tmp = (rd.readLine()).split(" ");

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(tmp[i]));
        }
        Collections.sort(list);
        // solve
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j){
                    continue;
                }
                int plusValue = list.get(i) + list.get(j);
                int[] index = new int[]{i,j};
                List<int[]> indexList = map.getOrDefault(plusValue,new ArrayList<>());
                indexList.add(index);
                map.put(plusValue,indexList);
            }
        }

        int answer = 0;

        for(int i = 0; i < N; i++){
            if(map.containsKey(list.get(i))){
                List<int[]> indexList = map.get(list.get(i));
                for(int j = 0; j < indexList.size(); j++){
                    int[] index = indexList.get(j);
                    if(index[0] != i && index[1] != i){
                        answer++;
                        break;
                    }
                }
            }
        }


        // out
        wr.write(answer+"");
        wr.flush();

    }
}