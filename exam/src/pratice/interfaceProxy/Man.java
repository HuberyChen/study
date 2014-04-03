package pratice.interfaceProxy;

/**
 * @author hubery.chen
 */
public class Man implements People {
    @Override
    public String getName() {
        return get("Man");
    }

    private String get(String name) {
        return name;
    }
}
