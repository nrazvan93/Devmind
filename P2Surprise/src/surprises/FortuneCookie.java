package surprises;

public class FortuneCookie implements ISurprise {

    private static String[] sayings = {"\"The greatest glory in living lies not in never falling, but in rising every time we fall.\" -Nelson Mandela\n",
            "\"The way to get started is to quit talking and begin doing.\" -Walt Disney\n",
            "\"Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.\" -Steve Jobs\n",
            "\"If life were predictable it would cease to be life, and be without flavor.\" -Eleanor Roosevelt\n",
            "\"If you look at what you have in life, you'll always have more. If you look at what you don't have in life, you'll never have enough.\" -Oprah Winfrey\n",
            "\"If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success.\" -James Cameron\n",
            "\"Life is what happens when you're busy making other plans.\" -John Lennon\n",
            "\"Spread love everywhere you go. Let no one ever come to you without leaving happier.\" -Mother Teresa\n",
            "\"When you reach the end of your rope, tie a knot in it and hang on.\" -Franklin D. Roosevelt\n",
            "\"Always remember that you are absolutely unique. Just like everyone else.\" -Margaret Mead\n",
            "\"Don't judge each day by the harvest you reap but by the seeds that you plant.\" -Robert Louis Stevenson\n",
            "\"The future belongs to those who believe in the beauty of their dreams.\" -Eleanor Roosevelt\n",
            "\"Tell me and I forget. Teach me and I remember. Involve me and I learn.\" -Benjamin Franklin\n",
            "\"The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.\" -Helen Keller\n",
            "\"It is during our darkest moments that we must focus to see the light.\" -Aristotle\n",
            "\"Whoever is happy will make others happy too.\" -Anne Frank\n",
            "\"Do not go where the path may lead, go instead where there is no path and leave a trail.\" -Ralph Waldo Emerson\n",
            "\"You will face many defeats in life, but never let yourself be defeated.\" -Maya Angelou\n",
            "\"The greatest glory in living lies not in never falling, but in rising every time we fall.\" -Nelson Mandela\n",
            "\"In the end, it's not the years in your life that count. It's the life in your years.\" -Abraham Lincoln\n",
            "\"Never let the fear of striking out keep you from playing the game.\" -Babe Ruth\n",
            "\"Life is either a daring adventure or nothing at all.\" -Helen Keller\n",
            "\"Many of life's failures are people who did not realize how close they were to success when they gave up.\" -Thomas A. Edison\n",
            "\"You have brains in your head. You have feet in your shoes. You can steer yourself any direction you choose.\" -Dr. Seuss"};

    private String saying;

    private FortuneCookie(String s) {
        this.saying = s;
    }

    public static FortuneCookie generate() {
        return new FortuneCookie(sayings[ran.nextInt(sayings.length)]);
    }

    @Override
    public void enjoy() {
        System.out.println(this);
    }

    public String toString() {
        return this.saying;
    }
}
