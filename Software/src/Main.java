import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main{
    private static String[][] map;

    private static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/default.map";
//    private static String filePath = "/Users/seonghak/Downloads/another.map";
    public static void main(String[] args) {
//        new EventFireGui();

        map = Map.loadMap(filePath);

        for (int i=0; i< map.length; i++){
            for (int j=0; j<map[0].length; j++){
                if (map[i][j] == null){
                    System.out.print(" ");
                }else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }
}