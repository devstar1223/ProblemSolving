package ProblemSolving.BOJ;

import java.io.*;
import java.util.Stack;

// 괄호의 값 (https://www.acmicpc.net/problem/2504)
public class Main_G5_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //input
        String[] line = br.readLine().split("");

        //solve
        int answer = calculate(line);

        //output
        bw.write(answer+"");
        bw.flush();
    }

    public static int calculate(String[] line){
        int answer = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0 ; i < line.length; i++){
            String alpha = line[i];
            if(alpha.equals("[") || alpha.equals("(")){
                stack.push(alpha);
            }else if((alpha.equals("]") || alpha.equals(")")) && stack.isEmpty()){
                return 0;
            }else if(alpha.equals("]")){
                int multiple = 0;
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    String popAlpha = stack.pop();
                    if(popAlpha.equals("(") || popAlpha.equals(")")){
                        return 0;
                    }
                    multiple += Integer.parseInt(popAlpha);
                }
                if(stack.empty()){
                    return 0;
                }
                stack.pop();
                stack.push(Math.max(multiple,1) * 3 + "");
            }else if(alpha.equals(")")){
                int multiple = 0;
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    String popAlpha = stack.pop();
                    if(popAlpha.equals("[") || popAlpha.equals("]")){
                        return 0;
                    }
                    multiple += Integer.parseInt(popAlpha);
                }
                if(stack.empty()){
                    return 0;
                }
                stack.pop();
                stack.push(Math.max(multiple,1) * 2 + "");
            }
        }
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (!isNumber(top)){
                return 0;
            }
            answer += Integer.parseInt(top);
        }
        return answer;
    }

    private static boolean isNumber(String s) {
        char c = s.charAt(0);
        return c >= '0' && c <= '9';
    }
}

