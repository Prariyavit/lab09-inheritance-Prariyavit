package ku.cs.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    void testAddNewStudent() {
        ArrayList<Student> expected = new ArrayList<Student>();
        expected.add(new Student("6510450123", "Duck"));
        expected.add(new Student("6510450456", "Muck"));
        expected.add(new Student("6510450789", "Suck"));

        StudentList s = new StudentList();
        s.addNewStudent("6510450123", "Duck");
        s.addNewStudent("6510450456", "Muck");
        s.addNewStudent("6510450789", "Suck");

        ArrayList<Student> actual = s.getStudents();

        assertEquals(expected.get(0).getId(), actual.get(0).getId());
        assertEquals(expected.get(0).getName(), actual.get(0).getName());

        assertEquals(expected.get(1).getId(), actual.get(1).getId());
        assertEquals(expected.get(1).getName(), actual.get(1).getName());

        assertEquals(expected.get(2).getId(), actual.get(2).getId());
        assertEquals(expected.get(2).getName(), actual.get(2).getName());
    }

    @Test
    void testGiveScoreToId() {
        StudentList s = new StudentList();
        s.addNewStudent("6510450123", "Duck");
        s.addNewStudent("6510450456", "Muck");
        s.addNewStudent("6510450789", "Suck");

        assertEquals(0, s.findStudentById("6510450123").getScore());
        s.giveScoreToId("6510450123", 80);
        assertEquals(80, s.findStudentById("6510450123").getScore());
    }

    @Test
    void testViewGradeOfId() {
        StudentList s = new StudentList();
        s.addNewStudent("6510450123", "Duck", 80);
        s.addNewStudent("6510450456", "Muck", 40);
        s.addNewStudent("6510450789", "Suck", 50);

        assertEquals("A", s.viewGradeOfId("6510450123"));
        assertEquals("F", s.viewGradeOfId("6510450456"));
        assertEquals("D", s.viewGradeOfId("6510450789"));
    }

    @Test
    void testFindStudentById() {
        StudentList s = new StudentList();
        s.addNewStudent("6510450123", "Duck", 80);
        s.addNewStudent("6510450456", "Muck", 40);
        s.addNewStudent("6510450789", "Suck", 50);

        Student expected = new Student("6510450123", "Duck", 80);
        Student actual = s.findStudentById("6510450123");

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getScore(), actual.getScore());
    }

    @Test
    void TestFindStudentByObject() {
        StudentList s = new StudentList();
        s.addNewStudent("6510450123", "Duck", 80);
        s.addNewStudent("6510450456", "Muck", 40);
        s.addNewStudent("6510450789", "Suck", 50);

        Student expected = new Student("6510450123", "Duck", 80);
        Student actual = s.findStudentByObject(s.getStudents().get(0));

        assertEquals(expected, actual);
    }
}