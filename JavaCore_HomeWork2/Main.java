package JavaCore_HomeWork2;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        //  ПРОВЕРКА ТРЕХ МАССИВОВ НА ВАЛИДНОСТЬ, ВОЗВРАТ В ПРОГРАММУ

        //              МАССИВ НЕВАЛИДНЫЙ: ВТОРАЯ СТРОКА-ТРИ ЭЛЕМЕНТА
        String [][] twoArr1 = {{"one","two","three","four"},{"1","2","3"},{"a","b","c","d"},{"8","8","8","8"}};
        System.out.println("Массив 1\n"+Arrays.deepToString(twoArr1).replace("], ", "]\n"));
        try {
            System.out.println("Результат " + checkingSizeArray(twoArr1));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

        //              МАССИВ НЕВАЛИДНЫЙ: 3*4
        String [][] twoArr2 = {{"one","two","three","four"},{"1","2","3","4"},{"a","b","c","d"}};
        System.out.println("Массив 2\n"+Arrays.deepToString(twoArr2).replace("], ", "]\n"));
        try {
            System.out.println("Результат " + checkingSizeArray(twoArr2));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

        //              МАССИВ НЕВАЛИДНЫЙ 4*4, НЕДОПУСТИМЫЙ СИМВОЛ
        String [][] twoArr3 = {{ "8", "101","56","99"},{"1","2","3","4"},{"1","7","=","777"},{"8","8","8","8"}};
        System.out.println("Массив 3\n"+Arrays.deepToString(twoArr3).replace("], ", "]\n"));
        try {
            System.out.println("Результат: " + checkingSizeArray(twoArr3));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

        //              МАССИВ ВАЛИДНЫЙ 4*4
        String [][] twoArr4 = {{ "8", "101","56","99"},{"1","2","3","4"},{"1","7","17","777"},{"8","8","8","8"}};
        System.out.println("Массив 4\n"+Arrays.deepToString(twoArr4).replace("], ", "]\n"));
        try {
            System.out.println("Сумма элементов массива " + checkingSizeArray(twoArr4));
        }
        catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e);
        }

    }


    static int checkingSizeArray(String[][] a) throws MyArraySizeException, MyArrayDataException {
        if (a.length != 4) {
            throw new MyArraySizeException( "Массив не 4x4!" );
        }
        for (int i = 0; i < 4; i++)
            if (a[i].length != 4) {
                throw new MyArraySizeException( "Массив не симметричный!" );
            }
        // ПРЕОБРАЗОВАНИЕ МАССИВА К INT
        int sum = 0;
        for (int l = 0; l < 4 ; l++) {
            for (int m = 0; m < 4 ; m++) {
                try {
                    int x = Integer.parseInt(a[l][m]);
                    sum += x;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException( "Элемент массива("+ l +", "+ m + ") некорректен " + e );
                }

            }

        }
        return sum;
    }
}
