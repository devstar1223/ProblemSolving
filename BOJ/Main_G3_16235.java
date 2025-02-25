package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

//나무 재테크(https://www.acmicpc.net/problem/16235)
public class Main_G3_16235 {

    static int N,M,K;
    static Space[][] ground;
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NMK = (br.readLine()).split(" ");
        N = Integer.parseInt(NMK[0]);
        M = Integer.parseInt(NMK[1]);
        K = Integer.parseInt(NMK[2]);

        ground = new Space[N][N];

        // 2차원 배열에 공간 배치
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ground[i][j] = new Space(i,j);
            }
        }

        // 모든 공간에 매해 줄 영양 설정
        for(int i = 0; i < N; i++){
            String[] line = (br.readLine()).split(" ");
            for(int j = 0; j < N; j++){
                ground[i][j].addNutrition = Integer.parseInt(line[j]);
            }
        }

        // 주어진 나무 공간에 추가
        for(int i = 0; i < M; i++){
            String[] XYOld = (br.readLine()).split(" ");
            int X = Integer.parseInt(XYOld[0]) - 1;
            int Y = Integer.parseInt(XYOld[1]) - 1;
            int old = Integer.parseInt(XYOld[2]);
            ground[X][Y].liveTreeDeque.add(new Tree(old));
        }

        for(int i = 0; i < K; i++){
            spring();
            summer();
            fall();
            winter();
        }

        bw.write(treeCount()+"");
        bw.flush();
    }

    private static void spring() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Space space = ground[i][j];
                int len = space.liveTreeDeque.size();
                for(int k = 0; k < len; k++){
                    Tree tree = space.liveTreeDeque.pollLast();
                    // 섭취 불가
                    if(tree.old > space.currentNutrition){
//                        space.currentNutrition = 0; // 모든 식물은 영양을 일단 먹는다고 칠때
                        space.deadTreeQueue.add(tree);
                    }
                    // 섭취 가능
                    else{
                        space.currentNutrition -= tree.old;
                        tree.old++;
                        space.liveTreeDeque.addFirst(tree);
                        if(tree.old % 5 == 0){
                            space.fiveTree++;
                        }
                    }
                }
            }
        }
    }

    private static void summer() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Space space = ground[i][j];
                while(!space.deadTreeQueue.isEmpty()){
                    space.currentNutrition += (space.deadTreeQueue.poll().old / 2);
                }
            }
        }
    }

    private static void fall() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Space space = ground[i][j];
                if(space.fiveTree > 0){
                    for(int k = 0; k < 8; k++){
                        int ny = space.y + dy[k];
                        int nx = space.x + dx[k];
                        if(ny >= 0 && nx >= 0 && ny < N && nx < N){
                            for(int l = 0; l < space.fiveTree; l++){
                                ground[ny][nx].liveTreeDeque.addLast(new Tree(1));
                            }
                        }
                    }
                    space.fiveTree = 0;
                }
            }
        }
    }

    private static void winter() {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ground[i][j].currentNutrition += ground[i][j].addNutrition;
            }
        }
    }

    private static int treeCount() {
        int result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result += ground[i][j].liveTreeDeque.size();
            }
        }
        return result;
    }

    private static class Space{
        public int y;
        public int x;
        public int fiveTree = 0;
        public int currentNutrition = 5;
        public int addNutrition;
        public Deque<Tree> liveTreeDeque = new LinkedList<>();
        public Queue<Tree> deadTreeQueue = new LinkedList<>();

        public Space(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class Tree{
        public int old;

        public Tree(int old){
            this.old = old;
        }
    }
}