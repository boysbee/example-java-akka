package notto.example.akka;

/**
 * Created by nchatmalairut on 4/23/2016.
 */
public class DepositMessage {
    private int amount;

    public DepositMessage(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
