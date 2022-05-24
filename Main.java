package JavaCore_HomeWork3;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//  Написать метод,который меняет два элемента массива местами (массив может быть любого ссылочного типа)

       String[] arrStr = {"one", "two", "three", "four", "five"};
        Integer[] arrInt = {1, 2, 3, 4, 5};
        Float[] arrFlo = {1.1f, 0.002f, 3.33f, 400.04f, 5.5f};

        System.out.println("Три массива разного типа:");
        System.out.println(Arrays.toString(arrStr));
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arrFlo));

        swapTwoElements(arrStr, 1, 4);
        swapTwoElements(arrInt, 1, 4);
        swapTwoElements(arrFlo, 1, 4);

        System.out.println("Поменяли местами элементы с индексами 1 и 4, метод один для всех типов");
        System.out.println(Arrays.toString(arrStr));
        System.out.println(Arrays.toString(arrInt));
        System.out.println(Arrays.toString(arrFlo));

        // Коробки с фруктами

        System.out.println("Коробки с фруктами ");

        Box box1 = new Box();
        box1.addFruit(new Apple(1.0));
        box1.addFruit(new Apple(1.0));
        box1.addFruit(new Apple(1.0));
        box1.addFruit(new Orange(1.5)); // попытка положить апельсины к яблокам
        box1.prnBox();                      // в коробке box1 три яблока
        System.out.println("Total weight of the box: " + box1.getWeight());

        Box box2 = new Box();
        box2.addFruit(new Orange(1.5));
        box2.addFruit(new Orange(1.5));
        box2.addFruit(new Orange(1.5));
        box2.addFruit(new Orange(1.5));
        box2.addFruit(new Apple(1.0));  // попытка положить яблоки к апельсинам
        box2.prnBox();                      // в коробке box2 четыре апельсина
        System.out.println("Total weight of the box: " + box2.getWeight());

        if (box1.compare(box2)) System.out.println("Коробки весят одинаково");
        else System.out.println("Коробки имеют разный вес");

        Box box3 = new Box();   // перекладываем фрукты из коробки в новую коробку
        box3.addBox(box1);      // теперь в box3 яблоки
        box3.prnBox();
        box1.prnBox();          // коробка box1 пустая
    }

    private static <T> void swapTwoElements(T[] array, int index1, int index2) {
        T element = array[index1];
        array[index1] = array[index2];
        array[index2] = element;
    }
}
//      ФРУКТЫ В КОРОБКАХ

class Fruit {
String name;

double weight;

public String getName() {
    return name;
}

public double getWeight() {
    return weight;
}
}

class Apple extends Fruit {
    public Apple(double val) {
        name = "Apple";
        weight = val;
    }
}

class Orange extends Fruit {
    public Orange(double val) {
        name = "Orange";
        weight = val;
    }
}


class Box {
ArrayList<Fruit> arr = new ArrayList<>();

public void addFruit(Fruit fr) {
    if (arr.size() == 0 || arr.get(0).name.equals(fr.name)) // апельсины нельзя добавить к яблокам
        arr.add(fr);
}

public void prnBox() {
    if (arr.size() == 0) {
        System.out.println("Коробка пустая");
        return;
    }
    for (Fruit fruit : arr) {
        System.out.println( fruit.getName() + " " + fruit.getWeight());
    }
}

public double getWeight() {
    double total = 0;
    for (Fruit fruit : arr)
        total += fruit.getWeight();
    return total;
}

public boolean compare(Box bx) {
    return getWeight() == bx.getWeight();
}

public void addBox(Box bx) {
    for (Fruit fruit : bx.arr)
        arr.add(fruit);
    bx.arr.clear();
}
}
