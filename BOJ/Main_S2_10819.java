package ProblemSolving.BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// 차이를 최대로 (https://www.acmicpc.net/problem/10819)
public class Main_S2_10819 {

    public static int N, answer;
    public static int[] intArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        N = Integer.parseInt(br.readLine());
        String[] array = (br.readLine()).split(" ");
        intArray = new int[N];
        for (int i = 0; i < N; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        // solve
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            numberList.add(intArray[i]);
        }
        int[] recurArray = new int[N];
        recur(recurArray, numberList, 0);

        // output
        bw.write(answer + "");
        bw.flush();

    }

    private static void recur(int[] array, List<Integer> list, int count) {
        if (count == N) {
            int result = calculate(array);
            answer = Math.max(answer, result);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            array[count] = list.get(i);
            List<Integer> recurList = new ArrayList<>(list);
            recurList.remove(i);
            recur(array, recurList, count + 1);
        }

    }

    private static int calculate(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length - 1; i++) {
            result += Math.abs(array[i] - array[i + 1]);
        }
        return result;
    }
}

