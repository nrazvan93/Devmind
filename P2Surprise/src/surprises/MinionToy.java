package surprises;

public class MinionToy implements ISurprise {

    private static String[] minionTypes = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
    private static int count = 0;
    private String name;

    private MinionToy(String name) {
        this.name = name;
    }

    public static MinionToy generate() {
        if (count == minionTypes.length) {
            count = 0;
            return new MinionToy(minionTypes[count++]);
        } else {
            return new MinionToy(minionTypes[count++]);
        }
    }

    @Override
    public void enjoy() {
        System.out.println(this);
    }

    public String toString() {
        return "This surprise has a minion " + this.name + " in it.";
    }
}
