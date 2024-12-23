package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 미로 탈출(https://www.acmicpc.net/problem/14923)
public class Main_G4_14923 {

    public static int N,M,startY,startX,endY,endX;
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1};
    public static int[][] ground;
    public static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM =(br.readLine()).split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        ground = new int[N+1][M+1];
        visit = new boolean[N+1][M+1][2];

        String[] startYX =(br.readLine()).split(" ");
        startY = Integer.parseInt(startYX[0]);
        startX = Integer.parseInt(startYX[1]);

        String[] endYX =(br.readLine()).split(" ");
        endY = Integer.parseInt(endYX[0]);
        endX = Integer.parseInt(endYX[1]);

        for(int i = 1; i <= N; i++){
            String[] tmp = (br.readLine()).split(" ");
            for(int j = 1; j <= M; j++){
                ground[i][j] = Integer.parseInt(tmp[j-1]);
            }
        }

        int answer = bfs(new Node(startY,startX,0,false));
        bw.write(answer+"");
        bw.flush();
    }

    private static int bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                Node currentNode = q.poll();
                if(currentNode.getY() == endY && currentNode.getX() == endX){
                    return currentNode.getCount();
                }
                for(int j = 0; j < 4; j++){
                    int ny = currentNode.getY() + dy[j];
                    int nx = currentNode.getX() + dx[j];
                    if(ny > 0 && nx > 0 && ny <= N && nx <= M){
                        if(ground[ny][nx] == 0){
                            if(!currentNode.isBreakWall() && !visit[ny][nx][0]){
                                visit[ny][nx][0] = true;
                                q.add(new Node(ny,nx, currentNode.getCount()+1, false));
                            }
                            else if(currentNode.isBreakWall() && !visit[ny][nx][1]){
                                visit[ny][nx][1] = true;
                                q.add(new Node(ny,nx, currentNode.getCount()+1, true));
                            }
                        }
                        else if(ground[ny][nx] == 1 && !currentNode.isBreakWall()){
                            visit[ny][nx][1] = true;
                            q.add(new Node(ny,nx, currentNode.getCount()+1, true));
                        }
                    }
                }
            }
        }
        return -1;
    }

    static class Node{

        public int y;
        public int x;
        public boolean breakWall;
        public int count;

        public Node(int y, int x, int count, boolean breakWall){
            this.y = y;
            this.x = x;
            this.count = count;
            this.breakWall = breakWall;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public boolean isBreakWall() {
            return breakWall;
        }

        public int getCount() {
            return count;
        }
    }
}