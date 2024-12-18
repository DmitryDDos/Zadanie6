import Zadanie1.*;
import Zadanie2.*;
import Zadanie3.*;
import Zadanie4.*;
import Zadanie5.*;
import Zadanie6.*;
import Zadanie7.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // менюшка
            System.out.println("Выберите действие от 0 до 9: ");
            System.out.println("1 - Задание с кэшированием;");
            System.out.println("2 - Создание аннотации @Invoke");
            System.out.println("3 - Создание аннотации @Default");
            System.out.println("4 - Создание аннотации @ToString");
            System.out.println("5 - Создание аннотации @Validate");
            System.out.println("6 - Создание аннотации @Two");
            System.out.println("7 - Создание аннотации @Cache");
            System.out.println("8 - Обработка аннотаций");
            System.out.println("9 - Тестирование");
            System.out.println("0 - Выход из программы.");
            System.out.print("Выбранное действие: ");

            while (!scanner.hasNextInt()) { // Проверка на ввод числа
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next(); // Очистка ввода
            }
            int d = scanner.nextInt();
            System.out.println();

            if (d < 0 || d > 9) { // Проверка на диапазон допустимых значений числа
                System.out.println("Введено неверное значение!");
                continue;
            }

            switch (d) {
                case 0: // Остановка программы
                    System.out.println("Программа остановлена.");
                    return;

                case 1:
                    System.out.println("Пример кэширования:");
                    AInterface a = Cache.cache(new A("first")); // Используем интерфейс
                    System.out.println(a.cacheTest()); // Вывод: "original method" 42

                    // Изменение поля не влияет на кэш
                    System.out.println(a.cacheTest()); // Вывод: 42 (кэшированное значение)

                    System.out.println();
                    break;

                case 2:
                    InvokeExample cache = new InvokeExample(); // Создаем экземпляр класса Cache
                    System.out.println("Вызов аннотированного метода из Cache:");
                    MethodInvoker.invokeAnnotatedMethods(cache);

                    System.out.println();
                    break;

                case 3:
                    System.out.println("Создание аннотации @Default:");

                    // Создаем экземпляр аннотированного класса
                    DefaultExample example = new DefaultExample();
                    example.display();

                    // Получение аннотации на уровне класса
                    Default classAnnotation = DefaultExample.class.getAnnotation(Default.class);
                    if (classAnnotation != null) {
                        System.out.println("Аннотация @Default на классе: " + classAnnotation.value().getName());
                    }

                    // Получение аннотации на уровне поля
                    try {
                        Default fieldAnnotation = DefaultExample.class.getDeclaredField("exampleField").getAnnotation(Default.class);
                        if (fieldAnnotation != null) {
                            System.out.println("Аннотация @Default на поле: " + fieldAnnotation.value().getName());
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }

                    System.out.println();
                    break;

                case 4:
                    System.out.println("Создание аннотации @ToString:");

                    // Создаем экземпляр аннотированного класса
                    ToStringExample Example = new ToStringExample("Дмитрий Дудин", 21);

                    // Проверяем аннотацию на уровне класса
                    ToString ClassAnnotation = ToStringExample.class.getAnnotation(ToString.class);
                    if (ClassAnnotation != null) {
                        System.out.println("Аннотация @ToString на классе: " + ClassAnnotation.value());
                    }

                    // Проверяем аннотацию на уровне поля
                    try {
                        ToString fieldAnnotation = ToStringExample.class.getDeclaredField("name").getAnnotation(ToString.class);
                        if (fieldAnnotation != null) {
                            System.out.println("Аннотация @ToString на поле 'name': " + fieldAnnotation.value());
                        }
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }

                    // Выводим информацию об объекте
                    System.out.println("Информация о объекте: " + Example);

                    System.out.println();
                    break;

                case 5:
                    System.out.println("Создание аннотации @Validate:");

                    // Проверяем аннотацию на уровне класса ValidateExample
                    Validate validateAnnotation = ValidateExample.class.getAnnotation(Validate.class);
                    if (validateAnnotation != null) {
                        System.out.println("Аннотация @Validate на классе ValidateExample:");
                        for (Class<?> clazz : validateAnnotation.value()) {
                            System.out.println("Тип: " + clazz.getName());
                        }
                    } else {
                        System.out.println("Аннотация @Validate не найдена на классе ValidateExample.");
                    }

                    // Проверяем аннотацию на уровне аннотации ValidatedData
                    ValidatedData validatedDataAnnotation = ValidateExample.class.getAnnotation(ValidatedData.class);
                    if (validatedDataAnnotation != null) {
                        System.out.println("Аннотация @ValidatedData на классе ValidateExample найдена.");
                    } else {
                        System.out.println("Аннотация @ValidatedData не найдена на классе ValidateExample.");
                    }

                    System.out.println();
                    break;

                case 6:
                    System.out.println("Создание экземпляра TwoExample:");

                    TwoExample twoExample = new TwoExample("До нового года осталось", 12);
                    twoExample.displayInfo(); // Вывод информации об экземпляре

                    System.out.println();
                    break;

                case 7:
                    System.out.println("Создание аннотации @Cache:");

                    // Проверяем аннотацию на уровне класса CacheExample
                    CacheA cacheAnnotation = CacheExample.class.getAnnotation(CacheA.class);
                    if (cacheAnnotation != null) {
                        System.out.println("Аннотация @Cache на классе CacheExample:");
                        System.out.println("value: " + String.join(", ", cacheAnnotation.value()));
                    } else {
                        System.out.println("Аннотация @Cache не найдена на классе CacheExample.");
                    }

                    // Создание экземпляра CacheExample для демонстрации
                    CacheExample ex = new CacheExample("Notebook", 100000);
                    ex.displayInfo(); // Вывод информации

                    System.out.println();
                    break;

                case 8:
                    System.out.println("Обработка аннотаций и кэширование:");

                    // Создаем экземпляр A и кэшируем его
                    Zadanie8.A a2 = new Zadanie8.A("Тестовый объект");
                    Zadanie8.AInterface proxyA = Zadanie8.Cache.cache(a2);

                    // Вызов метода, который будет кэшироваться
                    System.out.println("Вызов метода cacheTest:");
                    System.out.println(proxyA.cacheTest()); // Ожидается вывод: "original method" 42

                    // Вызов метода снова, должен вернуть кэшированное значение
                    System.out.println("Вызов метода cacheTest снова:");
                    System.out.println(proxyA.cacheTest()); // Ожидается вывод: 42 (кэшированное значение)

                    System.out.println();
                    break;

                case 9:
                    System.out.println("Запуск тестов кэширования:");

                    // Создаем экземпляр CacheTest
                    Zadanie8.CacheTest cacheTest = new Zadanie8.CacheTest();

                    // Запускаем тесты
                    cacheTest.runTests();

                    System.out.println();
                    break;
            }
        }
    }
}