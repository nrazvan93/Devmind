package main;

import bag.FIFOBag;
import bag.Factory;
import bag.IBag;
import bag.LIFOBag;
import surprises.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int waitTime = 1;

        GiveSupriseAndApplause giveSupriseAndApplauseFIFO = new GiveSupriseAndApplause("FIFO", waitTime);
        GiveSupriseAndApplause giveSupriseAndApplauseLIFO = new GiveSupriseAndApplause("LIFO", waitTime);
        GiveSupriseAndApplause giveSupriseAndApplauseRANDOM = new GiveSupriseAndApplause("RANDOM", waitTime);
        GiveSurpriseAndHug giveSurpriseAndHugFIFO = new GiveSurpriseAndHug("FIFO", waitTime);
        GiveSurpriseAndHug giveSurpriseAndHugLIFO = new GiveSurpriseAndHug("LIFO", waitTime);
        GiveSurpriseAndHug giveSurpriseAndHugRANDOM = new GiveSurpriseAndHug("RANDOM", waitTime);
        GiveSurpriseAndSing giveSurpriseAndSingFIFO = new GiveSurpriseAndSing("FIFO", waitTime);
        GiveSurpriseAndSing giveSurpriseAndSingLIFO = new GiveSurpriseAndSing("LIFO", waitTime);
        GiveSurpriseAndSing giveSurpriseAndSingRANDOM = new GiveSurpriseAndSing("RANDOM", waitTime);


        for (ISurprise s : GatherSurprises.gather(5)) {
            giveSupriseAndApplauseFIFO.put(s);
            giveSupriseAndApplauseLIFO.put(s);
            giveSupriseAndApplauseRANDOM.put(s);
            giveSurpriseAndHugFIFO.put(s);
            giveSurpriseAndHugLIFO.put(s);
            giveSurpriseAndHugRANDOM.put(s);
            giveSurpriseAndSingFIFO.put(s);
            giveSurpriseAndSingLIFO.put(s);
            giveSurpriseAndSingRANDOM.put(s);
        }


        System.out.println(giveSupriseAndApplauseFIFO.toString());
        System.out.println(giveSupriseAndApplauseLIFO.toString());
        System.out.println(giveSupriseAndApplauseRANDOM.toString());
        System.out.println(giveSurpriseAndHugFIFO.toString());
        System.out.println(giveSurpriseAndHugLIFO.toString());
        System.out.println(giveSurpriseAndHugRANDOM.toString());
        System.out.println(giveSurpriseAndSingFIFO.toString());
        System.out.println(giveSurpriseAndSingLIFO.toString());
        System.out.println(giveSurpriseAndSingRANDOM.toString());

        giveSupriseAndApplauseFIFO.giveAll();
        giveSupriseAndApplauseLIFO.giveAll();
        giveSupriseAndApplauseRANDOM.giveAll();
        giveSurpriseAndHugFIFO.giveAll();
        giveSurpriseAndHugLIFO.giveAll();
        giveSurpriseAndHugRANDOM.giveAll();
        giveSurpriseAndSingFIFO.giveAll();
        giveSurpriseAndSingLIFO.giveAll();
        giveSurpriseAndSingRANDOM.giveAll();


    }
}
