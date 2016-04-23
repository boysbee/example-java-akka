package notto.example.akka;

/**
 * Created by nchatmalairut on 4/23/2016.
 */
public class TransactionProcessor implements Runnable {
    private Account from;
    private Account to;
    private int amount;

    public TransactionProcessor(Account source, Account target, int amt) {
        from = source;
        to = target;
        amount = amt;
    }

    @Override
    public void run() {
        from.transferTo(to, amount);
    }
}
