public class Player extends User{
    private String currentPlace;
    private int score;
    private GatheredCard gatheredCard;

    public Player(){
        currentPlace = "0 0";
        gatheredCard = new GatheredCard();
        score = 0;
    }

    public void setCurrentPlace(String currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getCurrentPlace() {
        return currentPlace;
    }
}
