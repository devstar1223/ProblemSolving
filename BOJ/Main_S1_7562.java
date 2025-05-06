package ProblemSolving.ProblemSolving.BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 나이트의 이동(https://www.acmicpc.net/problem/7562)
public class Main_S1_7562 {

    public static int[] dy = new int[]{-2,-1,1,2,-2,-1,1,2};
    public static int[] dx = new int[]{1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int len = Integer.parseInt(br.readLine());

            String[] startStringArray = (br.readLine()).split(" ");
            int startY = Integer.parseInt(startStringArray[0]);
            int startX = Integer.parseInt(startStringArray[1]);

            String[] arrivalStringArray = (br.readLine()).split(" ");
            int arrivalY = Integer.parseInt(arrivalStringArray[0]);
            int arrivalX = Integer.parseInt(arrivalStringArray[1]);

            int answer = bfs(len,startY,startX,arrivalY,arrivalX);
            bw.write(answer+"");
            if(i != T-1){
                bw.newLine();
            }
        }
        bw.flush();
    }

    private static int bfs(int len, int startY, int startX, int arrivalY, int arrivalX){
        int[][] ground = new int[len][len];
        boolean[][] visited = new boolean[len][len];

        ground[arrivalY][arrivalX] = 1;
        visited[startY][startX] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startY,startX});

        int count = 0;

        while(!q.isEmpty()){
            int qLen = q.size();
            for(int i = 0; i < qLen; i++){
                int currentY = q.peek()[0];
                int currentX = q.poll()[1];

                if(currentY == arrivalY && currentX == arrivalX){
                    return count;
                }

                for(int j = 0; j < 8; j++){
                    int ny = currentY + dy[j];
                    int nx = currentX + dx[j];
                    if(ny >= 0 && nx >= 0 && ny < len && nx < len && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                    }
                }
            }
            count++;
        }

        return -1;
    }
}
