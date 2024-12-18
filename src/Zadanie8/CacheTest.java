package Zadanie8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {

    /*
     * Тестирование метода cache, который создает прокси-объект и
     * проверяет кэширование аннотированного метода.
     */

    @Test
    public void testCache() {
        // Создаем экземпляр класса A, который будет тестироваться
        A a = new A("Тестовый объект");

        // Создаем прокси-объект с помощью метода cache
        AInterface proxyA = Cache.cache(a);

        // Первый вызов метода cacheTest должен вызвать оригинальный метод
        // и вернуть 42, а также вывести "original method"
        int firstCallResult = proxyA.cacheTest();
        assertEquals(42, firstCallResult, "Первый вызов должен вернуть 42");

        // Второй вызов метода cacheTest должен вернуть кэшированное значение
        int secondCallResult = proxyA.cacheTest();
        assertEquals(42, secondCallResult, "Второй вызов должен вернуть кэшированное значение 42 без вызова оригинального метода");
    }

    // Метод для выполнения теста
    public void runTests() {
        testCache(); // Запускаем тест
        System.out.println("Тесты выполнены успешно.");
    }
}