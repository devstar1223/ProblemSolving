package ProblemSolving.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//흙길 보수하기(https://www.acmicpc.net/problem/1911)
public class Main_G5_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NL = (br.readLine()).split(" ");
        int N = Integer.parseInt(NL[0]);
        int L = Integer.parseInt(NL[1]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] line = (br.readLine()).split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            list.add(new int[]{start, end});
        }
        list.sort((a, b) -> Integer.compare(a[0], b[0]));
        int limit = list.get(list.size() - 1)[1]; // 이 부분부터 웅덩이 없음

        Queue<int[]> q = new LinkedList<>(list);

        int count = 0;
        int startIndex = q.peek()[0];
        int endIndex = q.peek()[1];

        while (startIndex < limit) {

            count++; // 개수 세기
            startIndex += L; // 널빤지 덮기
            if (startIndex >= endIndex) { // 현재 웅덩이 전부 덮었음
                while (!q.isEmpty()) {
                    int nextStart = q.peek()[0];
                    int nextEnd = q.poll()[1];

                    if (startIndex < nextEnd) {
                        startIndex = Math.max(startIndex, nextStart);
                        endIndex = nextEnd;
                        break;
                    }
                }
            }
        }

        bw.write(count+"");
        bw.flush();
    }
}
