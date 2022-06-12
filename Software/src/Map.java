import java.io.*;
import java.util.HashMap;

public class Map {
    private static String[][] map;
    private static int startRow=0;
    private static int startCol=0;

    private Move move;

    Map(String filePath) {

        map = new String[14][15];
        move = new Move();

        try{
            // 파일 객체 생성
            File file = new File(filePath);
            // 입력 슽트링 생성
            FileReader fileReader = new FileReader(file);
            // 입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line = "";
            int row = 2;
            int col = 2;
            boolean flag = true; // map에 S는 start와 saw가 있으므로 시작 s를 제외하고는 saw로 간주하기 위함
            while((line = bufReader.readLine()) != null){
                String[] rowLine = line.split(" ");

                // map의 시작 index를 저장
                if (rowLine[0].equals("S") && flag == true){
                    startRow = row;
                    startCol = col;
                    flag = false;
                }

                try{
                    map[row][col] = rowLine[0];
                    // map을 배열에 그린다.
                    String s = rowLine[rowLine.length-1];
                    if (move.IsContainRowDirection(s)) row += move.getValue(s);
                    else if (move.IsContainColDirection(s)) col += move.getValue(s);
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch(FileNotFoundException e){
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static String getCell(int row, int col) {
        return map[row][col];
    }

    public static void drawMap(){
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

    public static int getStartRow() {
        return startRow;
    }

    public static int getStartCol() {
        return startCol;
    }

}
