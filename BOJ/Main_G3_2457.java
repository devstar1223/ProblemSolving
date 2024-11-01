package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 공주님의 정원(https://www.acmicpc.net/problem/2457)
public class Main_G3_2457 {
    public final static int[] MONTH_LAST_DAY = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int N = Integer.parseInt(rd.readLine());
        List<int[]> flowerList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] MD = (rd.readLine()).split(" ");
            int flowerStartMonth = Integer.parseInt(MD[0]);
            int flowerStartDay = Integer.parseInt(MD[1]);
            int flowerEndMonth = Integer.parseInt(MD[2]);
            int flowerEndDay = Integer.parseInt(MD[3]);
            int[] flower = new int[2];
            flower[0] = dayConvert(flowerStartMonth,flowerStartDay); // 개화일(환산)
            flower[1] = dayConvert(flowerEndMonth,flowerEndDay); // 낙화일(환산)
            flowerList.add(flower);
        }

        // solve
        int answer = 0;
        flowerList.sort(Comparator.comparingInt(a -> a[0])); // 개화일 기준 정렬
        int today = dayConvert(3,1);
        int endDay = dayConvert(11,30);
        int flowerIndex = 0;
        while(today <= endDay){
            int flowerEnd = today;
            for(int i = flowerIndex; i < flowerList.size(); i++){
                if(flowerList.get(i)[0] > today){ // 이 꽃의 개화일이 미래
                    flowerIndex = i;
                    break;
                }
                flowerEnd = Math.max(flowerList.get(i)[1], flowerEnd);
            }
            if(flowerEnd == today){ // 꽃 유지 실패
                answer = 0;
                break;
            }
            answer++;
            today = flowerEnd;
        }

        // out
        wr.write(answer+"");
        wr.flush();
    }

    public static int dayConvert(int month, int day){ // 1월 1일은 1, 12월 31일은 365
        int convertDay = 0;
        for(int i = 1; i < month; i++){
            convertDay += MONTH_LAST_DAY[i];
        }
        convertDay += day;
        return convertDay;
    }
}