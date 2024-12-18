package Zadanie4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определяем аннотацию @ToString
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD}) // Может применяться к типам и полям
public @interface ToString {
    String value() default "YES"; // Необязательное свойство со значением по умолчанию YES
}
