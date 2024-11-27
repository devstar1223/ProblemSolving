package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 파닭파닭(https://www.acmicpc.net/problem/14627)
public class Main_S2_14627 {

    public static List<Integer> list;
    public static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        // init
        String[] SC = (rd.readLine()).split(" ");
        int S = Integer.parseInt(SC[0]);
        C = Integer.parseInt(SC[1]);
        list = new ArrayList<>();
        int maxLength = -1;
        long totalSLength = 0; // 모든 파의 길이 합
        for(int i = 0; i < S; i++){
            int sLength = Integer.parseInt(rd.readLine());
            list.add(sLength);
            maxLength = Math.max(maxLength,sLength);
            totalSLength += sLength;
        }

        int possibleMaxLength = BinarySearch(maxLength);

        totalSLength -= (long) C * possibleMaxLength;

        wr.write(totalSLength+"");
        wr.flush();
    }

    // 파의 가능한 최대 길이를 반환한다.
    public static int BinarySearch(int max){
        int left = 1;
        int right = max;
        int mid = (left+right)/2;
        while(left <= right){
            if(everyChickenOk(mid)){
                left = mid+1;
            }else{
                right = mid-1;
            }
            mid = (left+right)/2;
        }

        return mid;
    }

    // 모든 치킨에 파를 뿌릴수 있는지 체크한다.
    public static boolean everyChickenOk(int sLength){
        int count = 0;
        for(int i : list){
            count += (i / sLength);
        }
        return count >= C;
    }
}