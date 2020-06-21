package bag;

public class Factory implements IBagFactory {

    private static Factory instance;

    private Factory() {

    }

    public IBag makeBag(String type) {
        if (type.equals("LIFO")) {
            return new LIFOBag();
        } else if (type.equals("FIFO")) {
            return new FIFOBag();
        } else if (type.equals("RANDOM")) {
            return new RANDOMBag();
        } else {
            System.out.println("Wrong bag type");
        }
        return null;
    }

    public static Factory getInstance() {
        if (Factory.instance == null) {
            Factory.instance = new Factory();
        }
        return Factory.instance;
    }
}
