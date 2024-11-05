package ProblemSolving.SWEA;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_D2_1859
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] array = new int[N];
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer,Integer> map = new HashMap<>();
            sc.nextLine();
            String[] tmp = (sc.nextLine()).split(" ");
            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(tmp[i]);
                maxHeap.add(array[i]);
                map.put(array[i],map.getOrDefault(array[i],0)+1);
            }
            long money = 0;
            int amount = 0;
            for(int i = 0; i < N; i++){
                while(map.get(maxHeap.peek()) == null){
                    maxHeap.poll();
                }
                int peekValue = maxHeap.peek();
                if(array[i] < peekValue){
                    money -= array[i];
                    amount++;
                }
                else if(array[i] == peekValue){
                    int price = maxHeap.poll();
                    money += amount * price;
                    amount = 0;
                }
                if(map.get(array[i]) == 1){
                    map.remove(array[i]);
                }
                else{
                    map.put(array[i],map.get(array[i])-1);
                }
            }
            System.out.println("#"+test_case+" "+ money);
        }
    }
}