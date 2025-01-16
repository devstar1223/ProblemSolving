package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// ACN Craft(https://www.acmicpc.net/problem/1005)
public class Main_G3_1005 {

    static HashMap<Integer,List<Integer>> preBuildInfoMap = new HashMap<>();
    static int[] buildTimeInfo;
    static int[] alreadyBuildTimeInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            preBuildInfoMap.clear();
            String[] NK = br.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);
            String[] buildTimeInfoTmp = br.readLine().split(" ");
            buildTimeInfo = new int[N+1];
            alreadyBuildTimeInfo = new int[N+1];
            Arrays.fill(alreadyBuildTimeInfo,-1);
            for(int i = 1; i < N+1; i++){
                buildTimeInfo[i] = Integer.parseInt(buildTimeInfoTmp[i-1]);
            }
            for(int i = 0; i < K; i++){
                String[] preBuildInfo = br.readLine().split(" ");
                int preBuild = Integer.parseInt(preBuildInfo[0]);
                int build = Integer.parseInt(preBuildInfo[1]);
                List<Integer> preBuildList = preBuildInfoMap.getOrDefault(build,new ArrayList<>());
                preBuildList.add(preBuild);
                preBuildInfoMap.put(build,preBuildList);
            }
            int W = Integer.parseInt(br.readLine());
            if(tc != T-1){
                bw.write(build(W)+"\n");
            }else{
                bw.write(build(W)+"");
            }
        }
        bw.flush();
    }

    public static int build(int number){
        int time = 0;

        List<Integer> preBuildList = preBuildInfoMap.get(number);
        if(preBuildList == null){
            alreadyBuildTimeInfo[number] = buildTimeInfo[number];
            return buildTimeInfo[number];
        }

        for(int preBuildNumber : preBuildList){
            if(alreadyBuildTimeInfo[preBuildNumber] == -1){
                alreadyBuildTimeInfo[preBuildNumber] = build(preBuildNumber);
            }
            time = Math.max(time,alreadyBuildTimeInfo[preBuildNumber]);
        }

        time += buildTimeInfo[number];

        return time;
    }
}