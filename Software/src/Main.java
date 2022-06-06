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

        // map을 load한다.
        map = new Map(filePath);

        // map의 시작 위치를 찾는다.
        try {
            startRow = map.getStartRow();
            startCol = map.getStartCol();
        } catch (NullPointerException e){
            System.out.println(e);
        }
        // map을 그린다.
        map.drawMap();

    }
}