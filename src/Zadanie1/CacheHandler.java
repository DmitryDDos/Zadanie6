package Zadanie1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheHandler implements InvocationHandler {
    private final Object target;
    private final Map<Method, Object> cache = new HashMap<>();

    public CacheHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Проверяем, что метод не имеет параметров
        if (args != null && args.length > 0) {
            return method.invoke(target, args); // Не кэшируем методы с параметрами
        }

        // Если метод не кэширован, вызываем его
        if (!cache.containsKey(method)) {
            Object result = method.invoke(target, args); // Вызов метода через рефлексию
            cache.put(method, result); // Кэшируем результат
            return result;
        } else {
            return cache.get(method); // Возвращаем кэшированное значение
        }
    }
}