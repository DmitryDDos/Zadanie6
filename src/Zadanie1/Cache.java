package Zadanie1;

import java.lang.reflect.Proxy;

public class Cache {

    public static <T> T cache(T obj) {
        @SuppressWarnings("unchecked") // Подавляем предупреждение
        T proxy = (T) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new CacheHandler(obj)
        );
        return proxy;
    }
}