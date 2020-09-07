package learn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFooApi implements InvocationHandler {

    private FooApi fooApi;

    public ProxyFooApi(FooApi fooApi) {
        this.fooApi = fooApi;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(fooApi,args);
    }

    public static void main(String[] args) {
        InvocationHandler invocationHandler = new ProxyFooApi(new FooApiIml());
        Class<?>[] clazzs = {FooApi.class};
        FooApi fooApi = (FooApi)Proxy.newProxyInstance(invocationHandler.getClass().getClassLoader(), clazzs, invocationHandler);
        fooApi.foo("213123123123");

    }
}
