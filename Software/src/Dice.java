import java.util.Random;

public class Dice {
    private Random random;
    private int maxNum = 6;

    public Dice(){
        random = new Random();
    }
    public int getNumber(){
        return random.nextInt(maxNum)+1;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
}
