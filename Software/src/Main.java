import java.util.*;

public class Main{
    private static Map map;
    private static int startRow;
    private static int startCol;
    private static int numOfParticipants; //게임 참가 인원
    private static ArrayList<Player> player;
    private static Dice dice = new Dice();
    private static Move move = new Move();

//    private final static String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/default.map";
    private static final String filePath = "/Users/seonghak/git/CAU-SE-BridgeGame/map/another.map";
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
            try{
                System.out.print("게임 인원(2~4인) : ");
                numOfParticipants = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("try again..");
            }
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
        int rank = 1; // 게임에서 순위를 정하는데 사용됨
        while(rank != numOfParticipants){
            index %= player.size();
            if (player.get(index).getRank() != -1){
                index++;
                continue;
            }

            System.out.println("---------------------------------------");
            // 차례 알려주기
            System.out.println("player " + player.get(index).getMyIndex() + " turn ");
            player.get(index).printCard();
            player.get(index).printCurrentState();

            int selected=0;
            do {
                try {
                    System.out.print("1.roll the dice 2. stay(Bridge -1) : ");
                    selected = Integer.parseInt(sc.nextLine());
                    if (selected == 2) {
                        index++;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("try again..");
                }
            }while(selected!=1 || selected!=2);

            // 주사위 돌리기
//            int gained_number = dice.getNumber();
            int gained_number = 6;
            System.out.println("gained_number :" + gained_number);

            int row;
            int col;
            while(true) {
                boolean flag = true; // player의 말이 잘못 움직이면 false
                // 움직이는 방향 입력받기
                System.out.print("enter your direction(gained_number - Bridge) : ");
                String str = sc.nextLine().replaceAll("\\s", "");
                ;

                String[] arr = str.split("(?<!^)");

                row = player.get(index).getCurrentRow();
                col = player.get(index).getCurrentCol();

                // 입력한 문자 수와 주사위 수가 같은지를 확인
                if (arr.length != gained_number - player.get(index).getBridgeCard()) {
                    System.out.println("num of string error");
                    continue;
                }

                for (String s : arr) {
                    int scale = move.getValue(s);
                    // 다리를 건널 경우
                    if (map.getCell(row,col).equals("B") && (s.equals("r") || s.equals("R"))){
                        do{
                            col += move.getValue(s);
                        }
                        while(map.getCell(row,col) == null);
                        player.get(index).getCard("Bridge");

                    } else if (move.IsContainRowDirection(s) && map.getCell(scale + row, col) != null) {// index에 위치한 문자가 row인지 col인지 판단하고 움직임
                        row += move.getValue(s);
                    } else if (move.IsContainColDirection(s) && map.getCell(row, col + scale) != null) {
                        col += move.getValue(s);
                    } else {
                        flag = false;
                        break;
                    }


                    // end에 도착하면 순위를 측정하고 반복문을 나간다.
                    if(map.getCell(row,col).equals("E")){
                        player.get(index).setRank(rank++);
                        break;
                    }
                }

                if (!flag){
                    System.out.println("String error");
                    continue;
                }
                if (map.getCell(row, col) != null) {
                    player.get(index).getCard(map.getCell(row, col));
                    player.get(index).UpdateState(row, col);
                    break;
                }

            }
//            player.get(index).printCard();
            index++;
        }


//      ---------------------------------------------결과 출력 코드-------------------------------------------

    }
}