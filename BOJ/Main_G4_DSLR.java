package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// DSLR(https://www.acmicpc.net/problem/9019)
public class Main_G4_DSLR {

    public static boolean[] visit;
    public static String[] dslrValue;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(rd.readLine());
        for(int i = 0; i < T; i++){
            String[] AB = (rd.readLine()).split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            visit = new boolean[10000];
            dslrValue = new String[10000];
            wr.write(bfs(A,B)+"\n");
            wr.flush();
        }


    }

    public static int D(int num){
        if(num*2 > 9999){
            return (num * 2) % 10000;
        }
        return num*2;
    }

    public static int S(int num){
        if(num-1 < 0){
            return 9999;
        }
        return num-1;
    }

    public static int L(int num){
        return (num % 1000) * 10 + (num / 1000);
    }

    public static int R(int num){
        return (num%10) * 1000 + (num/10);
    }

    public static String bfs(int start, int target){
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.offer(start);
        dslrValue[start] = "";
        while(!q.isEmpty()){
            int value = q.poll();
            if(target == value){
                return dslrValue[value];
            }
            if(!visit[D(value)]){
                visit[D(value)] = true;
                q.offer(D(value));
                dslrValue[D(value)] = dslrValue[value] + "D";
            }
            if(!visit[S(value)]){
                visit[S(value)] = true;
                q.offer(S(value));
                dslrValue[S(value)] = dslrValue[value] + "S";
            }
            if(!visit[L(value)]){
                visit[L(value)] = true;
                q.offer(L(value));
                dslrValue[L(value)] = dslrValue[value] + "L";
            }
            if(!visit[R(value)]){
                visit[R(value)] = true;
                q.offer(R(value));
                dslrValue[R(value)] = dslrValue[value] + "R";
            }
        }
        return "X";
    }
}