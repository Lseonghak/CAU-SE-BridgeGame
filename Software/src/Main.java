import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    private static Map map;

    private static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/default.map";
//    private static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/another.map";
    public static void main(String[] args) {
//        new EventFireGui();

        map = new Map(filePath);
        map.drawMap();

    }
}