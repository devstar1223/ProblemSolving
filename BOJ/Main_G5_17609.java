package ProblemSolving.BOJ;

import java.io.*;

public class Main_G5_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();

            bw.write(palindrome(s)+"");
            if(tc != T-1){
                bw.newLine();
            }

        }

        bw.flush();
    }

    public static int palindrome(String string){
        int left = 0;
        int right = string.length()-1;

        while(left < right){
            if(string.charAt(left) == string.charAt(right)){
                left++;
                right--;
                continue;
            }

            if(pseudoPalindrome(string, left+1,right)){
                return 1;
            }
            if(pseudoPalindrome(string, left,right-1)){
                return 1;
            }

            return 2;
        }
        return 0;
    }

    public static boolean pseudoPalindrome(String s,int left, int right){
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
                continue;
            }

            return false;
        }
        return true;
    }
}
