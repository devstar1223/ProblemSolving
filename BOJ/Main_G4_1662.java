package ProblemSolving.BOJ;

import java.io.*;

// 압축(https://www.acmicpc.net/problem/1662)
public class Main_G4_1662 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = rd.readLine();
        wr.write(recur(s)+"");
        wr.flush();
    }

    public static int findRightPIndex(int leftPIndex,String s){
        int left = 1;
        int right = 0;
        int index = leftPIndex;
        while(left != right){
            index++;
            if(s.charAt(index) == '('){
                left++;
            }else if(s.charAt(index) == ')'){
                right++;
            }
        }
        return index;
    }

    public static int recur(String s){
        int answer = 0;
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index) == '('){
                answer -= 1;
                int rightPIndex = findRightPIndex(index,s);
                int left = Character.getNumericValue(s.charAt(index-1));
                answer += left * recur(s.substring(index+1,rightPIndex));
                index = rightPIndex+1;
            }else{
                answer++;
                index++;
            }
        }
        return answer;
    }
}
