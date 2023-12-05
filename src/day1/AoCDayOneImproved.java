package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoCDayOneImproved {
    // Advent Of Code
    // Day 1: Trebuchet?! --> Improved
    //Improvement on part 2 not the best still...
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day1/inputDayOne.txt");
        Scanner scanner = new Scanner(input);
        int sum1 = 0;
        int sum2 = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sum1 += getFirstAndLast(line);
            sum2 += getFirstAndLast(replaceWithDigits(line));
        }

        System.out.println("Part 1: " + sum1);
        System.out.println("Part 2: " + sum2);

    }

    public static int getFirstAndLast(String str){
        int first = 0; int last = 0;
        for (String s: str.split("")){
            if(Character.isDigit(s.charAt(0))){
                if(first == 0){
                    first = Integer.parseInt(s);
                }
                last = Integer.parseInt(s);
            }
        }
        return first * 10 + last;
    }

    public static String replaceWithDigits(String str){
        System.out.println(str);
        HashMap <String, String> letterDigits = new HashMap<>();
        letterDigits.put("one", "one1one"); letterDigits.put("two", "two2two"); letterDigits.put("three", "three3three");
        letterDigits.put("four", "four4four"); letterDigits.put("five", "five5five"); letterDigits.put("six", "six6six");
        letterDigits.put("seven", "seven7seven"); letterDigits.put("eight", "eight8eight"); letterDigits.put("nine", "nine9nine");

        for(HashMap.Entry<String, String> val : letterDigits.entrySet())
        {
            str = str.replace(val.getKey(), val.getValue());
        }

        return str;
    }

}
