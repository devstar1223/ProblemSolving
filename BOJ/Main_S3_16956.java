package ProblemSolving.BOJ;

import java.io.*;

// 늑대와 양 (https://www.acmicpc.net/problem/16956)
public class Main_S3_16956 {

    public static String[][] ground;
    public static int R,C;
    public static int[] dy = {1,-1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NC = (br.readLine()).split(" ");
        R = Integer.parseInt(NC[0]);
        C = Integer.parseInt(NC[1]);

        ground = new String[R][C];

        for(int i = 0; i < R; i++){
            String[] line = (br.readLine()).split("");
            for(int j = 0; j < C; j++){
                if(line[j].equals(".")){
                    ground[i][j] = "D";
                }else{
                    ground[i][j] = line[j];
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(ground[i][j].equals("W")){
                    if(zeroCheck(i,j)){
                        bw.write("0");
                        bw.flush();
                        return;
                    }
                }
            }
        }

        bw.write(1+"\n");
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                bw.write(ground[i][j]);
            }
            if(i != R-1){
                bw.newLine();
            }
        }
        bw.flush();
    }

    public static boolean zeroCheck(int y, int x){

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && nx >= 0 && ny < R && nx < C){
                if(ground[ny][nx].equals("S")){
                    return true;
                }
            }
        }

        return false;
    }
}

