package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class AoCDayEight {
    static String directions;
    static HashMap<String, Node> nodes = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/day8/inputDayEight.txt"));

        directions = scanner.nextLine();

        while(scanner.hasNextLine()){
            Node node =  new Node(scanner.nextLine());
            nodes.put(node.self, node);
        }

        System.out.println("Part 1: " + findZZZ());
        System.out.println("Part 2: LCM of " + findXXZ());
    }

    public static int getNumSteps(String start, String end){
        int numStep = 0;
        int directionStep = 0;

        Node current = nodes.get(start);
        boolean doNext = true;

        while(doNext){
            if(directionStep>=directions.length()){
                directionStep = 0;
            }
            Node next = nodes.get(current.returnNext(directions.charAt(directionStep)));
            numStep++;
            directionStep++;

            if(next.self.endsWith(end)){
                doNext = false;
            }
            current = next;
        }

        return numStep;
    }

    public static int findZZZ(){
        return getNumSteps("AAA", "ZZZ");
    }

    public static List<Integer> findXXZ(){
        List<String> startNodes = nodes.keySet()
                .stream()
                .filter(s -> s.endsWith("A"))
                .collect(Collectors.toList());

        List<Integer> numSteps = new ArrayList<>();

        for(String node: startNodes){
            numSteps.add(getNumSteps(node, "Z"));
        }

        return numSteps;
    }

}
