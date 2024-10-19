package ProblemSolving.Programmers;

//괄호변환 (https://school.programmers.co.kr/learn/courses/30/lessons/60058)

class Solution_LV2_60058 {
    public String solution(String p) {
        return recur(p);
    }

    public boolean correctCheck(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public String[] uvDivide(String s) {
        String[] uv = new String[2];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                uv[0] = s.substring(0, i + 1);
                uv[1] = s.substring(i + 1, s.length());
                break;
            }
        }
        return uv;
    }

    public String deleteAndReverse(String s) {
        s = s.substring(1, s.length() - 1);
        s = s.replace("(", "_");
        s = s.replace(")", "(");
        s = s.replace("_", ")");
        return s;
    }

    public String recur(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String[] uv = uvDivide(s);
        String u = uv[0];
        String v = uv[1];
        if (correctCheck(u)) {
            return u + recur(v);
        }
        return '(' + recur(v) + ')' + deleteAndReverse(u);
    }
}

