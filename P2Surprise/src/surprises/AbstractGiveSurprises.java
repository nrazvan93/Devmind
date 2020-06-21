package surprises;

import bag.Factory;
import bag.IBag;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {

    private static Factory factory = Factory.getInstance();
    private IBag bag;
    private int waitTime;

    public AbstractGiveSurprises(String type, int waitTime) {
        this.bag = factory.makeBag(type);
        this.waitTime = waitTime;
    }

    public void put(ISurprise surprise) {
        this.bag.put(surprise);
    }

    public void put(IBag bagOfSurprises) {
        this.bag.put(bagOfSurprises);
    }

    public void give() {
        ISurprise surprise = this.bag.takeOut();
        surprise.enjoy();
        giveWithPassion();
    }

    public void giveAll() {
        while (!this.bag.isEmpty()) {
            ISurprise surprise = this.bag.takeOut();
            surprise.enjoy();
            giveWithPassion();
            try {
                TimeUnit.SECONDS.sleep(this.waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void giveWithPassion();

    public String toString() {
        return this.bag.toString();
    }

    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

}
