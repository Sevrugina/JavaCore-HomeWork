package JavaCore_HomeWork5;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] head = {"value1", "value2", "value3", "value4"};
        int[][] arr = {{1, 2, 3, 4}, {100, 200, 300, 400}, {1000, 2000, 3000, 4000}};
        AppData d = new AppData(head, arr);
        d.toConsole();                  // вывод в консоль
        d.toCSV("temp.csv");            // вывод в файл (temp.csv)
        d.read_CSV("work5.csv");         // чтение из файла (work5.csv)

    }
}

class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }


    // Вывод из файла в консоль для отладки
    public void toConsole() {
        for (int i = 0; i < header.length; i++) {
            System.out.print(header[i]);
            if (i + 1 < header.length)
                System.out.print(";");
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
                if (j + 1 < data[i].length)
                    System.out.print(";");

            }
            System.out.println();
        }
    }

    // По аналогии с консолью вывод инфы в файл
    public void toCSV(String file_name) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(file_name));
            for (int i = 0; i < header.length; i++) {
                out.print(header[i]);
                if (i + 1 < header.length)
                    out.print(";");
            }
            out.println();

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    out.print(data[i][j]);
                    if (j + 1 < data[i].length)
                        out.print(";");

                }
                out.println();
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Чтение из файла
    public void read_CSV(String file_name) {
        try {
            File file = new File(file_name);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


