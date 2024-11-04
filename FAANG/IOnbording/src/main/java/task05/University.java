package task05;

import java.util.*;
import java.util.stream.Collectors;

public class University {
    private List<Student> students;
    private Map<KeyEntry, List<Student>> studentsByFacultyAndYear;

    public University(List<Student> students) {
        this.students = students;
        reloadFacultyAndYearHashMapFromStudents();
    }

    public University() {
        this(LoadingOfStudents.getAllStudents());
    }

    private void reloadFacultyAndYearHashMapFromStudents() {
        Map<KeyEntry, List<Student>> map = new HashMap<>();
        students.forEach(student -> placeStudentIhHashMapByFacultyAndYer(student, map));
        studentsByFacultyAndYear = map;
    }
    private void placeStudentIhHashMapByFacultyAndYer(Student student, Map<KeyEntry, List<Student>> map){
        KeyEntry keyEntry = new KeyEntry(student.getFaculty(), student.getYear());
        List<Student> listOfKeyEntry = map.get(keyEntry);
        if (listOfKeyEntry == null) map.put(keyEntry, listOfKeyEntry = new ArrayList<>());
        listOfKeyEntry.add(student);
    }

    public void addStudent(Student student){
        students.add(student);
        placeStudentIhHashMapByFacultyAndYer(student, studentsByFacultyAndYear);
    }

    public void addAllStudents(Collection<? extends Student> newStudents){
        for (Student student: newStudents){
            addStudent(student);
        }
    }

    public boolean deleteStudent(Student student){
        boolean flag = students.remove(student);
        reloadFacultyAndYearHashMapFromStudents();
        return flag;
    }

    public boolean deleteAllStudents(List<Student> students){
        boolean flag = this.students.removeAll(students);
        reloadFacultyAndYearHashMapFromStudents();
        return flag;
    }

    public boolean deleteAllStudentsByKeyEntry(KeyEntry keyEntry){
        return deleteAllStudents(
                getAllStudentsByKeyEntry(keyEntry)
        );
    }

    public List<Student> getAllStudentsByKeyEntry(KeyEntry keyEntry){
        List<Student> result = studentsByFacultyAndYear.get(keyEntry);
        if(result == null) result = new ArrayList<>();
        return result;
    }

    public Set<KeyEntry> getAllKeyEntrySet(){
        return studentsByFacultyAndYear.keySet();
    }

    public Set<String> getAllFacultySet(){
        return getAllKeyEntrySet().stream()
                .map(keyEntry -> keyEntry.getKey())
                .collect(Collectors.toSet());
    }

    public Set<Integer> getAllYearsSet(){
        return getAllKeyEntrySet().stream()
                .map(keyEntry -> keyEntry.getValue())
                .collect(Collectors.toSet());
    }

    public int getCountOfStudents(){
        return students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<KeyEntry, List<Student>> getStudentsHashMapByFacultyAndYear() {
        return studentsByFacultyAndYear;
    }

    @Override
    public String toString() {
        String splitter = "=============================================\n";
        String splitterFromNewLine = "\n" + splitter;
        Set<String> faculties = getAllFacultySet();
        Set<Integer> years = getAllYearsSet();

        StringBuilder result = new StringBuilder(splitter);
        result.append("University.");
        result.append(splitterFromNewLine);

        result.append(String.format("Has %d students, %d faculties and %d year's groups",
                students.size(), faculties.size(), years.size()));
        result.append("\nHas faculties: " + faculties);
        result.append("\nHas year's groups: " +  years);
        result.append(splitterFromNewLine);

        result.append("List of students by faculty and year");
        result.append(splitterFromNewLine);

        for (String faculty : faculties){
            result.append("FACULTY '" + faculty + "':\n");
            for (Integer year : years){
                result.append(" * YEAR " + year + ": ");
                result.append(
                        getAllStudentsByKeyEntry(new KeyEntry(faculty, year))
                                .stream()
                                .map(student -> student.getName())
                                .toList()
                );
                result.append("\n");
            }
        }
        result.append(splitter);
        return result.toString();
    }
}
