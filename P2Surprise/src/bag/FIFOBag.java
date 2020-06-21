package bag;

import surprises.ISurprise;

public class FIFOBag extends AbstractBag {

    @Override
    public ISurprise takeOut() {
        return this.bag.remove(0);
    }

    public String toString() {
        return "FIFO bag:" + super.getBag();
    }

}
