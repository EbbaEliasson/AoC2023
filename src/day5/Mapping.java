package day5;

import java.util.Arrays;

public class Mapping {
    // Mapping class for rules

    private final long destination;
    private final long source;
    private final long length;

    Mapping(String mappingString){
        String[] mapping = mappingString.split("\\s+");
        destination = Long.parseLong(mapping[0]);
        source = Long.parseLong(mapping[1]);
        length = Long.parseLong(mapping[2]);
    }

    public long getDestination(){
        return destination;
    }

    public long getSource(){
        return source;
    }

    public long getLength(){
        return length;
    }
}
