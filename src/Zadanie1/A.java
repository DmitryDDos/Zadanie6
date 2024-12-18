package Zadanie1;

public class A implements AInterface {
    String stringField;

    public A(String str) {
        stringField = str;
    }

    @Override
    public int cacheTest() {
        System.out.println("original method");
        return 42;
    }

    @Override
    public String toString() {
        return stringField;
    }
}