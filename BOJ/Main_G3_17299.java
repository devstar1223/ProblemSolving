package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 오등큰수(https://www.acmicpc.net/problem/17299)
public class Main_G3_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        Number[] numberArray = new Number[N];

        int[] answerArray = new int[N];
        Arrays.fill(answerArray,-1);

        HashMap<Integer,Integer> map = new HashMap<>();

        String[] stringArray = (br.readLine()).split(" ");

        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(stringArray[i]);
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }

        for(int i = 0; i < N; i++){
            numberArray[i] = new Number(array[i],map.get(array[i]),i);
        }

        Stack<Number> stack = new Stack<>();

        for(int i = 0; i < N; i++){

            Number number = numberArray[i];

            if(stack.isEmpty()){
                stack.push(numberArray[i]);
                continue;
            }

            Number peekNumber = stack.peek();

            if(peekNumber.appear > number.appear){
                stack.push(number);
                continue;
            }

            while(!stack.isEmpty() && peekNumber.appear < number.appear){
                answerArray[peekNumber.index] = number.value;
                stack.pop();
                if(!stack.isEmpty()){
                    peekNumber = stack.peek();
                }
            }

            stack.push(number);
        }

        for(int i = 0; i < N-1; i++){
            bw.write(answerArray[i]+" ");
        }
        bw.write(answerArray[N-1]+"");
        bw.flush();

    }

    private static class Number{
        public int value;
        public int appear;
        public int index;

        public Number(int value, int appear, int index){
            this.value = value;
            this.appear = appear;
            this.index = index;
        }
    }
}