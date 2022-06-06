public class Player extends User{
    private String currentPlace;
    private int currentRow;
    private int currentCol;
    private int score;
    private GatheredCard gatheredCard;

    public Player(int row, int col){

//        currentPlace = "0 0";
        currentRow = row;
        currentCol = col;
        gatheredCard = new GatheredCard();
        score = 0;
    }

    public void setCurrentPlace(String currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getCurrentPlace() {
        return currentPlace;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public int getScore() {
        return score;
    }
}
