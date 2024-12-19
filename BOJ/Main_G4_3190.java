package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 뱀(https://www.acmicpc.net/problem/3190)
public class Main_G4_3190 {

    public static int[][] ground;
    public static boolean gameOver;
    public static int[] dy = new int[]{0,1,0,-1};
    public static int[] dx = new int[]{1,0,-1,0};
    public static int currentDirection = 0;
    public static int N;
    public static Deque<int[]> snakeYX = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(rd.readLine());
        ground = new int[N+1][N+1];
        int K = Integer.parseInt(rd.readLine());
        for(int i = 0; i < K; i++){
            String[] appleRc = (rd.readLine()).split(" ");
            int r = Integer.parseInt(appleRc[0]);
            int c = Integer.parseInt(appleRc[1]);
            ground[r][c] = 999;
        }
        int L = Integer.parseInt(rd.readLine());
        Queue<String[]> secondQueue = new LinkedList<>();
        for(int i = 0; i < L; i++){
            String[] secondDirection = (rd.readLine()).split(" ");
            secondQueue.add(secondDirection);
        }
        int second = 0;
        ground[1][1] = 1;
        snakeYX.addLast(new int[]{1,1});
        while(!gameOver){
            if(!secondQueue.isEmpty() && Integer.parseInt(secondQueue.peek()[0]) == second){ // 방향전환
                directionChange(secondQueue.poll()[1]);
            }
            second++;
            snakeMove(currentDirection);
        }
        wr.write(second+"");
        wr.flush();
    }

    public static void directionChange(String turnLR){
        if(turnLR.equals("D")){
            if(currentDirection == 3){
                currentDirection = 0;
            }else{
                currentDirection++;
            }
            return;
        }
        if(turnLR.equals("L")){
            if(currentDirection == 0){
                currentDirection = 3;
            }else{
                currentDirection--;
            }
        }
    }

    public static void snakeMove(int currentDirection){
        int ny = snakeYX.peekFirst()[0] + dy[currentDirection];
        int nx = snakeYX.peekFirst()[1] + dx[currentDirection];
        if(ny <= 0 || nx <= 0 || ny >= N+1 || nx >= N+1 || ground[ny][nx] == 1){
            gameOver = true;
            return;
        }

        if(ground[ny][nx] != 999){ // 사과가 없다.
            ground[snakeYX.peekLast()[0]][snakeYX.peekLast()[1]] = 0; // 꼬리를 자른다.
            snakeYX.pollLast();
        }

        ground[ny][nx] = 1; // 전진한 칸에 머리그리기.

        // 꼬리 위치 재설정
        snakeYX.addFirst(new int[]{ny,nx});
    }
}