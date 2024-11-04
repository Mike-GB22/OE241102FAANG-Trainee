//2024.11.04
//HashMap: —читаем прогулы
package task05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String splitter = "------------------------------------------------------";
        List<Student> studentsListToAdd = getStudentsToAdd();

        System.out.println(splitter);
        System.out.println("1) Make a University and load Students from LoadingOfStudents");
        System.out.println(splitter);

        University uni = new University();
        System.out.println(uni);



        System.out.println(splitter);
        System.out.println("2) Add one student (1) und list of students (2 - end):");
        System.out.println(studentsListToAdd);
        System.out.println(splitter);

        System.out.println("Uni has students: " + uni.getCountOfStudents());
        uni.addStudent(studentsListToAdd.get(0));
        System.out.println("Add one student. Now Uni has students: " + uni.getCountOfStudents());

        uni.addAllStudents(studentsListToAdd.subList(1, studentsListToAdd.size()));
        System.out.println("Add other students. Now Uni has students: " + uni.getCountOfStudents());

        System.out.println(uni);



        System.out.println(splitter);
        System.out.println("3) Delete one student (1) und list of students (2 - end): ");
        System.out.println(studentsListToAdd);
        System.out.println(splitter);

        System.out.println("Uni has students: " + uni.getCountOfStudents());
        uni.deleteStudent(studentsListToAdd.get(0));
        System.out.println("Delete one student. Now Uni has students: " + uni.getCountOfStudents());

        uni.deleteAllStudents(studentsListToAdd.subList(1, studentsListToAdd.size()));
        System.out.println("Delete other students. Now Uni has students: " + uni.getCountOfStudents());

        System.out.println(uni);



        System.out.println(splitter);
        KeyEntry facultyAndYearEntry = getFirstFacultyAndYearEntry(uni);

        System.out.printf("4) Search/get h all students from faculty '%s', year %d.\n",
                facultyAndYearEntry.getKey(), facultyAndYearEntry.getValue());
        System.out.println(splitter);

        System.out.println(
                uni.getAllStudentsByKeyEntry(facultyAndYearEntry)
        );



        System.out.println(splitter);
        System.out.printf("5) Delete all students from faculty '%s', year %d.\n",
            facultyAndYearEntry.getKey(), facultyAndYearEntry.getValue());
        System.out.println(splitter);

        uni.deleteAllStudentsByKeyEntry(facultyAndYearEntry);
        System.out.println(uni);

    }

    private static List<Student> getStudentsToAdd() {
        List<Student> studentsListToAdd = new ArrayList<>();
        studentsListToAdd.add(new Student("Zaitsev Dmitry", "Arts", 5));
        studentsListToAdd.add(new Student("Karpov Alexey", "Science", 5));
        studentsListToAdd.add(new Student("Lebedev Igor", "Law", 5));
        studentsListToAdd.add(new Student("Mikhailov Sergey", "Math", 5));
        studentsListToAdd.add(new Student("Sokolov Anton", "Tech", 5));
        studentsListToAdd.add(new Student("Tikhonov Pavel", "Arts", 5));
        studentsListToAdd.add(new Student("Frolov Roman", "Science", 5));
        studentsListToAdd.add(new Student("Kuzmin Alex", "Law", 5));
        studentsListToAdd.add(new Student("Gromov Andrey", "Math", 5));
        studentsListToAdd.add(new Student("Belyakov Oleg", "Tech", 5));
        return studentsListToAdd;
    }

    private static KeyEntry getFirstFacultyAndYearEntry(University uni){
        return new KeyEntry(
                uni.getAllFacultySet().stream().findFirst().orElse("")
                , uni.getAllYearsSet().stream().findFirst().orElse(1)
        );
    }
}
