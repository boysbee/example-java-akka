package notto.example.akka;

import akka.actor.Actor;
import akka.actor.ActorPath;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActorFactory;

/**
 * Created by nchatmalairut on 4/23/2016.
 */
public class BankAkkaApplication {
    public static void main(String[] args) throws InterruptedException {
        ActorSystem system = ActorSystem.create("bankSystem");
        final ActorRef processor =
            system.actorOf(Props.apply(TransactionProcessorActor.class), "processor");


        ActorRef bobAccount = system.actorOf(new Props(new UntypedActorFactory() {
            @Override
            public Actor create() {
                return new AccountActor("Bob", processor, 100);
            }
        }));
        ActorRef aliceAccount = system.actorOf(new Props(new UntypedActorFactory() {
            @Override
            public Actor create() {
                return new AccountActor("Alice", processor, 50);
            }
        }));

        processor.tell(new TransferMessage(bobAccount, aliceAccount, 10), processor);
        processor.tell(new TransferMessage(aliceAccount, bobAccount, 3), processor);

        Thread.sleep(50);
        system.shutdown();
    }
}
