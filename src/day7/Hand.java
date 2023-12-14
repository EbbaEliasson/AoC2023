package day7;

import java.util.*;
import java.util.stream.Collectors;



public class Hand {
    private final String cards;
    private final int bid;
    private final HashMap<Character, Integer> cardsMap;

    Hand(String cards, int bid){
        this.cards = cards;
        this.bid = bid;
        cardsMap = getCardsMap(cards);
    }

    private HashMap<Character, Integer> getCardsMap(String cards){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: cards.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }

        return map;
    }

    public int getBid(){
        return bid;
    }

    public String getCards(){
        return cards;
    }

    public int getHandPoints(){
        List<String> listRep = new ArrayList<>(List.of(cards.split("")));

        Collections.replaceAll(listRep,"A", "14");
        Collections.replaceAll(listRep,"K", "13");
        Collections.replaceAll(listRep,"Q", "12");
        Collections.replaceAll(listRep,"J", "11");
        Collections.replaceAll(listRep,"T", "10");

        List<Integer> points = listRep.stream().map(Integer::parseInt).collect(Collectors.toList());

        return points.get(0)*100000000+ points.get(1)*1000000 + points.get(2)*10000 + points.get(3)*100 + points.get(4);
    }
    public int getHandPointsJoker(){
        List<String> listRep = new ArrayList<>(List.of(cards.split("")));

        Collections.replaceAll(listRep,"A", "13");
        Collections.replaceAll(listRep,"K", "12");
        Collections.replaceAll(listRep,"Q", "11");
        Collections.replaceAll(listRep,"J", "0");
        Collections.replaceAll(listRep,"T", "10");

        List<Integer> points = listRep.stream().map(Integer::parseInt).collect(Collectors.toList());

        return points.get(0)*100000000+ points.get(1)*1000000 + points.get(2)*10000 + points.get(3)*100 + points.get(4);
    }

    public int getHandRank(){
        if(isFiveOfAKind()){
            return 7;
        } else if(isFourOfAKind()){
            return 6;
        } else if(isFullHouse()){
            return 5;
        } else if(isThreeOfAKind()){
            return 4;
        } else if(isTwoPair()){
            return 3;
        } else if(isOnePair()){
            return 2;
        }
        else {
            return 1;
        }
    }

    public int getHandRankWithJoker(){
        if(isFiveOfAKind() || isFiveOfAKindWithJoker()){
            return 7;
        } else if(isFourOfAKind() || isFourOfAKindWithJoker()){
            return 6;
        } else if(isFullHouse() || isFullHouseWithJoker()){
            return 5;
        } else if(isThreeOfAKind() || isThreeOfAKindWithJoker()){
            return 4;
        } else if(isTwoPair() || isTwoPairWithJoker()){
            return 3;
        } else if(isOnePair() || isOnePairWithJoker()){
            return 2;
        }
        else {
            return 1;
        }
    }

    private boolean isFiveOfAKind(){
        return cardsMap.containsValue(5);
    }

    private boolean isFiveOfAKindWithJoker(){
        if(cardsMap.containsKey('J')){
            HashMap<Character, Integer> copy = new HashMap<>(cardsMap);
            copy.remove('J');
            return (cardsMap.get('J').equals(1) && copy.containsValue(4))
                    || (cardsMap.get('J').equals(2) && copy.containsValue(3))
                    || (cardsMap.get('J').equals(3) && copy.containsValue(2))
                    || (cardsMap.get('J').equals(4) && copy.containsValue(1));

        }
        return false;
    }

    private boolean isFourOfAKind(){
        return cardsMap.containsValue(4);
    }

    private boolean isFourOfAKindWithJoker(){
        if(cardsMap.containsKey('J')) {
            HashMap<Character, Integer> copy = new HashMap<>(cardsMap);
            copy.remove('J');
            return (cardsMap.get('J').equals(1) && copy.containsValue(3))
                    || (cardsMap.get('J').equals(2) && copy.containsValue(2))
                    || (cardsMap.get('J').equals(3) &&  copy.containsValue(1));
        }
        return false;
    }

    private boolean isFullHouse(){
        return cardsMap.containsValue(3) && cardsMap.containsValue(2);
    }

    private boolean isFullHouseWithJoker(){
        if(cardsMap.containsKey('J')){
            HashMap<Character, Integer> copy = new HashMap<>(cardsMap);
            copy.remove('J');
            return (cardsMap.get('J').equals(1) && (getPairs() == 2)
                    //|| cardsMap.get('J').equals(2) && copy.containsValue(2)
            );
        }
        return false;
    }

    private boolean isThreeOfAKind(){
        return cardsMap.containsValue(3) &! cardsMap.containsValue(2);
    }

    private boolean isThreeOfAKindWithJoker(){
        if(cardsMap.containsKey('J')) {
            HashMap<Character, Integer> copy = new HashMap<>(cardsMap);
            copy.remove('J');
            return (cardsMap.get('J').equals(1) && copy.containsValue(2))
                    || (cardsMap.get('J').equals(2) && copy.containsValue(1));
        }
        return false;
    }


    private boolean isTwoPair(){
        return getPairs() == 2;
    }

    private boolean isTwoPairWithJoker(){
        return false;
    }

    private boolean isOnePair(){
        return getPairs() == 1;
    }

    private boolean isOnePairWithJoker(){
        if(cardsMap.containsKey('J')) {
            return cardsMap.get('J').equals(1);
        }
        return false;
    }

    private int getPairs(){
        int count = 0;
        for(int val: cardsMap.values()){
            if(val == 2){
                count++;
            }
        }
        return count;
    }
}
