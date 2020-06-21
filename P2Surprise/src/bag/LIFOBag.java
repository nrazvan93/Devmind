package bag;

import surprises.ISurprise;

public class LIFOBag extends AbstractBag {

    @Override
    public ISurprise takeOut() {
        return this.bag.remove(this.size() - 1);
    }

    public String toString() {
        return "LIFO bag:" + super.getBag();
    }
}