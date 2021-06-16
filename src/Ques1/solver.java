//Brand BINF-A
package Ques1;

/*
Sample program for compareTo and Comparator
Sample Input:
4
Anita 5
Ana 8
Ana 7
Anisa 6
*/
import java.io.*;
import java.util.*;

public class solver {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();

        // Get n student information from file
        Student student[] = new Student[n];
        for (int i = 0; i < n; i++) {
            String s=inp.next();
            int g=inp.nextInt();
            student[i] = new Student(s,g);

        }

        System.out.println("Before sorting: ");
        for (int i = 0; i < student.length; i++)
            System.out.println(student[i]);


        System.out.println("Sort students using compareTo:");
        Arrays.sort(student);
        for (int i = 0; i < student.length; i++)
            System.out.println(student[i]);



        System.out.println("Sort students by grade:");
        Arrays.sort(student, new GradeComparator());
        for (int i = 0; i < student.length; i++)
            System.out.println(student[i]);



        System.out.println("Sort students by name:");
        Arrays.sort(student, new NameComparator());
        for (int i = 0; i < student.length; i++)
            System.out.println(student[i]);


    }

}

//Compare students by grade
class GradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getGrade() - o1.getGrade();
    }

}

//Compare students by name
class NameComparator  implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();

        // ascending order (descending order would be: name2.compareTo(name1))
        return name1.compareTo(name2);
    }
}

//Student class
class Student implements Comparable<Student> {
    String name;
    int grade;

    public Student() {
    }

    public Student(String name, int grade ) {
        this.name=name;
        this.grade=grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.grade;
    }

    @Override
    public int compareTo(Student that) {
        if (this.grade > that.grade)
            return 1;
        else if (this.grade < that.grade)
            return -1;
        else
            return 0;
    }
}
