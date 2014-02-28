package pratice.decorate;

/**
 * @author hubery.chen
 * @date (2013-11-17 12:00)
 */
public class FlyFeature implements Feature {

    @Override
    public void load() {
        System.out.println("can fly...");
    }
}
