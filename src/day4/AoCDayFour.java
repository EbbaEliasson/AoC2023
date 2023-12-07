package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class AoCDayFour {
    //Advent Of Code
    //Day 4: Scratchcards

    public static void main(String[] args ) throws FileNotFoundException {
        File input = new File("src/day4/inputDayFour.txt");
        Scanner scanner = new Scanner(input);

        int sum = 0;
        List<String> allLines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            allLines.add(line);

            sum += getPoints(line);
        }

        scanner.close();

        int totalCards = getTotalCards(allLines);

        System.out.println("Part 1: " + sum);
        System.out.println("Part 2: " + totalCards);
    }

    public static int getTotalCards(List<String> lines){
        List<String> result = new ArrayList<>(lines);
        for (int i = 0; i<result.size(); i++){
            int matching = getMatching(result.get(i));
            int index = lines.indexOf(result.get(i));
            if(matching>0){
                for(int j=index+1; j < min(index+matching+1,lines.size()); j++){
                    result.add(lines.get(j));
                }
            }

        }
        return result.size();
    }

    public static int getMatching(String str){
        String[] strList = str.split(": | \\|");
        return (int) Stream.of(strList[2].split("\\s+"))
                .filter(s -> !s.isEmpty())
                .filter(s-> List.of(strList[1].split("\\s+")).contains(s))
                .count();
    }

    public static int getPoints(String str){
        long winningNumbers = getMatching(str);

        if(winningNumbers>=1){
           return (int) Math.pow(2, winningNumbers -1);
        } else {
            return 0;
        }

    }
}
