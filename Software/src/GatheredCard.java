public class GatheredCard extends Card{
    private int score;
    private CellScore cellScore;

    GatheredCard(){
        this.p = 0;
        this.h = 0;
        this.s = 0;
        this.bridge = 0;
        score = 0;
        cellScore = new CellScore();
    }

    public int getP() {
        return p;
    }

    public int getH() {
        return h;
    }

    public int getS() {
        return s;
    }

    public int getBridge() {
        return bridge;
    }

    public int getScore() {
        return score;
    }

    public void setCard(String card){
        if (card.equals("P")){
            p++;
            score += cellScore.getP();
        }
        else if (card.equals("H")){
            h++;
            score += cellScore.getH();
        }
        else if (card.equals("S")){
            s++;
            score += cellScore.getS();
        }
        else if(card.equals("Bridge")){
            bridge++;
        }

    }
}
