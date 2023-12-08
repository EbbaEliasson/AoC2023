package day5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeedData {
    private static List<String> data;
    private static int mapperLength;

    SeedData(String str){
        data = Arrays.stream(str.split("\\n\\n"))
                .collect(Collectors.toList());

        mapperLength = data.size() - 1;
    }

    private static List<String> splitter(int index){
        return Arrays.stream(data.get(index).split(":"))
                .collect(Collectors.toList());
    };

    public List<Long> getSeeds(){
        return Stream.of(splitter(0).get(1).trim().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public static List<Mapping> getMapOnIndex(int index){
        return Stream.of(splitter(index + 1).get(1).trim().split("\\n"))
                .map(Mapping::new)
                .collect(Collectors.toList());
    }

    public Map<Integer,List<Mapping>> getMappingList(){
        Map<Integer, List<Mapping>> mapperList = new HashMap<>();
        for (int i = 0; i < mapperLength; i++){
            mapperList.put(i, getMapOnIndex(i));
        }
        return mapperList;
    }




}
