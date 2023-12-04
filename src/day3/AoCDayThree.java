package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class AoCDayThree {
    //Advent Of Code
    //Day 3: Gear Ratios
    public static void main(String[] args) throws FileNotFoundException {
        String data = new Scanner(new File("src/day3/inputDayThree.txt")).useDelimiter("\\Z").next();
        String[] data2 = data.split("\\n");

        List<List<Character>> charMatrix = new ArrayList<>(data2.length);

        for (String s : data2) {
            List<Character> chars = s.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            chars.add('.');
            charMatrix.add(chars);
        }

        List<String> numResult = new ArrayList<>();

        boolean hasAdjacent = false;
        for (int i=0; i<charMatrix.size(); i++){
            StringBuilder num = new StringBuilder();
            for (int j=0; j<charMatrix.get(i).size(); j++){
                    if(Character.isDigit(charMatrix.get(i).get(j))){
                        num.append(charMatrix.get(i).get(j));
                        if(hasAdjacentSymbol(i, j, charMatrix)){
                            hasAdjacent = true;
                        }
                    }
                    else {
                        if(hasAdjacent){
                            numResult.add(num.toString());
                            hasAdjacent = false;
                        }
                        num = new StringBuilder();
                    }
                    }

                }
        int sum = 0;

        for(String m: numResult) {
            if(!Objects.equals(m, "")){
                sum += Integer.parseInt(m);
            }
        }

        System.out.println("Part 1: " + sum);
    }

    public static boolean hasAdjacentSymbol(int i, int j, List<List<Character>> chars){
        int[] indecies = {-1, 0, 1};
        for(int k: indecies){
            if((i+k >= 0) && (i+k < chars.size())){
                for(int l: indecies) {
                    if((j+l >= 0) && (j+l < chars.get(i+k).size())){
                        if (Character.toString(chars.get(i+k).get(j+l)).matches("[^a-zA-Z0-9.]")){
                            return true;
                        }
                    }

                }
            }

        }
        return false;
        }
}
