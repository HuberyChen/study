package generic;

/**
 * @author hubery.chen
 * @date (2013-11-17 14:25)
 */
public abstract class BaseDao<T> {

    private Class<T> clz = Utils.getGenericClassType(getClass());

    public void get(long id) {
    }
}
