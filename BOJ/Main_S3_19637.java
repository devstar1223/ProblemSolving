package ProblemSolving.BOJ;

import java.io.*;

// IF문 좀 대신 써줘(https://www.acmicpc.net/problem/19637)
public class Main_S3_19637 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        String[] NM = (rd.readLine()).split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] powerLimit = new int[N];
        String[] powerName = new String[N];
        for(int i = 0; i < N; i++){
            String[] tmp = (rd.readLine()).split(" ");
            powerLimit[i] = Integer.parseInt(tmp[1]);
            powerName[i] = tmp[0];
        }

        // solve
        for(int i = 0; i < M; i++){
            int power = Integer.parseInt(rd.readLine());
            int index = binarySearch(power,powerLimit);
            wr.write(powerName[index]+"\n");
        }

        // out
        wr.flush();
    }

    public static int binarySearch(int power, int[] powerLimit) {
        int left = 0;
        int right = powerLimit.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (powerLimit[mid] < power) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}