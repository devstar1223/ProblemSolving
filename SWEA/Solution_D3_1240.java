package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//1240.단순 2진 암호코드
public class Solution_D3_1240 {
    public static void main(String args[]) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(rd.readLine());
        for(int tc = 1; tc <= T; tc++) {

            String[] NM = (rd.readLine()).split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            // 암호문 추출
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < M; i++){
                sb.append("0");
            }
            String notPassword = sb.toString();
            String password = "";

            for(int i = 0; i < N; i++){
                String tmp = rd.readLine();
                if(!tmp.equals(notPassword)){
                    password = tmp;
                }
            }



            // 각각의 비트 분리
            String[] passwordStringArray = passwordDivideEight(password);

            // 올바른 비트인지 확인 + 합
            int answerTest = 0;
            int answer = 0;
            for(int i = 0; i < 8; i++){
                int num = bitToNumber(passwordStringArray[i]);
                if(i%2 != 1){
                    answerTest += num*3;
                }
                else{
                    answerTest += num;
                }
                answer += num;
            }
            if(answerTest % 10 == 0){
                wr.write("#"+tc+" "+answer);
            }
            else{
                wr.write("#"+tc+" "+0);
            }

            if(tc != T){
                wr.newLine();
            }
            wr.flush();
        }
        rd.close();
        wr.close();
    }

    public static String[] passwordDivideEight(String password){
        String[] passwordStringArray = new String[8];
        int lastIndex = password.lastIndexOf("1");
        int firstIndex = lastIndex-55;
        for(int i = 0; i < 8; i++){
            passwordStringArray[i] = password.substring(firstIndex+(i*7),firstIndex+(i+1)*7);
        }
        return passwordStringArray;
    }

    // 비트 분리 메서드
    public static int bitToNumber(String passwordBit){
        String[] bit = new String[]{"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
        for(int i = 0 ; i < 10; i++){
            if(passwordBit.equals(bit[i])){
                return i;
            }
        }
        return -1;
    }

}