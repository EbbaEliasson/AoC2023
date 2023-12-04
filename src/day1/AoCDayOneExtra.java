package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class AoCDayOneExtra {
    // Advent Of Code
    // Day 1: Trebuchet?! --> EXTRA

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/inputDayOne.txt");
        Scanner scanner = new Scanner(input);
        int sum = 0;

        HashMap <String, String> letterDigits = new HashMap<>();
        letterDigits.put("oneight", "18"); letterDigits.put("twone", "21"); letterDigits.put("eightwo", "82");
        letterDigits.put("one", "1"); letterDigits.put("two", "2"); letterDigits.put("three", "3");
        letterDigits.put("four", "4"); letterDigits.put("five", "5"); letterDigits.put("six", "6");
        letterDigits.put("seven", "7"); letterDigits.put("eight", "8"); letterDigits.put("nine", "9");

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String result = "";
            for(HashMap.Entry<String, String> val : letterDigits.entrySet())
            {
                result = line.replace(val.getKey(), val.getValue());
                line = result;
            }

            long allDigits = Long.parseLong(line.replaceAll("[^0-9]", ""));
            int lenAllDigits = String.valueOf(allDigits).length();
            if (lenAllDigits == 1){
                sum += (int) (allDigits * 10 + allDigits);
            } else {
                sum += (int) ((allDigits /(int) Math.pow(10, Math.max(1, (int) (Math.log10(Math.abs(allDigits)))))) * 10 + allDigits%10);
            }
        }
        System.out.println(sum);
    }
}
