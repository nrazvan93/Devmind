package bag;

import surprises.ISurprise;

import java.util.ArrayList;

public abstract class AbstractBag implements IBag {

    ArrayList<ISurprise> bag = new ArrayList<>();

    @Override
    public void put(ISurprise newSurprise) {
        this.bag.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while (!bagOfSurprises.isEmpty()) {
            this.bag.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    @Override
    public int size() {
        return this.bag.size();
    }

    public ArrayList<ISurprise> getBag() {
        return this.bag;
    }

    public String toString() {
        return "This bag contains the surprises:" + this.bag;
    }

}