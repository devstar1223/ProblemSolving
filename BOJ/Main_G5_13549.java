package ProblemSolving.BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 숨바꼭질(https://www.acmicpc.net/problem/13549)
public class Main_G5_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NK = (br.readLine()).split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int answer = bfs(N,K);
        bw.write(answer+"");
        bw.flush();
    }

    private static int bfs(int start, int target){
        int limit = Math.max(start,target) * 2;
        boolean[] visited = new boolean[limit];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0,start));
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                Node pollNode = q.poll();

                int count = pollNode.count;
                int number = pollNode.number;

                if(number == target){
                    return count;
                }
                if(number*2 < limit && !visited[number*2]){
                    visited[number*2] = true;
                    q.add(new Node(count,number*2));
                }
                if(number-1 >= 0 && !visited[number-1]){
                    visited[number-1] = true;
                    q.add(new Node(count+1,number-1));
                }
                if(number+1 < limit && !visited[number+1]){
                    visited[number+1] = true;
                    q.add(new Node(count+1,number+1));
                }
            }
        }

        return -1;
    }

    static class Node{
        public int count;
        public int number;

        public Node(int count, int number){
            this.count = count;
            this.number = number;
        }

    }
}