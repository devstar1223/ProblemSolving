package ProblemSolving.BOJ;

import java.io.*;

// 민겸 수(https://www.acmicpc.net/problem/21314)
public class Main_S1_21314 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        // init
        String[] mkArray = (rd.readLine()).split("");

        String max = max(mkArray);
        String min = min(mkArray);

        // out
        wr.write(max+"\n");
        wr.write(min);
        wr.flush();
    }


    public static String max(String[] array){
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals("K")){
                result.append("5");
                for(int j = 0; j < count; j++){
                    result.append("0");
                }
                count = 0;
            }
            else{
                count++;
            }
        }

        for(int i = 0; i < count; i++){
            result.append("1");
        }

        return result.toString();
    }

    public static String min(String[] array){
        StringBuilder result = new StringBuilder();
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals("K")){
                if(count >= 1){
                    result.append("1");
                    for(int j = 0; j < count-1; j++){
                        result.append("0");
                    }
                }
                count = 0;
                result.append("5");
            }else{
                count++;
            }
        }

        if(count >= 1){
            result.append("1");
            for(int i = 0; i < count - 1; i++){
                result.append("0");
            }
        }

        return result.toString();
    }
}
