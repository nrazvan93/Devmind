package surprises;

public class Candies implements ISurprise {


    private static String[] candies = {"chocolate", "jelly", "fruits", "vanilla"};
    private int numberOfCandies;
    private int typeOfCandies;

    private Candies(int numberOfCandies, int typeOfCandies) {
        this.numberOfCandies = numberOfCandies;
        this.typeOfCandies = typeOfCandies;
    }

    public static Candies generate() {
        return new Candies( (1 + ran.nextInt(20)), ran.nextInt(candies.length));
    }

    @Override
    public void enjoy() {
        System.out.println(this);
    }

    public String toString() {
        return "This surprise contains " + numberOfCandies + " " + candies[typeOfCandies] + " candies.";
    }
}
