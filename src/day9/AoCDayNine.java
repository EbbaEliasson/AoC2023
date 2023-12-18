package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class AoCDayNine {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/day9/inputDayNine.txt"));
        List<List<Integer>> histories = new ArrayList<>();
        List<List<Integer>> reversedHistories = new ArrayList<>();


        while (scanner.hasNextLine()){
            List<Integer> history = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            histories.add(history);
            List<Integer> reversedHistory = new ArrayList<>(history);
            Collections.reverse(reversedHistory);
            reversedHistories.add(reversedHistory);

        }

        System.out.println("Part 1: " + getSum(histories));
        System.out.println("Part 2: " + getSum(reversedHistories));
    }

    public static int getSum(List<List<Integer>> histories){
        int sum = 0;
        for(List<Integer> history: histories){
            List<List<Integer>> iterations = getIterations(history);
            sum += getHistory(iterations);
        }
        return sum;
    }

    public static List<List<Integer>> getIterations(List<Integer> history){
        List<List<Integer>> iterations = new ArrayList<>(List.of(history));
        List<Integer> current = history;

        boolean notAllZeros = true;

        while(notAllZeros){
            List<Integer> iteration = new ArrayList<>();
            int zeros = 0;
            for (int i=0; i<current.size()-1; i++){
                iteration.add(current.get(i+1)-current.get(i));
                if(current.get(i+1)-current.get(i)==0){
                    zeros++;
                }
            }
            if(zeros == current.size()-1){
                notAllZeros = false;
            }

            iterations.add(iteration);
            current = iteration;
        }
    return iterations;
    }
    public static int getHistory(List<List<Integer>> iterations){
        List<Integer> lasts = iterations.stream().map(s-> s.get(s.size()-1)).collect(Collectors.toList());
        return lasts.stream().mapToInt(Integer::intValue).sum();
    }

}
