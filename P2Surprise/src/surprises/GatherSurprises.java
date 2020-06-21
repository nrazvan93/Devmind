package surprises;

import java.util.Random;

public final class GatherSurprises {

    private static Random ran = new Random();
    private static final String[] surpriseType = {"fortune", "candie", "minion"};

    private GatherSurprises() {
    }

    public static ISurprise gather() {
        int r = ran.nextInt(surpriseType.length);
        if (r == 0) {
            return FortuneCookie.generate();
        } else if (r == 1) {
            return Candies.generate();
        } else {
            return MinionToy.generate();
        }
    }

    public static ISurprise[] gather(int n) {
        ISurprise[] result = new ISurprise[n];
        for (int i = 0; i < n; i++) {
            int r = ran.nextInt(surpriseType.length);
            if (r == 0) {
                result[i] = FortuneCookie.generate();
            } else if (r == 1) {
                result[i] = Candies.generate();
            } else {
                result[i] = MinionToy.generate();
            }
        }
        return result;
    }
}
