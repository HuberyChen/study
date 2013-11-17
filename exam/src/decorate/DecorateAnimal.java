package decorate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * @author hubery.chen
 * @date (2013-11-17 12:01)
 */
public class DecorateAnimal implements Animal {

    private Animal animal;

    private Class<? extends Feature> feature;

    public DecorateAnimal(Animal _animal, Class<? extends Feature> _feature) {
        this.animal = _animal;
        this.feature = _feature;
    }

    @Override
    public void doStuff() {
        InvocationHandler handler = new InvocationHandler() {
            //proxy.method(args)
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                Object obj = null;
                if (Modifier.isPublic(method.getModifiers())) {
                    obj = method.invoke(feature.newInstance(), args);
                }
                animal.doStuff();
                return obj;
            }
        };

        ClassLoader loader = getClass().getClassLoader();

        Feature proxy = (Feature) Proxy.newProxyInstance(loader, feature.getInterfaces(), handler);

        proxy.load();
    }
}
