package Zadanie2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target(ElementType.METHOD) // Цель - только методы
public @interface Invoke {
}