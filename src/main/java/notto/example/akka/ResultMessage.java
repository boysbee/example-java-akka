package notto.example.akka;

/**
 * Created by nchatmalairut on 4/23/2016.
 */
public class ResultMessage {
    private int balance;
    private String name;

    public ResultMessage(String owner, int balance) {
        this.name = owner;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
