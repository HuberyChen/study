package pratice.decorate;

/**
 * @author hubery.chen
 * @date (2013-11-17 12:19)
 */
public class Realization {

    public static void main(String[] args) {
        Animal jerry = new Rat();
        jerry = new DecorateAnimal(jerry, FlyFeature.class);
        jerry = new DecorateAnimal(jerry, DigFeature.class);
        jerry.doStuff();
    }
}
