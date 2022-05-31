package JavaCore_1;

public class Main {

    public static void main(String[] args) {
        String[] s = {"Илья", "Петр", "Максим", "Ирина"};//инициализация массива участников
	    Team team = new Team("\"Победа\"", s );
        Course c = new Course();         //массив из 5 видов дистанций
        team.showMembers();              //вывести на экран всех участников команды
        c.doIt(team);                    //пройти дистанцию,выбранную рандомно
        team.showResults();              //вывести на экран участников,прошедших дистанцию
    }
}
