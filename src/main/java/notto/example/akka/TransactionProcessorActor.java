package notto.example.akka;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by nchatmalairut on 4/23/2016.
 */
public class TransactionProcessorActor extends UntypedActor {

    private LoggingAdapter LOG = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof TransferMessage) {
            LOG.info("transferTo");
            TransferMessage transferMessage = (TransferMessage)message;
            transferMessage.getFrom().tell(new WithdrawMessage(transferMessage.getAmount()), transferMessage.getTo());
        } else if (message instanceof ResultMessage) {
            ResultMessage result = (ResultMessage)message;
            LOG.info("Remaining Balance for " + result.getName() + " is " + result.getBalance());
        } else {
            unhandled(message);
        }
    }

}
