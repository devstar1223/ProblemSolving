package ProblemSolving.Programmers;

// 정수 삼각형 (https://school.programmers.co.kr/learn/courses/30/lessons/43105)
class Solution_LV3_43105 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] dpTable = new int[N][N];
        dpTable[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dpTable[i][j] = triangle[i][j] + dpTable[i-1][j];
                }
                else{
                    dpTable[i][j] = triangle[i][j] + Math.max(dpTable[i-1][j-1],dpTable[i-1][j]);
                }

            }
        }

        int max = 0;
        for(int i : dpTable[N-1]){
            if(i > max){
                max = i;
            }
        }

        return max;
    }
}