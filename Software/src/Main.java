import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    private static Map map;
    private static int startRow;
    private static int startCol;

    private static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/default.map";
//    private static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/another.map";
    public static void main(String[] args) {
//        new EventFireGui();

        map = new Map(filePath);
        try {
            startRow = map.getStartRow();
            startCol = map.getStartCol();
        } catch (NullPointerException e){
            System.out.println(e);
        }
        map.drawMap();

    }
}