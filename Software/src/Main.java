import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main{
    private static Map map;
    private static int startRow;
    private static int startCol;
    private static int numOfParticipants; //게임 참가 인원
    private static ArrayList<Player> player;
    private static Dice dice = new Dice();
    private static Move move = new Move();

    private final static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/default.map";
//    private static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/another.map";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        new EventFireGui();

//      ---------------------------------------------지도 관련 코드-------------------------------------------
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

//      ---------------------------------------------게임 인원 관련 코드-------------------------------------------

        do{
            System.out.print("게임 인원(2~4인) : ");
            numOfParticipants = Integer.parseInt(sc.nextLine());
        }while(numOfParticipants<2 || numOfParticipants >4);

        // 플레이어 객체 생성
        player = new ArrayList<Player>();
        // arraylist에 객체 add
        for (int i=0; i<numOfParticipants; i++){
            Player member = new Player(startRow, startCol);
            member.setMyIndex(i);
            player.add(member);
        }

//      ---------------------------------------------게임 진행 코드-------------------------------------------

        int index = 0;
        while(true){
            index %= 4;

            // 차례 알려주기
            System.out.println("turn : " + player.get(index).getMyIndex());

            // 주사위 돌리기
            int gained_number = 6;
            System.out.println("gained_number :" + gained_number);

            int row;
            int col;
            while(true) {
                boolean flag = true; // player의 말이 잘못 움직이면 false
                // 움직이는 방향 입력받기
                System.out.print("enter your direction : ");
                String str = sc.nextLine().replaceAll("\\s", "");
                ;

                String[] arr = str.split("(?<!^)");
//            for(int i=0; i<arr.length; i++) System.out.printf("%s, ",arr[i]);
                row = player.get(index).getCurrentRow();
                col = player.get(index).getCurrentCol();

                // 입력한 문자 수와 주사위 수가 같은지를 확인
                if (arr.length == gained_number) {
                    for (int i = 0; i < gained_number; i++) {
                        // index에 위치한 문자가 u,r,d,l에 있는지 판단
                        if (move.IsContain(arr[i])) {
                            HashMap<String, Integer> direction = move.getDirection(arr[i]);
                            // index에 위치한 문자가 row인지 col인지 판단
                            if (direction.keySet().toArray()[0].equals("row") && map.getCell(direction.get("row")+row,col)!=null){
                                row += direction.get("row");
                            }else if (direction.keySet().toArray()[0].equals("col") && map.getCell(row,col+direction.get("col"))!=null){
                                col += direction.get("col");
                            }else flag = false;

                        }else flag = false;
//                        if (arr[i].equals('u') || arr[i].equals("U"))  col--;
//                        else if (arr[i].equals('d') || arr[i].equals('D')) col++;
//                        else if (arr[i].equals('r') || arr[i].equals('R')) row++;
//                        else if (arr[i].equals('l') || arr[i].equals('l')) row--;
//                        else System.out.println("String error");
                    }
                }else flag = false;

                if (!flag){
                    System.out.println("String error");
                    continue;
                }
//                row = player.get(index).getCurrentRow() + row;
//                col = player.get(index).getCurrentCol() + col;
                if (map.getCell(row, col) != null) {
                    player.get(index).getCard(map.getCell(row, col));
                    player.get(index).UpdateState(row, col);
                    System.out.println("player's state : " + player.get(index).getCurrentRow() + player.get(index).getCurrentCol());
                    break;
                }


            }

            index++;
            break;
        }
    }
}