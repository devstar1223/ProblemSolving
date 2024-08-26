package ProblemSolving.Programmers;
//네트워크(https://school.programmers.co.kr/learn/courses/30/lessons/43162)
class Solution_LV3_43162 {

    public static boolean[] visit;
    public static int len;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        len = computers.length;
        visit = new boolean[len];
        for(int i = 0; i < len; i++){
            if(!visit[i]){
                dfs(computers,i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int[][] computers, int num){
        visit[num] = true;
        for(int i = 0; i < len; i++){
            if(computers[num][i] == 1 && !visit[i]){
                dfs(computers, i);
            }
        }
    }
}
