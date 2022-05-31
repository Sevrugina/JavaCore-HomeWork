package JavaCore_1;

import java.util.Random;

public class Course {
    private int[] obstacle = new int[5];    //массив препятствий 5шт, в моем случае он не нужен
    int curr_obstacle;                      // переменная - номер препятствия
    public Course(int obst) {
        this.curr_obstacle = obst;
    }
    public void doIt(Team t) {             //участники,прошедшие дистанцию,определяются случайным образом
        t.setTest("Препятствие № " + this.curr_obstacle);
        Random random = new Random();
        for (int j =0; j < 4; j++) {
            t.setResult(j, random.nextBoolean());
        }
    }

    public int getCurr_obstacle() {
        return curr_obstacle;
    }

    public void setCurr_obstacle(int curr_obstacle) {
        this.curr_obstacle = curr_obstacle;
    }
}
