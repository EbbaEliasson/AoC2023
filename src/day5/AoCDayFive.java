package day5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AoCDayFive {
    //Advent Of Code
    //Day 5: If You Give A Seed A Fertilizer

    public static Map<Integer, List<Mapping>> mapperList = new HashMap<>();

    public static String test = "seeds: 79 14 55 13\n" +
            "\n" +
            "seed-to-soil map:\n" +
            "50 98 2\n" +
            "52 50 48\n" +
            "\n" +
            "soil-to-fertilizer map:\n" +
            "0 15 37\n" +
            "37 52 2\n" +
            "39 0 15\n" +
            "\n" +
            "fertilizer-to-water map:\n" +
            "49 53 8\n" +
            "0 11 42\n" +
            "42 0 7\n" +
            "57 7 4\n" +
            "\n" +
            "water-to-light map:\n" +
            "88 18 7\n" +
            "18 25 70\n" +
            "\n" +
            "light-to-temperature map:\n" +
            "45 77 23\n" +
            "81 45 19\n" +
            "68 64 13\n" +
            "\n" +
            "temperature-to-humidity map:\n" +
            "0 69 1\n" +
            "1 0 69\n" +
            "\n" +
            "humidity-to-location map:\n" +
            "60 56 37\n" +
            "56 93 4";

    public static void main(String[] args) {

        SeedData seedData = new SeedData(test);

        mapperList = seedData.getMappingList();

        // Printing mapperlist
        System.out.println("--- Mapper List ---");
        for(int i=0; i<mapperList.size(); i++){
            System.out.println("index: " + i);
            for(int j=0; j<mapperList.get(i).size(); j++){
                System.out.println("Source: " + mapperList.get(i).get(j).getSource());
            }
        }

        List<Long> sources = seedData.getSeeds();
        List<Long> destinations = new ArrayList<>();

        for (long source : sources) {
            destinations.add(sourceToDestination(source));
        }

        System.out.println(destinations);

    }

    public static long sourceToDestination(long source) {
        long tempSource = source;
        long tempDestination = source;

        List<Mapping> maps;

        for (int i = 0; i < mapperList.size(); i++){
            maps = mapperList.get(i);
            for (Mapping map : maps) {
                if (tempSource > map.getSource() & tempSource < map.getSource() + map.getLength()) {
                    tempDestination = map.getDestination() + (source - map.getSource());
                    tempSource = tempDestination;

                }
            }
        }
        return tempDestination;
    }



}
