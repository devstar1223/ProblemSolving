package ProblemSolving.Programmers;

import java.util.*;

class Solution_LV2_49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean alpha[] = new boolean[26];
        for(int i = 0; i < skill.length(); i++){
            alpha[skill.charAt(i) - 'A'] = true;
        }
        for(int i = 0; i < skill_trees.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < skill_trees[i].length(); j++){
                char ch = (skill_trees[i].charAt(j));
                if(alpha[ch-'A']){
                    sb.append(ch);
                }
            }
            String tmpS = sb.toString();
            int len = tmpS.length();
            if((skill.substring(0,len)).equals(tmpS)){
                answer += 1;
            }
        }
        return answer;
    }
}