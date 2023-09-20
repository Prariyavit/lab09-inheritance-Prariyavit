package ku.cs;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import ku.cs.services.Datasource;
import ku.cs.services.StudentListFileDatasource;

//  6410450001,Tim Berners-Lee,67.5
//  6410450002,Barbara Liskov,42.7
//  6410450003,Alan Turing,46.2
//  6410450004,John McCarthy,43.8
//  6410450005,Alan Kay,46.0
//  1234,gogo,80.0
public class MainTestConsole {

    public static void main(String[] args) {
        Datasource<StudentList> datasource = new StudentListFileDatasource("data", "student-list.csv");
        StudentList students = datasource.readData();

        // s1 find by id
        // s2 find by Object
        // same result
        Student s1 = students.findStudentById("6410450001");
        Student s2 = students.findStudentByObject(s1);

        System.out.println(s1.getName());
        System.out.println(s2.getName());

        System.out.println(s1 == s2);
    }
}
