package notto.example.akka;

/**
 * Created by nchatmalairut on 4/23/2016.
 */
public class WithdrawMessage {

    private int amount;

    public WithdrawMessage(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
