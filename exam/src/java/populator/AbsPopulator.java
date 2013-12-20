package populator;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author hubery.chen
 * @date (2013-11-17 13:55)
 */
public abstract class AbsPopulator {

    public void dataInitialing() throws Exception {
        Method[] methods = getClass().getMethods();
        if (null == methods || 0 >= methods.length) {
            return;
        }
        for (Method method : methods) {
            if (isInitDataMethod(method)) {
                method.invoke(this);
            }
        }
    }

    private boolean isInitDataMethod(Method method) {
        return method.getName().startsWith("init") //init开始
            && Modifier.isPublic(method.getModifiers()) //公开方法
            && method.getReturnType().equals(Void.TYPE) //返回值void
            && !method.isVarArgs() //输入参数为空
            && !Modifier.isAbstract(method.getModifiers()); //不能是抽象方法
    }
}
