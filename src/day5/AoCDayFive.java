package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class AoCDayFive {
    //Advent Of Code
    //Day 5: If You Give A Seed A Fertilizer

    public static Map<Integer, List<Mapping>> mapperList = new HashMap<>();

    public static String test;

    static {
        try {
            test = new Scanner(new File("src/day5/inputDayFive.txt")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        SeedData seedData = new SeedData(test);

        mapperList = seedData.getMappingList();

        List<Long> sources = seedData.getSeeds();
        List<Long> destinations = new ArrayList<>();

        for (long source : sources) {
            destinations.add(sourceToDestination(source));
        }

        System.out.println("Part 1: " + Collections.min(destinations));

        List<Long> destinationsNew = new ArrayList<>();

        int[] index = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};

        for(int i: index){
            System.out.println("--- Loop " + i + " ---");
            Long tempMin = Long.MAX_VALUE;
            for(int j = 0; j< sources.get(i+1); j++){
                Long tempDestination = sourceToDestination(sources.get(i) + j);
                if(tempDestination<tempMin){
                    tempMin = tempDestination;
                }
            }
            destinationsNew.add(tempMin);
        }

        System.out.println("Part 2: " + Collections.min(destinationsNew));

    }

    public static long sourceToDestination(long source) {
        long tempSource = source;
        long tempDestination = source;

        for (int i = 0; i < mapperList.size(); i++){
            for (Mapping map : mapperList.get(i)) {
                if ((tempSource >= map.getSource()) & (tempSource < (map.getSource() + map.getLength()))) {
                    tempDestination = map.getDestination() + (tempSource - map.getSource());
                }
            }
            tempSource = tempDestination;
        }
        return tempDestination;
    }



}
