package surprises;

public class GiveSupriseAndApplause  extends  AbstractGiveSurprises{

    public GiveSupriseAndApplause(String type, int waitTime) {
        super(type,waitTime);
    }

    protected void giveWithPassion() {
        System.out.println("Loud applause to you… For it is in giving that we receive.");
    }
}
