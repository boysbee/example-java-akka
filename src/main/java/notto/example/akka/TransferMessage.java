package notto.example.akka;

import akka.actor.ActorRef;

/**
 * Created by nchatmalairut on 4/23/2016.
 */
public class TransferMessage {
    private ActorRef from;
    private int amount;
    private ActorRef to;

    public TransferMessage(ActorRef from, ActorRef to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public ActorRef getFrom() {
        return from;
    }

    public int getAmount() {
        return amount;
    }

    public ActorRef getTo() {
        return to;
    }
}
