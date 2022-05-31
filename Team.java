package JavaCore_1;

import java.util.stream.IntStream;

public class Team {
    private String team_name;                   //название команды
    private String[] members = new String[4];   //создание массива членов команды
    private boolean [] result = new boolean[4]; //создание массива результатов по каждому члену команды
    private String test;

    public Team(String team_name, String[] members) {
        this.team_name = team_name;
        this.members = members;
    }

    public void showMembers() {     // вывод на экран всех членов команды
        System.out.println("Команда " + team_name + ":");
        for (String member : this.members) {
            System.out.println(member);
        }
    }
    public void showResults() {     // участники,прошедшие дистанцию
        System.out.println("Участники команды " + team_name + ", прошедшие " + this.test);
        for (int i=0; i < 4; i++) {
            if (result[i]) {
                System.out.println(members[i]);
            }
        }
    }
        // метод, заполняющий таблицу результатов значеними true-false
    public void setResult(int idx, boolean res) {
        this.result[idx] = res;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

