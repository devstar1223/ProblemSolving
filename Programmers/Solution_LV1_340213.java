package ProblemSolving.Programmers;

class Solution_LV1_340213 {

    public static int pLen;
    public static int pStart;
    public static int pEnd;
    public static int pPos;

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        pLen = parsing(video_len);
        pStart = parsing(op_start);
        pEnd = parsing(op_end);
        pPos = parsing(pos);

        for(String s : commands){
            videoPlayer(s);
        }

        String mm = String.valueOf(pPos / 60);
        if(mm.length() == 1){
            mm = "0" + mm;
        }
        String ss = String.valueOf(pPos % 60);
        if(ss.length() == 1){
            ss = "0" + ss;
        }
        return mm+":"+ss;
    }

    public static int parsing(String timeMMSS){
        int pTime = 0;
        pTime += Integer.parseInt(timeMMSS.substring(0,2)) * 60;
        pTime += Integer.parseInt(timeMMSS.substring(3));
        return pTime;
    }

    public static void videoPlayer(String command){
        if(pPos >= pStart && pPos <= pEnd){
            pPos = pEnd;
        }

        if(command.equals("next")){
            pPos = Math.min(pPos+10,pLen);
        }
        else{
            pPos = Math.max(pPos-10,0);
        }

        if(pPos >= pStart && pPos <= pEnd){
            pPos = pEnd;
        }
    }
}
