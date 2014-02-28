package pratice.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author hubery.chen
 * @date (2013-11-17 14:24)
 */
public class Utils {

    public static <T> Class<T> getGenericClassType(Class clz) {
        Type type = clz.getGenericSuperclass();
        if (type instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) type;
            Type[] types = pt.getActualTypeArguments();
            if (types.length > 0 && types[0] instanceof ParameterizedType){
                return (Class) types[0];
            }
        }
        return  (Class) Object.class;
    }
}
