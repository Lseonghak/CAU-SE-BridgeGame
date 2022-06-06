public class Player extends User{
    private String currentPlace;
    private int currentRow;
    private int currentCol;
    private int myIndex;
    private GatheredCard gatheredCard;
    private int rank;

    Player(int row, int col){

//        currentPlace = "0 0";
        currentRow = row;
        currentCol = col;
        gatheredCard = new GatheredCard();
        rank=-1;
    }

//    public void setCurrentPlace(String currentPlace) {
//        this.currentPlace = currentPlace;
//    }

    public String getCurrentPlace() {
        return currentPlace;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }


    public void setMyIndex(int myIndex) {
        this.myIndex = myIndex;
    }

    public int getMyIndex() {
        return myIndex;
    }

//    public String getCard(String card){
//
//    }
    public void UpdateState(int row, int col){
        currentRow = row;
        currentCol = col;
    }
    public void getCard(String card){
        gatheredCard.setCard(card);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public void printCard(){
        System.out.println("P :" + gatheredCard.getP());
        System.out.println("H :" + gatheredCard.getH());
        System.out.println("S :" + gatheredCard.getS());
        System.out.println("Bridge :" + gatheredCard.getBridge());
        System.out.println("Score :" + gatheredCard.getScore());
    }
}
