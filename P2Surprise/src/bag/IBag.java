package bag;

import surprises.ISurprise;

import java.util.Random;

public interface IBag {

    Random ran = new Random();

    void put(ISurprise newSurprise);

    void put(IBag bagOfSurprises);

    ISurprise takeOut();

    boolean isEmpty();

    int size();

}
