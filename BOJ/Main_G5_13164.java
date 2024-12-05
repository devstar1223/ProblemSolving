package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 행복 유치원(https://www.acmicpc.net/problem/13164)
public class Main_G5_13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NK = (rd.readLine()).split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] kidString = (rd.readLine()).split(" ");
        int[] kidArray = new int[N];
        for(int i = 0; i < N; i++){
            kidArray[i] = Integer.parseInt(kidString[i]);
        }

        int[][] diff = new int[N][2]; // [N][0]은 값, [N][1] 는 본래의 인덱스
        diff[0][0] = 0;
        diff[0][1] = 0;
        for(int i = 1; i < N; i++){
            diff[i][0] = kidArray[i] - kidArray[i-1];
            diff[i][1] = i;
        }
        Arrays.sort(diff,(a,b) -> Integer.compare(b[0],a[0]));

        List<Integer> indexList = new ArrayList<>();
        for(int i = 0; i < K-1; i++){
            indexList.add(diff[i][1]);
        }
        Collections.sort(indexList);

        int startIndex = 0;
        int answer = 0;

        for(int i = 0; i < indexList.size(); i++){
            answer += kidArray[indexList.get(i)-1] - kidArray[startIndex];
            startIndex = indexList.get(i);
        }
        answer += kidArray[kidArray.length-1] - kidArray[startIndex];
        wr.write(answer+"");
        wr.flush();
    }
}
