package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 물통(https://www.acmicpc.net/problem/2251)
public class Main_G4_2251 {

    static boolean[][][] visited;
    static Set<Integer> set;
    static int[] bottleWater,bottleLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ABC = (br.readLine()).split(" ");
        int a = Integer.parseInt(ABC[0]);
        int b = Integer.parseInt(ABC[1]);
        int c = Integer.parseInt(ABC[2]);

        visited = new boolean[a+1][b+1][c+1];
        set = new HashSet<>();

        bottleLimit = new int[]{a,b,c};
        bottleWater = new int[]{0,0,c};

        dfs(bottleWater[0],bottleWater[1],bottleWater[2]);

        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++){
            if(i != answer.size()-1){
                bw.write(answer.get(i)+" ");
            }
            else{
                bw.write(answer.get(i)+"");
            }
        }
        bw.flush();
    }

    private static void dfs(int a, int b, int c){
        if(visited[a][b][c]){
            return;
        }

        visited[a][b][c] = true;

        if(a == 0){
            set.add(c);
        }

        // a -> b
        int move = pour(a,b,bottleLimit[1]);
        dfs(a-move,b+move,c);

        // a -> c
        move = pour(a,c,bottleLimit[2]);
        dfs(a-move,b,c+move);

        // b -> a
        move = pour(b,a,bottleLimit[0]);
        dfs(a+move,b-move,c);

        // b -> c
        move = pour(b,c,bottleLimit[2]);
        dfs(a,b-move,c+move);

        // c -> a
        move = pour(c,a,bottleLimit[0]);
        dfs(a+move,b,c-move);

        // c -> b
        move = pour(c,b,bottleLimit[1]);
        dfs(a,b+move,c-move);
    }

    // 옮길 물의 양
    private static int pour(int giveWater, int takeWater, int takeWaterLimit){
        if(giveWater+takeWater > takeWaterLimit){
            return takeWaterLimit - takeWater;
        }
        return giveWater;
    }
}
