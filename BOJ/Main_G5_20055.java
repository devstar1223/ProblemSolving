package ProblemSolving.BOJ;

import java.io.*;
import java.util.*;

// 컨베이어 벨트 위의 로봇(https://www.acmicpc.net/problem/20055)
public class Main_G5_20055 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NK = (rd.readLine()).split(" ");
        int N = Integer.parseInt(NK[0]); // 길이는 2N이다.
        int K = Integer.parseInt(NK[1]); // 내구도 0이 K개 이상이면 종료
        String[] blockDurabilityInfoArray = (rd.readLine()).split(" "); // 벨트 정보 받기

        for(String s : blockDurabilityInfoArray){ // 벨트 블록 만들어서 벨트에 저장
            BeltBlock beltBlock = new BeltBlock(Integer.parseInt(s));
            Belt.beltBlockAdd(beltBlock);
        }

        int count = 0;
        while(!Belt.beltEnd(K)){ // 끝날때까지 반복
            count++;
            Belt.beltRotate(); // 회전
            Belt.nIndexRobotDeregist(); // 마지막 위치 로봇 등록 해제
            Belt.beltRobotMove(); // 로봇 이동
            Belt.firstIndexRobotRegist(); // 첫번째 위치 로봇 등록
        }
        wr.write(count+"");
        wr.flush();
    }
}

class BeltBlock{
    public int durability;
    public boolean robotContain;

    public BeltBlock(int durability){ // 생성자
        this.durability = durability;
        this.robotContain = false;
    }
    public void robotRegist(){ // 로봇이 해당 위치에 생기고, 내구도가 감소한다.
        robotContain = true;
        durability--;
    }
    public void robotDeregist(){ // 로봇이 해당 위치에서 사라진다
        robotContain = false;
    }
    public boolean hasRobot(){ // 로봇을 가지고 있는지 체크한다.
        return robotContain;
    }
    public boolean hasDurability(){ // 내구도가 0보다 큰지 체크한다.
        return durability > 0;
    }
}

class Belt{
    public static List<BeltBlock> belt = new ArrayList<>();

    public static void beltBlockAdd(BeltBlock beltBlock){
        belt.add(beltBlock);
    }
    public static void beltRotate(){
        belt.add(0,belt.get(belt.size()-1)); // 맨 앞에, 맨 뒤 원소 삽입
        belt.remove(belt.size()-1); // 맨 뒤 원소 제거
    }
    public static void nIndexRobotDeregist(){ // 내리는 위치의 로봇 내리기
        BeltBlock lastBeltBlock = belt.get(belt.size()/2 - 1);
        if(lastBeltBlock.hasRobot()){ // 로봇 가지고 있으면
            lastBeltBlock.robotDeregist(); // 로봇 내리기
        }
    }
    public static void firstIndexRobotRegist(){ // 첫번쨰 위치에 로봇을 올린다.
        BeltBlock firstBeltBlock = belt.get(0);
        if(firstBeltBlock.hasDurability() && !firstBeltBlock.hasRobot()){ // 내구도가 0 이상이면
            firstBeltBlock.robotRegist(); // 로봇 등록
        }
    }
    public static void beltRobotMove(){ // 로봇 움직이기
        int index = belt.size()-2; // 벨트의 끝 한칸 이전칸이 최초의 위치이다.
        for(int i = index; i >= 0; i--){ // 맨 오른쪽 칸 부터, 모든 칸에 대해 검사한다.
            BeltBlock indexBeltBlock = belt.get(i); // 검사할 블록
            BeltBlock indexNextBeltBlock = belt.get(i+1); // 검사할 블록의 다음 블록
            if(indexBeltBlock.hasRobot() && indexNextBeltBlock.hasDurability() && !indexNextBeltBlock.hasRobot()){
                indexBeltBlock.robotDeregist();
                indexNextBeltBlock.robotRegist();
            }
            nIndexRobotDeregist(); // 로봇 내리기
        }
    }
    public static boolean beltEnd(int limit){ // 내구도가 0인게 K이상인지 확인
        int endCount = 0;
        for(BeltBlock beltBlock : belt){
            if(!beltBlock.hasDurability()){ // 내구도가 0이면
                endCount++; // endCount 증가
            }
            if(endCount >= limit){ // 이게 K 이상이면
                return true;
            }
        }
        return false; // 아직 가능하면
    }
}
