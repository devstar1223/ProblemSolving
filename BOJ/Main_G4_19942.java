package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 다이어트(https://www.acmicpc.net/problem/19942)
public class Main_G4_19942 {

    static int[][] food;
    static int[] requestValue;
    static int N;
    static int minCost = Integer.MAX_VALUE;
    static Map<Integer,List<String>> map = new HashMap<>();
    static Set<String> set = new HashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        String[] requestValueString = (br.readLine()).split(" ");
        int mp = Integer.parseInt(requestValueString[0]);
        int mf = Integer.parseInt(requestValueString[1]);
        int ms = Integer.parseInt(requestValueString[2]);
        int mv = Integer.parseInt(requestValueString[3]);

        requestValue = new int[]{mp,mf,ms,mv};

        food = new int[N][5];
        for(int i = 0; i < N; i++){
            String[] foodString = (br.readLine()).split(" ");
            food[i][0] = Integer.parseInt(foodString[0]);
            food[i][1] = Integer.parseInt(foodString[1]);
            food[i][2] = Integer.parseInt(foodString[2]);
            food[i][3] = Integer.parseInt(foodString[3]);
            food[i][4] = Integer.parseInt(foodString[4]);
        }

        int[] select = new int[N];
        Arrays.fill(select,1);
        foodSelect(select);

        if(minCost != Integer.MAX_VALUE){
            bw.write(minCost +"\n");
            List<String> answerList = map.get(minCost);
            Collections.sort(answerList);
            bw.write(answerList.get(0)+"");
        }else{
            bw.write(-1+"");
        }

        bw.flush();

    }

    private static void foodSelect(int[] select) {

        String selectString = arrayToString(select);
        set.add(selectString);

        // 음식의 총 합 영양소
        int[] foodValueSum = new int[5];

        for(int i = 0; i < N; i++){
            if(select[i] == 1){
                for(int j = 0; j < 5; j++){
                    foodValueSum[j] += food[i][j];
                }
            }
        }

        // 음식의 합이 최소 영양소보다 부족
        for(int i = 0; i < 4; i++){
            if(foodValueSum[i] < requestValue[i]){
                return;
            }
        }


        if(foodValueSum[4] <= minCost){
            minCost = foodValueSum[4];
            List<String> answerCombinationList = map.getOrDefault(minCost,new ArrayList<>());
            answerCombinationList.add(selectString);
            map.put(minCost,answerCombinationList);
        }

        for(int i = 0; i < N; i++){
            if(select[i] == 0){
                continue;
            }

            select[i] = 0;
            if(set.contains(arrayToString(select))){
                select[i] = 1;
                continue;
            }
            foodSelect(select);
            select[i] = 1;
        }
    }

    public static String arrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            if(array[i] == 1){
                sb.append(i+1).append(" ");
            }
        }
        if(sb.length() > 0){
            return sb.deleteCharAt(sb.length()-1).toString();
        }
        return sb.toString();
    }
}