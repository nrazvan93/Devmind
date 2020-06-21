package bag;

import surprises.ISurprise;

public class RANDOMBag extends AbstractBag {

    @Override
    public ISurprise takeOut() {
        return this.bag.remove(ran.nextInt(this.size()));
    }

    public String toString() {
        return "RANDOM bag:" + super.getBag();
    }
}

