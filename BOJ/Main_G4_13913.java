package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 숨바꼭질 4(https://www.acmicpc.net/problem/13913)
public class Main_G4_13913 {

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NK = (br.readLine()).split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        visit = new boolean[110000];
        List<Integer> answerRouteList = bfs(N,K);
        int len = answerRouteList.size();
        bw.write(len-1+"\n");
        for(int i = len-1; i >= 0; i--){
            if(i != 0){
                bw.write(answerRouteList.get(i)+" ");
            }
            else{
                bw.write(answerRouteList.get(i)+"");
            }
        }
        bw.flush();
    }

    private static List<Integer> bfs(int n, int k) {
        int[] parent = new int[110000];
        Arrays.fill(parent,-1);
        Queue<Integer> q = new LinkedList<>();
        visit[n] = true;
        q.add(n);

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){

                int currentNumber = q.poll();

                if(currentNumber == k){
                    List<Integer> list = new ArrayList<>();
                    list.add(currentNumber);
                    int j = parent[currentNumber];
                    while(j != -1){
                        list.add(j);
                        j = parent[j];
                    }
                    return list;
                }

                if(currentNumber*2 < 110000 && !visit[currentNumber*2]){
                    visit[currentNumber*2] = true;
                    parent[currentNumber*2] = currentNumber;
                    q.add(currentNumber*2);
                }

                if(currentNumber+1 < 100001 && !visit[currentNumber+1]){
                    visit[currentNumber+1] = true;
                    parent[currentNumber+1] = currentNumber;
                    q.add(currentNumber+1);
                }

                if(currentNumber-1 >= 0 && !visit[currentNumber-1]){
                    visit[currentNumber-1] = true;
                    parent[currentNumber-1] = currentNumber;
                    q.add(currentNumber-1);
                }
            }
        }
        return null;
    }
}
