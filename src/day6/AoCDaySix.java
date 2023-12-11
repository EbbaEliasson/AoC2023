package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoCDaySix {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/day6/inputDaySix.txt"));
        String[] times = getContent(scanner.nextLine());
        String[] distances = getContent(scanner.nextLine());

        int multiplicationSum = 1;

        for(int i=0; i<times.length; i++){
            multiplicationSum *=
                    getNumberOfWinning(Integer.parseInt(times[i]), Integer.parseInt(distances[i]));
        }

        System.out.println("Part 1: " + multiplicationSum);

        long joinedTimes = joinToNumber(times);
        long joinedDistances = joinToNumber(distances);

        int sum = getNumberOfWinning(joinedTimes, joinedDistances);

        System.out.println("Part 2: " + sum);
    }

    static String[] getContent(String str){
        return str.split(":")[1].trim().split("\\s+");
    }

    static long joinToNumber(String[] strList){
        return Long.parseLong(String.join("", strList));
    }
    static int getNumberOfWinning(long raceDuration, long recordDistance){
        long maxSolution = raceDuration / 2;
        int numberOfWinning = 0;

        for(long i=maxSolution; i<raceDuration; i++){
            long d = distanceFunc(raceDuration, i);
            if(d>recordDistance){
               numberOfWinning++;
            } else {
                break;
            }
        }

        for(long i=maxSolution-1; i>0; i--){
            long d = distanceFunc(raceDuration, i);
            if(d> recordDistance){
                numberOfWinning++;
            } else {
                break;
            }
        }
        return numberOfWinning > 0? numberOfWinning : 1;
    }

    static long distanceFunc(long raceDuration, long tHold){
        return tHold * (raceDuration - tHold);
    }

}

