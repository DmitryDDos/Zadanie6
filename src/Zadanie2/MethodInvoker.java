package Zadanie2;

import java.lang.reflect.Method;

public class MethodInvoker {
    public static void invokeAnnotatedMethods(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                // Выводим информацию о том, что метод аннотирован
                System.out.println("Метод " + method.getName() + " аннотирован аннотацией @Invoke.");
                try {
                    Object result = method.invoke(obj); // Вызов метода и получение результата
                    System.out.println("Результат вызова метода: " + result); // Вывод результата
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
