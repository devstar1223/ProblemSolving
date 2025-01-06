package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;
import java.util.stream.*;

// 전화번호 목록(https://www.acmicpc.net/problem/5052)
public class Main_G4_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            List<String> list = new ArrayList<>();
            List<Integer> lenList = new ArrayList<>();
            for(int i = 0; i < N; i++){
                String number = br.readLine();
                list.add(number);
                lenList.add(number.length());
            }

            lenList = lenList.stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            list.sort(Comparator.comparingInt(String::length));

            Set<String> numberSet = new HashSet<>();
            boolean pass = true;
            for(int i = 0; i < N; i++){
                String number = list.get(i);

                for(int j : lenList){
                    if(number.length() <= j){
                        break;
                    }else{
                        if(numberSet.contains(number.substring(0,j))){
                            pass = false;
                            break;
                        }
                    }
                }

                if(!pass){
                    break;
                }else{
                    numberSet.add(number);
                }
            }

            if(pass){
                bw.write("YES");
            }else{
                bw.write("NO");
            }
            if(tc != T-1){
                bw.newLine();
            }
        }
        bw.flush();

    }
}