package Zadanie7;

@CacheA(value = {"cache1", "cache2"})
public class CacheExample {
    private String name;
    private int value;

    public CacheExample(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void displayInfo() {
        System.out.println("CacheExample [Название продукции = " + name + ", стоимость = " + value + "]");
    }
}