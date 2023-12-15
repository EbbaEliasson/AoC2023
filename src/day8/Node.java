package day8;

public class Node {
    public String self;
    public String right;
    public String left;

    Node(String str){
        str = str.replace("(", "").replace(")", "");
        self = str.split("=")[0].trim();
        right = str.split("=")[1].trim().split(",")[1].trim();
        left = str.split("=")[1].trim().split(",")[0].trim();
    }

    public  String returnNext(char direction){
        if(direction == 'R'){
            return right;
        } else {
            return left;
        }
    }
}
