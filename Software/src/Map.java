import java.io.*;

public class Map {
    private static String[][] map;
    private static int startRow=0;
    private static int startCol=0;

    public Map(String filePath) {

        map = new String[20][20];

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
                    System.out.println("---");
                    startRow = row;
                    startCol = col;
                    flag = false;
                }

                try{
                    map[row][col] = rowLine[0];
                    // map을 배열에 그린다.
                    if (rowLine[rowLine.length-1].equals("R")){col++;}
                    else if(rowLine[rowLine.length-1].equals("D")){row++;}
                    else if(rowLine[rowLine.length-1].equals("U")){row--;}
                    else if(rowLine[rowLine.length-1].equals("L")){col--;}
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }
//                System.out.println(line);
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.
            bufReader.close();
        }catch(FileNotFoundException e){
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static String[][] getMap() {
        return map;
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
