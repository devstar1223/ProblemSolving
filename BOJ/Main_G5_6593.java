package ProblemSolving.BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

//상범 빌딩(https://www.acmicpc.net/problem/6593)
public class Main_G5_6593 {

    static String[][][] ground;
    static boolean[][][] visited;
    static int[] dl = new int[]{0, 0, 0, 0, 1, -1};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int LLimit, RLimit, CLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] LRC = (br.readLine()).split(" ");

            LLimit = Integer.parseInt(LRC[0]);
            RLimit = Integer.parseInt(LRC[1]);
            CLimit = Integer.parseInt(LRC[2]);

            if (LLimit == 0 && RLimit == 0 && CLimit == 0) {
                sb.deleteCharAt(sb.length() - 1);
                bw.write(sb.toString());
                bw.flush();
                break;
            }

            ground = new String[LLimit][RLimit][CLimit];
            visited = new boolean[LLimit][RLimit][CLimit];
            Integer[] startLRC = new Integer[3];

            for (int i = 0; i < LLimit; i++) {
                for (int j = 0; j < RLimit; j++) {
                    String[] line = (br.readLine()).split("");
                    for (int k = 0; k < CLimit; k++) {
                        ground[i][j][k] = line[k];
                        if (ground[i][j][k].equals("S")) {
                            startLRC[0] = i;
                            startLRC[1] = j;
                            startLRC[2] = k;
                        }
                    }
                }
                br.readLine();
            }

            int answer = bfs(startLRC);
            if (answer == -1) {
                sb.append("Trapped!");
            } else {
                sb.append("Escaped in " + answer + " minute(s).");
            }
            sb.append("\n");
        }

    }

    private static int bfs(Integer[] startLRC) {
        int count = 0;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(startLRC);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer[] LRC = q.poll();

                int L = LRC[0];
                int R = LRC[1];
                int C = LRC[2];

                if (ground[L][R][C].equals("E")) {
                    return count;
                }

                for (int j = 0; j < 6; j++) {
                    int nl = L + dl[j];
                    int ny = R + dy[j];
                    int nx = C + dx[j];
                    if (nl >= 0 && ny >= 0 && nx >= 0 && nl < LLimit && ny < RLimit && nx < CLimit && !visited[nl][ny][nx] && !ground[nl][ny][nx].equals("#")) {
                        Integer[] nLRC = new Integer[]{nl, ny, nx};
                        visited[nl][ny][nx] = true;
                        q.add(nLRC);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}