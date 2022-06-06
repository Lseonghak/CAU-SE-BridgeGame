public class GatheredCard extends Card{
    private int score;
    CellScore cellScore;

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

    public void setP(int p) {
        this.p = p;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getBridge() {
        return bridge;
    }

    public void setBridge(int bridge) {
        this.bridge = bridge;
    }

    public void setScore(int score) {
        this.score = score;
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

    }
}
