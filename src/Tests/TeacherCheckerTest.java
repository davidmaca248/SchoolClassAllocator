package Tests;

import Allocators.TeacherChecker;
import Helpers.Helpers.*;
import Models.Course;
import Models.Teacher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeacherCheckerTest {

    private TeacherChecker instance;
    private List<Teacher> teacherList;
    private List<Course> courseList;


    @BeforeEach
    void setUp() {
        teacherList = new ArrayList<>();

        courseList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initializeEmptyListsOnDefaultConstructor(){
        instance = new TeacherChecker();

        assertTrue(instance.TeacherList.isEmpty());
        assertTrue(instance.CourseList.isEmpty());
        assertTrue(instance.Pairs.isEmpty());
    }

    @Test
    void initializeListsOnNonDefaultConstructor(){
        instance = new TeacherChecker(teacherList,courseList);

        assertEquals(teacherList, instance.TeacherList);
        assertEquals(courseList, instance.CourseList);
        assertTrue(instance.Pairs.isEmpty());
    }

    @Test
    void assignCoursesLessTeachersThanCourses(){
        courseList.add(new Course("CPSC 501", Faculty.COMPUTERSCIENCE));
        instance = new TeacherChecker(teacherList,courseList);
        instance.CheckerAssign();

        var result = instance.Pairs;

        // verify that there are no course pairs
        assertTrue(instance.Pairs.isEmpty());
    }

    @Test
    void assignCoursesLessOrEqualCoursesThanTeachers(){
        String name1 = "James Franco";
        String name2 = "Dave Gun";
        String name3 = "Max Russel";

        courseList.add(new Course("CPSC 501", Faculty.COMPUTERSCIENCE));
        courseList.add(new Course("MATH 331", Faculty.MATH));
        teacherList.add(new Teacher("21", name1, "213 CovePark NE", "PROFESSOR", "COMPUTERSCIENCE"));
        teacherList.add(new Teacher("22", name2, "4234 CovePark NE", "TEACHINGASSISTANT", "COMPUTERSCIENCE"));
        teacherList.add(new Teacher("24", name3, "2133 Country NE", "PROFESSOR", "MATH"));

        instance = new TeacherChecker(teacherList,courseList);
        instance.CheckerAssign();

        var result = instance.Pairs;

        assertEquals(name1, result.get(0).GetProfessor());
        assertEquals(name2, result.get(0).GetTeachingAssistant());
        assertEquals(name3, result.get(1).GetProfessor());
        assertEquals("", result.get(1).GetTeachingAssistant());
    }
}