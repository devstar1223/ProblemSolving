package ProblemSolving.BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 보물섬 (https://www.acmicpc.net/problem/2589)
public class Main_G5_2589 {

    public static String[][] ground;
    public static int Y, X;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //input
        String[] YX = br.readLine().split(" ");
        Y = Integer.parseInt(YX[0]);
        X = Integer.parseInt(YX[1]);

        ground = new String[Y][X];

        for (int i = 0; i < Y; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                ground[i][j] = line[j];
            }
        }

        //solve
        int answer = 0;

        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (ground[i][j].equals("L")) {
                    answer = Math.max(answer, bfs(i, j)-1);
                }
            }
        }

        //output
        bw.write(answer + "");
        bw.flush();
    }

    private static int bfs(int y, int x) {
        int count = 0;
        boolean[][] visited = new boolean[Y][X];
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int currentY = q.peek()[0];
                int currentX = q.poll()[1];

                for (int j = 0; j < 4; j++) {
                    int ny = currentY + dy[j];
                    int nx = currentX + dx[j];
                    if (ny >= 0 && nx >= 0 && ny < Y && nx < X && ground[ny][nx].equals("L") && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                }

            }

            count++;
        }
        return count;
    }
}

