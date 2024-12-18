package Zadanie5;

@ValidatedData // Применяем аннотацию к классу
@Validate(value = {String.class, Integer.class})
public// Аннотируем класс
class ValidateExample {
    private String username;
    private int userId;

    public ValidateExample(String username, int userId) {
        this.username = username;
        this.userId = userId;
    }
}