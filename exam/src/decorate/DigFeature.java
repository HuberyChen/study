package decorate;

/**
 * @author hubery.chen
 * @date (2013-11-17 12:01)
 */
public class DigFeature implements Feature {

    @Override
    public void load() {
        System.out.println("can dig...");
    }
}