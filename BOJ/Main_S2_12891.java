package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// DNA 비밀번호(https://www.acmicpc.net/problem/12891)
public class Main_S2_12891 {

    public static int[] acgtAmount = new int[4];
    public static int[] acgtLimit = new int[4];
    public static HashMap<String,Integer> dnaCode;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] SP = (rd.readLine()).split(" ");
        int S = Integer.parseInt(SP[0]); // 문자열 길이
        int P = Integer.parseInt(SP[1]); // 부분문자열 길이
        String[] passwordCandidate = (rd.readLine()).split("");
        String[] acgtLimitInfo = (rd.readLine()).split(" ");
        acgtLimit[0] = Integer.parseInt(acgtLimitInfo[0]);
        acgtLimit[1] = Integer.parseInt(acgtLimitInfo[1]);
        acgtLimit[2] = Integer.parseInt(acgtLimitInfo[2]);
        acgtLimit[3] = Integer.parseInt(acgtLimitInfo[3]);

        dnaCode = new HashMap<>();
        dnaCode.put("A",0);
        dnaCode.put("C",1);
        dnaCode.put("G",2);
        dnaCode.put("T",3);

        for(int i = 0; i < P; i++){ // 첫 문장 ACGT 수 담기
            int index = dnaCode.get(passwordCandidate[i]);
            acgtAmount[index]++;
        }

        int answer = 0;

        if(possiblePassword()){
            answer++;
        }

        for(int i = 0; i < S - P; i++){
            acgtAmountChange(passwordCandidate[i],passwordCandidate[i+P]);
            if(possiblePassword()){
                answer++;
            }
        }

        wr.write(answer+"");
        wr.flush();
    }

    public static boolean possiblePassword(){
        for(int i = 0; i < 4; i++){
            if(acgtAmount[i] < acgtLimit[i]){
                return false;
            }
        }
        return true;
    }

    public static void acgtAmountChange(String left, String right){
        int leftIndex = dnaCode.get(left);
        int rightIndex = dnaCode.get(right);
        acgtAmount[leftIndex]--;
        acgtAmount[rightIndex]++;
    }
}