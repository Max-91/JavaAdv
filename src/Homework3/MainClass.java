package Homework3;

import java.util.HashMap;
import java.util.Map;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и
вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно
добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
учесть, что под одной фамилией может быть несколько телефонов (в случае
однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class MainClass {
    public static void main(String[] args) {
        // Задание 1
        String[] words = {
                "самолет", "ребенок", "вертолет", "мир", "море", "берег",
                "солнце", "мир", "марс", "земля", "солнце", "море", "солнце"};
        Map<String, Integer> mapWords = new HashMap<>();
        // Заполнение map
        for (String word : words) {
            Integer count = mapWords.getOrDefault(word, 0);
            mapWords.put(word, count + 1);
        }
        System.out.println(mapWords);
        // Задание 2
        PhoneBook phoneBook= new PhoneBook();
        phoneBook.Add("Иванов",new String[]{"123","84991733533"});
        phoneBook.Add("Петров",new String[]{"+79991112233"});
        phoneBook.Add("Сидоров",new String[]{"03"});

        //System.out.println(phoneBook.toString()); // Проверка - отображение всей тел.книги

        phoneBook.Get("Иванов");
    }
}

