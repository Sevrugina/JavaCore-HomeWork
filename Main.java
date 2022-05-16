package JavaCore_1;

public class Main {

    public static void main(String[] args) {
        String[] s = {"Илья", "Петр", "Максим", "Ирина"};//инициализация массива участников
	    Team team = new Team("\"Победа\"", s );
        Course c = new Course(2);   //массив из 5 препятствий, задаем номер препятствия
        team.showMembers();              //вывести на экран всех участников команды
        c.doIt(team);                    //пройти препятствие № obst участнику команды
        team.showResults();              //вывести на экран участников,прошедших препятствие
    }
}
