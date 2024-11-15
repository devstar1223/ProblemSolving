package ProblemSolving.SWEA;

import java.io.*;
import java.util.*;

//19113.식료품 가게
public class Solution_D3_19113 {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(rd.readLine());
        for(int tc = 1; tc <= T; tc++){
            wr.write("#"+tc+" ");

            int N = Integer.parseInt(rd.readLine());
            String[] priceArray = (rd.readLine()).split(" ");
            List<Integer> priceList = new ArrayList<>();
            List<Integer> answerList = new ArrayList<>();
            for(String s : priceArray){
                priceList.add(Integer.parseInt(s));
            }
            while(!priceList.isEmpty()){
                int salePrice = priceList.get(0);
                int normalPrice = normalization(salePrice);
                answerList.add(salePrice);
                int index = priceList.indexOf(normalPrice);
                priceList.remove(index);
                priceList.remove(0);
            }

            for(int i = 0; i < answerList.size(); i++){
                if(i == answerList.size()-1){
                    wr.write(answerList.get(i)+"");
                }
                else{
                    wr.write(answerList.get(i)+" ");
                }
            }

            if(tc != T){
                wr.newLine();
            }
        }
        rd.close();
        wr.flush();
        wr.close();
    }

    public static int normalization(int price){
        double result = (double) price / 0.75;
        return (int) result;
    }
}