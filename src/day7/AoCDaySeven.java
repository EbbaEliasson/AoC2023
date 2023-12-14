package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AoCDaySeven {
    public static List<Hand> listOfHands = new ArrayList<>();
    public static List<Hand> listOfJokerHands = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/day7/inputDaySeven.txt"));

        while(scanner.hasNextLine()) {
            listOfHands.add(new Hand(scanner.next(), scanner.nextInt()));
        }

        listOfJokerHands =  new ArrayList<>(listOfHands);
        getSortedList();
        getSortedJokerList();

        int sum = 0;
        int jokerSum = 0;

        for(int i=0; i<listOfHands.size(); i++){
            sum += (i+1) * listOfHands.get(i).getBid();
            jokerSum += (i+1) * listOfJokerHands.get(i).getBid();
        }

        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + jokerSum);
    }

    static void getSortedList(){
        listOfHands.sort((v1, v2) -> {
            if(v1.getHandRank() == v2.getHandRank()){
                return Integer.compare(v1.getHandPoints(), v2.getHandPoints());
            } else {
                return Integer.compare(v1.getHandRank(), v2.getHandRank());
            }
        });
    }

    static void getSortedJokerList(){
        listOfJokerHands.sort((v1, v2) -> {
            if(v1.getHandRankWithJoker() == v2.getHandRankWithJoker()){
                return Integer.compare(v1.getHandPointsJoker(), v2.getHandPointsJoker());
            } else {
                return Integer.compare(v1.getHandRankWithJoker(), v2.getHandRankWithJoker());
            }
        });
    }



}
