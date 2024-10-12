package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 이중 우선순위 큐(https://www.acmicpc.net/problem/7662)
public class Main_G4_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();
            int iCount = 0;
            int dCount = 0;
            int k = Integer.parseInt(br.readLine());

            int[] answer = new int[2];
            for (int j = 0; j < k; j++) {
                String[] tmp = br.readLine().split(" ");
                String command = tmp[0];
                int num = Integer.parseInt(tmp[1]);

                if (command.equals("I")) {
                    iCount++;
                    min.add(num);
                    max.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (num == 1 && iCount != dCount) {
                    dCount++;
                    while (!max.isEmpty()) {
                        int value = max.poll();
                        if (map.get(value) > 0) {
                            map.put(value, map.get(value) - 1);
                            break;
                        }
                    }
                } else if (num == -1 && iCount != dCount) {
                    dCount++;
                    while (!min.isEmpty()) {
                        int value = min.poll();
                        if (map.get(value) > 0) {
                            map.put(value, map.get(value) - 1);
                            break;
                        }
                    }
                }
            }

            while (!min.isEmpty()) {
                int value = min.poll();
                if (map.get(value) > 0) {
                    answer[0] = value;
                    break;
                }
            }

            if (min.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                while (!max.isEmpty()) {
                    int value = max.poll();
                    if (map.get(value) > 0) {
                        answer[1] = value;
                        break;
                    }
                }
                bw.write(answer[1] + " " + answer[0] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
