package Zadanie4;

@ToString(value = "YES")
public class ToStringExample { // Аннотируем класс
    @ToString(value = "NO") // Аннотируем поле
    private String name;

    private int age;

    public ToStringExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределяем метод toString
    @Override
    public String toString() {
        return "ToStringExample{" +
                "Имя = '" + name + '\'' +
                ", возраст = " + age +
                '}';
    }
}