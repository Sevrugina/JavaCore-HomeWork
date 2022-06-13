
import java.util.Arrays;
import java.util.List;
import java.util.Random;

    public class Data {

        public static List<Student> getStudentsList() {
            // Список курсов
            Course course1 = new Course("Кулинария");
            Course course2 = new Course("Рисование");
            Course course3 = new Course("Вязание");
            Course course4 = new Course("Валяние");
            Course course5 = new Course("Бисероплетение");
            Course course6 = new Course("Кройка и шитье");
            Course course7 = new Course("Флористика");
            Course course8 = new Course("Ландшафтный дизайн");
            Course course9 = new Course("Риторика");
            Course course10 = new Course("Сценическая речь");
            Course course11 = new Course("Психология");
            Course course12 = new Course("Гончарное дело");

            // Список студентов
            Student student1 = new Student("Студент_1", Arrays.asList(course1, course3, course5));
            Student student2 = new Student("Студент_2", Arrays.asList(course1, course2, course3));
            Student student3 = new Student("Студент_3", Arrays.asList(course1, course7, course11));
            Student student4 = new Student("Студент_4", Arrays.asList(course2, course4, course8, course1, course3, course5));
            Student student5 = new Student("Студент_5", Arrays.asList(course3, course7, course9));
            Student student6 = new Student("Студент_6", Arrays.asList(course1, course3, course5, course9));
            Student student7 = new Student("Студент_7", Arrays.asList(course2, course6, course7, course5, course9));
            Student student8 = new Student("Студент_8", Arrays.asList(course3, course2, course4));
            Student student9 = new Student("Студент_9", Arrays.asList(course4, course8, course5));
            Student student10 = new Student("Студент_10", Arrays.asList(course5, course1, course9));
            Student student11 = new Student("Студент_11", Arrays.asList(course6, course9, course5));
            Student student12 = new Student("Студент_12", Arrays.asList(course7, course6, course5));
            Student student13 = new Student("Студент_13", Arrays.asList(course8, course1, course5));
            Student student14 = new Student("Студент_14", Arrays.asList(course9, course2, course5));
            Student student15 = new Student("Студент_15", Arrays.asList(course10, course3, course1));
            Student student16 = new Student("Студент_16", Arrays.asList(course11, course9, course2));
            Student student17 = new Student("Студент_17", Arrays.asList(course12, course8, course3));
            Student student18 = new Student("Студент_18", Arrays.asList(course11, course7, course4));
            Student student19 = new Student("Студент_19", Arrays.asList(course10, course6, course5));
            Student student20 = new Student("Студент_20", Arrays.asList(course9, course5, course3));
            Student student21 = new Student("Студент_21", Arrays.asList(course8, course6, course5));
            Student student22 = new Student("Студент_22", Arrays.asList(course7, course2, course11));
            Student student23 = new Student("Студент_23", Arrays.asList(course6, course1, course5));
            Student student24 = new Student("Студент_24", Arrays.asList(course5, course11, course12));
            Student student25 = new Student("Студент_25", Arrays.asList(course4, course12, course5));
            Student student26 = new Student("Студент_26", Arrays.asList(course3, course9, course5));
            Student student27 = new Student("Студент_27", Arrays.asList(course2, course6, course3));
            Student student28 = new Student("Студент_28", Arrays.asList(course1, course9, course5));


            return Arrays.asList(student1, student2, student3, student4, student5, student6, student7,
                    student8, student9, student10, student11, student12, student13, student14,
                    student15, student16, student17, student18, student19, student20, student21,
                    student22, student23, student24, student25, student26, student27, student28);
        }

        public static Course getRandomCourse() {
            Random random = new Random();
            List<Course> courses = getListCourses();
            return courses.get(random.nextInt(courses.size()));
        }

        private static List<Course> getListCourses() {
            return Arrays.asList(new Course("Кулинария"),
                    new Course("Рисование"),
                    new Course("Вязание"),
                    new Course("Валяние"),
                    new Course("Бисероплетение"),
                    new Course("Кройка и шитье"),
                    new Course("Флористика"),
                    new Course("Ландшафтный дизайн"),
                    new Course("Риторика"),
                    new Course("Сценическая речь"),
                    new Course("Психология"),
                    new Course("Гончарное дело"));
        }
    }

