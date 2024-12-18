package Zadanie3;

@Default(value = String.class) // Аннотируем класс
public class DefaultExample {
    @Default(value = Integer.class) // Аннотируем поле
    private int exampleField;

    // Конструктор
    public DefaultExample() {
        this.exampleField = 0;
    }

    // Метод для демонстрации
    public void display() {
        System.out.println("Example field: " + exampleField);
    }
}