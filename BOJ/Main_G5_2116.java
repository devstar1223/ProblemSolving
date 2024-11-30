package ProblemSolving.BOJ;

import java.io.*;

// 주사위 쌓기(https://www.acmicpc.net/problem/2116)
public class Main_G5_2116 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        int[][] dice = new int[N][6];
        for(int i = 0; i < N; i++){
            String[] diceString = (rd.readLine()).split(" ");
            for(int j = 0; j < 6; j++){
                dice[i][j] = Integer.parseInt(diceString[j]);
            }
        }

        int[] answer = new int[6];
        int[] couple = new int[]{5,3,4,1,2,0};
        int[][] side = new int[][]{{1,2,3,4},{0,2,4,5},{0,1,3,5},{0,2,4,5},{0,1,3,5},{1,2,3,4}};

        // 위-아래 쌍 : 0-5 / 1-3 / 2-4
        for(int i = 0; i < 6; i++){
            int next = couple[i]; // 0번째의 수, 이니까 첫 주사위는 다섯번째 수를 뺀다. next 는 5(번째)

            for(int j = 0; j < dice.length; j++){

                int max = 0;
                for(int value : side[next]){ // 0과 5가 빠진 5번째 사이드에서 수를 받아오자!
                    max = Math.max(max,dice[j][value]);
                }

                answer[i] += max;

                if(j != dice.length-1){ // 마지막이 아니면
                    for(int k = 0; k < 6; k++){
                        if(dice[j+1][k] == dice[j][next]){ // 윗 주사위의값이, 현재 주사위의 5번째 값과 같다면.
                            next = couple[k]; // 그 주사위 인덱스에 맞는 인덱스가 다음 이다.
                            break;
                        }
                    }
                }

            }
        }
        int answerMax = 0;
        for(int i : answer){
            answerMax = Math.max(answerMax,i);
        }
        wr.write(answerMax+"");
        wr.flush();
    }
}