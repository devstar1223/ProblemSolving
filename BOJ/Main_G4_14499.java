package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//주사위 굴리기(https://www.acmicpc.net/problem/14499)
public class Main_G4_14499 {

    static int[] dy = {0,0,0,-1,1};
    static int[] dx = {0,1,-1,0,0};
    static int[][] ground;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NMXYK = (br.readLine()).split(" ");
        N = Integer.parseInt(NMXYK[0]); // 지도 세로
        M = Integer.parseInt(NMXYK[1]); // 지도 가로

        ground = new int[N][M];

        int X = Integer.parseInt(NMXYK[2]); // 주사위 좌표 x
        int Y = Integer.parseInt(NMXYK[3]); // 주사위 좌표 y

        // 지도 정보
        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split(" ");
            for(int j = 0; j < M; j++){
                ground[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 명령 정보
        Queue<Integer> commandQueue = new LinkedList<>();
        String[] line = (br.readLine()).split(" ");
        for(String command : line){
            commandQueue.add(Integer.parseInt(command));
        }

        Dice dice = new Dice();
        dice.mapIndexSet(X,Y);

        while(!commandQueue.isEmpty()){
            dice.roll(commandQueue.poll());
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
    }

    private static class Dice{
        int[] diceStatus = new int[6];

        int diceHeadIndex = 0;
        int diceFloorIndex = 5;
        int diceRightIndex = 2;
        int diceLeftIndex = 3;
        int diceUpIndex = 1;
        int diceDownIndex = 4;

        int diceMapIndexY = -1;
        int diceMapIndexX = -1;

        public void mapIndexSet(int y, int x){
            this.diceMapIndexY = y;
            this.diceMapIndexX = x;
        }

        public void roll(int direction){
            int ny = diceMapIndexY + dy[direction];
            int nx = diceMapIndexX + dx[direction];

            if(ny < 0 || nx < 0 || ny >= N || nx >= M){
                return;
            }

            mapIndexSet(ny,nx);
            diceStatusChange(direction);
            mapInteraction();
            sb.append(diceStatus[diceHeadIndex]).append("\n");
        }

        private void diceStatusChange(int direction) {
            int tmp1 = 0;
            int tmp2 = 0;
            if(direction == 1){
                tmp1 = diceRightIndex;
                tmp2 = diceLeftIndex;

                diceRightIndex = diceHeadIndex;
                diceLeftIndex = diceFloorIndex;
            }
            if(direction == 2){
                tmp1 = diceLeftIndex;
                tmp2 = diceRightIndex;

                diceLeftIndex = diceHeadIndex;
                diceRightIndex = diceFloorIndex;
            }
            if(direction == 3){
                tmp1 = diceUpIndex;
                tmp2 = diceDownIndex;

                diceUpIndex = diceHeadIndex;
                diceDownIndex = diceFloorIndex;
            }
            if(direction == 4){
                tmp1 = diceDownIndex;
                tmp2 = diceUpIndex;

                diceDownIndex = diceHeadIndex;
                diceUpIndex = diceFloorIndex;
            }

            diceFloorIndex = tmp1;
            diceHeadIndex = tmp2;
        }

        public void mapInteraction(){
            int mapValue = ground[diceMapIndexY][diceMapIndexX];
            int diceValue = diceStatus[diceFloorIndex];

            if(mapValue == 0){
                ground[diceMapIndexY][diceMapIndexX] = diceValue;
                return;
            }

            diceStatus[diceFloorIndex] = mapValue;
            ground[diceMapIndexY][diceMapIndexX] = 0;
        }
    }
}