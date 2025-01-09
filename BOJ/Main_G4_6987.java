package ProblemSolving.BOJ;

import java.io.*;

// 월드컵(https://www.acmicpc.net/problem/6987)
public class Main_G4_6987 {

    static int[][] countryWDLInfo;
    static int[][] fightResult = new int[][]{{0,2},{1,1},{2,0}}; // 승무패

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int tc = 0; tc < 4; tc++){
            String[] tmp = (br.readLine()).split(" ");
            countryWDLInfo = new int[6][3]; // 나라별 승,무,패
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    countryWDLInfo[i][j] = Integer.parseInt(tmp[i*3+j]);
                }
            }
            int[][] newWDLInfo = new int[6][3];
            if(recur(0,1,newWDLInfo)){
                bw.write("1");
            }else{
                bw.write("0");
            }
            if(tc != 3){
                bw.write(" ");
            }
        }

        bw.flush();
    }

    public static boolean recur(int country, int enemy,int[][] newWDLInfo){
        if(newWDLInfo[country][0] > countryWDLInfo[country][0] || newWDLInfo[country][1] > countryWDLInfo[country][1] || newWDLInfo[country][2] > countryWDLInfo[country][2]){
            return false;
        }

        if(country == 5){
            for(int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (newWDLInfo[i][j] != countryWDLInfo[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        for(int i = 0; i < 3; i++){
            newWDLInfo[country][fightResult[i][0]] += 1;
            newWDLInfo[enemy][fightResult[i][1]] += 1;

            if(enemy == 5){
                if(recur(country+1,country+2,newWDLInfo)){
                    return true;
                }
            }else{
                if(recur(country,enemy+1,newWDLInfo)){
                    return true;
                }
            }

            newWDLInfo[country][fightResult[i][0]] -= 1;
            newWDLInfo[enemy][fightResult[i][1]] -= 1;
        }

        return false;
    }
}