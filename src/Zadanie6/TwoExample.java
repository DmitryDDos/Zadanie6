package Zadanie6;

@Two(first = "До нового года осталось", second = 12)
public class TwoExample {
    private String message;
    private int daysLeft;

    public TwoExample(String message, int daysLeft) {
        this.message = message;
        this.daysLeft = daysLeft;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public void displayInfo() {
        System.out.println("TwoExample [Сообщение = " + message + ", значение = " + daysLeft + "]");
    }
}