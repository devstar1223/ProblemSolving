package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 톱니바퀴(https://www.acmicpc.net/problem/14891)
public class Main_G5_14891 {

    static List<List<Integer>> wheelList;
    static int[] rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        wheelList = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            List<Integer> wheel = new ArrayList<>();

            String[] line = br.readLine().split("");
            for(String s : line){
                wheel.add(Integer.parseInt(s));
            }

            wheelList.add(wheel);
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            String[] ND = (br.readLine()).split(" ");
            int N = Integer.parseInt(ND[0]) - 1;
            int D = Integer.parseInt(ND[1]);
            rotate = new int[4];
            checkLeft(N,D);
            checkRight(N,D);
            rotate[N] = D;
            for(int j = 0; j < 4; j++){
                if(rotate[j] != 0){
                    rotate(j,rotate[j]);
                }
            }
        }

        bw.write(score()+"");
        bw.flush();
    }

    public static void checkLeft(int wheelNumber,int direction){
        if(wheelNumber == 0){
            return;
        }
        int left = wheelNumber-1;
        List<Integer> wheel = wheelList.get(wheelNumber);
        List<Integer> leftWheel = wheelList.get(left);
        if(wheel.get(6) != leftWheel.get(2)){
            rotate[left] = -1 * direction;
            checkLeft(left,-1*direction);
        }
    }

    public static void checkRight(int wheelNumber,int direction){
        if(wheelNumber == 3){
            return;
        }
        int right = wheelNumber+1;
        List<Integer> wheel = wheelList.get(wheelNumber);
        List<Integer> rightWheel = wheelList.get(right);
        if(wheel.get(2) != rightWheel.get(6)){
            rotate[right] = -1 * direction;
            checkRight(right,-1*direction);
        }
    }

    public static void rotate(int N,int direction){
        List<Integer> wheel = wheelList.get(N);
        if(direction == 1){
            int tmp = wheel.get(7);
            wheel.remove(7);
            wheel.add(0,tmp);
            return;
        }
        int tmp = wheel.get(0);
        wheel.remove(0);
        wheel.add(tmp);
    }

    public static int score(){
        int score = 0;
        for(int i = 0; i < 4; i++){
            List<Integer> wheel = wheelList.get(i);
            if(wheel.get(0) == 1){
                score += (int) Math.pow(2,i);
            }
        }
        return score;
    }
}