package lesson3;

import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {

        countWords();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Semenov", "+7 921 111-11-11");
        phoneBook.add("Petrov", "+7 921 222-22-22");
        phoneBook.add("Sidorov", "+7 921 333-33-33");
        phoneBook.add("Ivanov", "+7 921 444-44-44");
        phoneBook.add("Semenov", "+7 921 555-55-55");
        phoneBook.add("Petrov", "+7 921 666-66-66");
        phoneBook.add("Semenov", "+7 921 777-77-77");
        phoneBook.add("Ivanov", "+7 921 888-88-88");
        phoneBook.add("Sidorov", "+7 921 999-99-99");

        phoneBook.display();

        System.out.println();
        String name = "Semenov";
        System.out.println(name + ": " + phoneBook.get(name));


    }

    private static void countWords() {
        String[] strings = {
                "Green", "Yellow", "Black", "Yellow", "Green", "White", "Yellow", "Brown", "Black", "White",
                "Pink", "Black", "Yellow", "Blue", "Brown", "Purple", "White", "Black", "Red", "Red"
        };

        Map<String, Integer> colorsMap = new HashMap<>();

        System.out.println("Количество повторений:");
        for (String string : strings) {
            int value = colorsMap.getOrDefault(string, 0);
            colorsMap.put(string, value + 1);
        }

        System.out.println(colorsMap);
        System.out.println();

        //Вариант 1. Вывод всех слов не имеющих дубликатов
        System.out.println("Слова не имеющих дубликатов");
        colorsMap.forEach((k, v) -> {
            if (v.equals(1)) {
                System.out.print(k + " ");
            }
        });
        System.out.println();

        //Вариант 2. Вывод всех слов по одному разу
        System.out.println();
        System.out.println("Все слова:");
        colorsMap.forEach((k,v) -> System.out.print(k + " "));
        System.out.println();
    }
}
