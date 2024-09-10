package ProblemSolving.Programmers;

class Solution_LV2_340212 {

    public static int[] diffs;
    public static int[] times;

    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        int left = 1;
        int right = 100000;
        int myLevel = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            long solvetime = 0;

            for(int i = 0; i < diffs.length; i++){
                solvetime += solve(i,mid);
                if (solvetime > limit){ // 중간에 시간 초과됨
                    break;
                }
            }

            if(solvetime > limit){ // 숙련도 올려야함
                left = mid+1;
            }
            else { // 숙련도 충분함 -> 숙련도 내려보기
                myLevel = mid;
                right = mid-1;
            }
        }

        return myLevel;
    }

    public static long solve(int index, int level){

        if(index == 0){
            return times[0];
        }

        int diff = diffs[index];
        long time = times[index];
        long prevTime = times[index - 1];

        if(diff <= level){
            return time;
        }
        else{
            return (diff - level) * (time + prevTime) + time;
        }

    }
}
