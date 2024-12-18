package Zadanie5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определяем аннотацию @Validate
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE}) // Может применяться к типам и аннотациям
public @interface Validate {
    Class<?>[] value(); // Обязательное свойство, массив классов
}