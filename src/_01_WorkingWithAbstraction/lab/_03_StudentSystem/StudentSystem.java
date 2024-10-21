package _01_WorkingWithAbstraction.lab._03_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentMap;

    public StudentSystem() {
        this.studentMap = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.studentMap;
    }

    public void ParseCommand(String[] args) {
        String commandName = args[0];
        if (commandName.equals("Create")) {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!studentMap.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentMap.put(name, student);
            }
        } else if (commandName.equals("Show")) {
            String name = args[1];
            if (studentMap.containsKey(name)) {
                printStudentInformation(name);
            }
        }
    }

    private void printStudentInformation(String name) {
        Student student = studentMap.get(name);
        String view = String.format("%s is %s years old.", student.getName(), student.getAge());

        if (student.getGrade() >= 5.00) {
            view += " Excellent student.";
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view += " Average student.";
        } else {
            view += " Very nice person.";
        }

        System.out.println(view);
    }
}
