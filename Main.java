package JavaCore_HomeWork4;
import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        //1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        //Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        //Посчитать, сколько раз встречается каждое слово.

        String [] arr = {"котик", "собачка", "суслик", "сурок", "хомяк", "котик", "лев", "енот", "котик", "ежик", "лев"};
        System.out.println("Исходный массив слов");
        System.out.println(Arrays.toString(arr));               // печать исходного массива
        Set<String> uniqElems = new HashSet<>(asList(arr));     // печать уникальных элементов массива
        System.out.println("Массив уникальных слов");
        System.out.println(uniqElems);
        counter(arr);
        System.out.println();
        //2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных
        //номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,а с помощью метода
        //get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько
        //телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.


      startPhonebook();
      }

   private static void startPhonebook() {
        Phonebook phonebook = new Phonebook();
        phonebook.addPhonebook("Иванов", " +7 111 111-11-11");
        phonebook.addPhonebook("Петров", " +7 222 222-22-22");
        phonebook.addPhonebook("Сидоров", " +7 333 333-33-33");
        phonebook.addPhonebook("Карпов", " +7 444 444-44-44");
        phonebook.addPhonebook("Иванов", " +7 555 555-55-55");
        phonebook.addPhonebook("Иванов", " +7 666 666-66-66");
        phonebook.addPhonebook("Голубева", " +7 777 777-77-77");
        phonebook.addPhonebook("Синицына", " +7 888 888-88-88");
        phonebook.addPhonebook("Демидов", " +7 999 999-99-99");
        phonebook.addPhonebook("Свиридов", " +7 001 001-01-01");

        System.out.println("Петров: " + phonebook.getPhonebook("Петров"));
        System.out.println("Иванов: " + phonebook.getPhonebook("Иванов"));
        System.out.println("Чехов: " + phonebook.getPhonebook("Чехов"));

    }

    private static void counter(String[] mass) {
        Map<String, Integer> arrayList = new LinkedHashMap<>();
        for (String a : mass) {
            counterW(arrayList, a);
        }
        for (String a: arrayList.keySet()) {
            System.out.print(a + " = " + arrayList.get(a) + "  ");
        }
    }
        private static void counterW(Map<String, Integer> arrayList, String a) {
            if (arrayList.containsKey(a)) {
                arrayList.put(a, arrayList.get(a) + 1);
            } else {
                arrayList.put(a, 1);
            }
        }
    }


