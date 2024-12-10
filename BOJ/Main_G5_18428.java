package ProblemSolving.BOJ;

import java.io.*;

// 감시 피하기(https://www.acmicpc.net/problem/18428)
public class Main_G5_18428 {

    public static boolean possible;
    public static int[] dr = new int[]{1,-1,0,0};
    public static int[] dc = new int[]{0,0,-1,1};
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(rd.readLine());
        String[][] ground = new String[N][N];
        for(int i = 0; i < N; i++){
            String[] tmp = (rd.readLine()).split(" ");
            for(int j = 0; j < N; j++){
                ground[i][j] = tmp[j];
            }
        }
        install(ground,0);
        if(possible){
            wr.write("YES");
        }else{
            wr.write("NO");
        }
        wr.flush();
    }

    private static void install(String[][] ground, int count) {
        if(count == 3){
            if(possibleCheck(ground)){
                possible = true;
            }
            return;
        }
        for(int i = 0; i < ground.length; i++){
            for(int j = 0; j < ground.length; j++){
                if(ground[i][j].equals("X")){
                    ground[i][j] = "O";
                    install(ground,count+1);
                    ground[i][j] = "X";
                }
            }
        }
    }

    private static boolean possibleCheck(String[][] ground) {
        for(int i = 0; i < ground.length; i++){
            for(int j = 0; j < ground.length; j++){
                if(ground[i][j].equals("S")){
                    if(gazeCheck(i,j,ground)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean gazeCheck(int r, int c, String[][] ground) {
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            while(nr >= 0 && nc >= 0 && nr < N && nc < N && !ground[nr][nc].equals("O")){
                if(ground[nr][nc].equals("T")){
                    return true;
                }
                nr += dr[i];
                nc += dc[i];
            }
        }
        return false;
    }
}
