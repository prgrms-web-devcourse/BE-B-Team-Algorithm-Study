package boj.q5635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    String name;
    LocalDate date;

    public Student(String name, int year, int month, int day) {
        this.name = name;
        this.date = LocalDate.of(year, month, day);
    }

    @Override
    public int compareTo(Student student) {
        return this.date.compareTo(student.date);
    }
}

public class Main {

    // https://globalhost.interdol.com/429
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        ArrayList<Student> students = new ArrayList<>();
        while (count-- > 0) {
            String information = br.readLine();
            String[] argument = information.split(" ");
            students.add(new Student(argument[0], Integer.parseInt(argument[3]), Integer.parseInt(argument[2]),
                    Integer.parseInt(argument[1])));
        }

        Collections.sort(students);
        System.out.println(students.get(students.size() - 1).name);
        System.out.println(students.get(0).name);
    }

}