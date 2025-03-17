package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 레이저 통신(https://www.acmicpc.net/problem/6087)
public class Main_G3_6087 {

    static String[][] ground;
    static boolean[][] visited;
    // 상우하좌
    static int[] dy = new int[]{-1,0,1,0};
    static int[] dx = new int[]{0,1,0,-1};

    static int W,H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] WH = (br.readLine()).split(" ");
        W = Integer.parseInt(WH[0]);
        H = Integer.parseInt(WH[1]);
        ground = new String[H][W];
        Queue<int[]> pointQueue = new LinkedList<>();
        for(int i = 0; i < H; i++){
            String[] row = (br.readLine()).split("");
            for(int j = 0; j < W; j++){
                ground[i][j] = row[j];
                if(ground[i][j].equals("C")){
                    pointQueue.add(new int[]{i,j});
                }
            }
        }

        bw.write(zeroOneBfs(pointQueue)+"");
        bw.flush();

    }
    private static int zeroOneBfs(Queue<int[]> pointQueue){
        int[][] distanceInfo = new int[H][W];
        for(int[] array : distanceInfo){
            Arrays.fill(array,Integer.MAX_VALUE);
        }

        int[] startIndex = pointQueue.poll();
        int startY = startIndex[0];
        int startX = startIndex[1];

        Deque<Node> deque = new LinkedList<>();

        for(int i = 0; i < 4; i++){
            int ny = startY + dy[i];
            int nx = startX + dx[i];
            if(ny >= 0 && nx >= 0 && ny < H && nx < W && !ground[ny][nx].equals("*")){
                deque.add(new Node(ny,nx,i,0));
            }
        }

        int[] endIndex = pointQueue.poll();
        int endY = endIndex[0];
        int endX = endIndex[1];


        while(!deque.isEmpty()){
            Node pollNode = deque.pollFirst();
            distanceInfo[pollNode.y][pollNode.x] = pollNode.count;
            if(pollNode.y == endY && pollNode.x == endX){
                return pollNode.count;
            }

            //정방향 넣기
            int ny = pollNode.y + dy[pollNode.direction];
            int nx = pollNode.x + dx[pollNode.direction];
            if(ny >= 0 && nx >= 0 && ny < H && nx < W && !ground[ny][nx].equals("*") && pollNode.count < distanceInfo[ny][nx]){
                deque.addFirst(new Node(ny,nx,pollNode.direction,pollNode.count));
            }

            //오른쪽 넣기
            int rightDirection = turnRight(pollNode.direction);
            ny = pollNode.y + dy[rightDirection];
            nx = pollNode.x + dx[rightDirection];
            if(ny >= 0 && nx >= 0 && ny < H && nx < W && !ground[ny][nx].equals("*") && pollNode.count+1 < distanceInfo[ny][nx]){
                deque.addLast(new Node(ny,nx,rightDirection,pollNode.count+1));
            }

            //왼쪽 넣기
            int leftDirection = turnLeft(pollNode.direction);
            ny = pollNode.y + dy[leftDirection];
            nx = pollNode.x + dx[leftDirection];
            if(ny >= 0 && nx >= 0 && ny < H && nx < W && !ground[ny][nx].equals("*") && pollNode.count+1 < distanceInfo[ny][nx]){
                deque.addLast(new Node(ny,nx,leftDirection,pollNode.count+1));
            }
        }

        return -1;
    }

    private static class Node{
        public int y;
        public int x;
        public int direction;
        public int count;

        public Node(int y, int x, int direction, int count) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.count = count;
        }
    }

    private static int turnRight(int direction){
        if(direction == 3){
            return 0;
        }
        return direction+1;
    }

    private static int turnLeft(int direction){
        if(direction == 0){
            return 3;
        }
        return direction-1;
    }
}