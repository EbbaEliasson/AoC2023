package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoCDayOne {
    // Advent Of Code
    // Day 1: Trebuchet?!
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day1/inputDayOne.txt");
        Scanner scanner = new Scanner(input);
        int sum = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            int allDigits = Integer.parseInt(line.replaceAll("[^0-9]", ""));
            int lenAllDigits = String.valueOf(allDigits).length();
            if (lenAllDigits == 1){
                sum += allDigits * 10 + allDigits;
            } else {
                sum += (allDigits /(int) Math.pow(10, Math.max(1, (int) (Math.log10(Math.abs(allDigits)))))) * 10 + allDigits%10;
            }
        }
        System.out.println(sum);
    }

}
