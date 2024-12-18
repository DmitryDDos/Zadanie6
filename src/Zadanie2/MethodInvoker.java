package Zadanie2;

import java.lang.reflect.Method;

public class MethodInvoker {
    public static void invokeAnnotatedMethods(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    method.invoke(obj); // Вызов метода
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
