package Zadanie5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в рантайме
public @interface ValidatedData {
    // Здесь можно добавить параметры, если нужно
}