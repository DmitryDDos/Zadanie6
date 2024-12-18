package Zadanie8;

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
        // Проверяем, что метод имеет аннотацию @Cache
        CacheA cacheAnnotation = method.getAnnotation(CacheA.class);
        if (cacheAnnotation != null) {
            // Получаем методы для кэширования
            String[] methodsToCache = cacheAnnotation.methods();

            // Если указаны методы, проверяем, что текущий метод в этом списке
            if (methodsToCache.length > 0) {
                boolean shouldCache = false;
                for (String methodName : methodsToCache) {
                    if (method.getName().equals(methodName)) {
                        shouldCache = true;
                        break;
                    }
                }
                if (!shouldCache) {
                    return method.invoke(target, args); // Не кэшируем, если метод не в списке
                }
            }

            // Если метод не имеет параметров, кэшируем
            if (args == null || args.length == 0) {
                if (!cache.containsKey(method)) {
                    Object result = method.invoke(target, args); // Вызов метода через рефлексию
                    cache.put(method, result); // Кэшируем результат
                    return result;
                } else {
                    return cache.get(method); // Возвращаем кэшированное значение
                }
            }
        }

        // Если аннотация отсутствует или метод имеет параметры, просто вызываем метод
        return method.invoke(target, args);
    }
}