import java.util.Arrays;
import java.util.HashMap;

public class Move {
    private String[] row_direction = {"u","U","d","D"};
    private String[] col_direction = {"r","R","l","L"};
    private String[] direction;
    private HashMap<String, Integer> map;

    public Move(){
        map = new HashMap();
        map.put("u", -1);map.put("U", -1);
        map.put("d", 1);map.put("D", 1);
        map.put("r", 1);map.put("R", 1);
        map.put("l", -1);map.put("L", -1);
        direction = Direction(row_direction,col_direction);
    }




    public boolean IsContainDirection(String s){
        if (Arrays.asList(direction).contains(s)) return true;
        else return false;

    }
    public HashMap<String, Integer> getDirection(String s){
        int step = map.get(s);
        HashMap<String,Integer> tmp = new HashMap<>();
        if (Arrays.asList(row_direction).contains(s)){
            tmp.put("row",step);
        }else if (Arrays.asList(col_direction).contains(s)){
            tmp.put("col",step);
        }
        return tmp;
    }
    private String[] Direction(String[] row_direction, String[] col_direction) {
        int destLength = row_direction.length + col_direction.length;

        String[] dest = new String[destLength];
        System.arraycopy(row_direction,0,dest,0,row_direction.length);
        System.arraycopy(col_direction,0,dest,row_direction.length,row_direction.length);
        return dest;
    }

    public int getValue(String s){
        return map.get(s);
    }

    public boolean IsContainRowDirection(String s) {
        if (Arrays.asList(row_direction).contains(s)) return true;

        return false;
    }

    public boolean IsContainColDirection(String s) {
        if (Arrays.asList(col_direction).contains(s)) return true;
        return false;
    }
}
