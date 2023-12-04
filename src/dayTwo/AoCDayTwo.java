package dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class AoCDayTwo {
    //Advent of Code
    //Day 2: Code Conundrum
    public static int returnIdIfPossible(String str) {
        //Part 1
        //Returns gameID if reds <= 12, greens <= 13, or blues <= 14
        int gameId = 0;

        String[] splitStr = str.split(":|,|;");
        for (String split1: splitStr) {
            String[] split2 = split1.trim().split("\\s");
            if(Objects.equals(split2[0], "Game")){
                gameId = Integer.parseInt(split2[1]);
            } else if (Objects.equals(split2[1], "red")) {
                if(Integer.parseInt(split2[0])>12){return 0;}
            } else if (Objects.equals(split2[1], "green")) {
                if(Integer.parseInt(split2[0])>13){return 0;}
            } else if (Objects.equals(split2[1], "blue")) {
                if(Integer.parseInt(split2[0])>14){return 0;};
            }
        }
        return gameId;
    }

    public static int returnPowerOfMinSet(String str){
        //Part 2
        //Returns the power of the minimum set of cubes
        int maxRed=0; int maxGreen=0; int maxBlue=0;

        String[] splitStr = str.split(":|,|;");
        for (String split1: splitStr) {
            String[] split2 = split1.trim().split("\\s");
            if (Objects.equals(split2[1], "red")) {
                 if(Integer.parseInt(split2[0])>maxRed){maxRed = Integer.parseInt(split2[0]);}
            } else if (Objects.equals(split2[1], "green")) {
                if(Integer.parseInt(split2[0])>maxGreen){maxGreen = Integer.parseInt(split2[0]);}
            } else if (Objects.equals(split2[1], "blue")) {
                if(Integer.parseInt(split2[0])>maxBlue){maxBlue = Integer.parseInt(split2[0]);}
            }
        }
        return maxRed * maxGreen * maxBlue ;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/dayTwo/inputDayTwo.txt");
        Scanner scanner = new Scanner(input);

        int idSum = 0;
        int powerSetSum = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            idSum += returnIdIfPossible(line);
            powerSetSum += returnPowerOfMinSet(line);
        }

        System.out.println("Part 1: " + idSum);
        System.out.println("Part 2: " + powerSetSum);
    }
}
