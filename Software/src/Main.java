import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static Map map;
    private static int startRow;
    private static int startCol;
    private static int numOfParticipants; //게임 참가 인원
    private static ArrayList<Player> player;
    private static Dice dice = new Dice();

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
            numOfParticipants = sc.nextInt();
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
            int gained_number = dice.getNumber();
            System.out.println("gained_number :" + gained_number);

            // 움직이는 방향 입력받기

            System.out.print("enter your direction : ");
            String str = sc.next();

            String[] arr = str.split("(?<!^)");
            for(int i=0; i<arr.length; i++) System.out.printf("%s, ",arr[i]);



            index++;
            break;
        }
    }
}