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
        // populate teacherList
        teacherList = new ArrayList<>();


        // populate courseList
        courseList = new ArrayList<>();
        courseList.add(new Course("CPSC 501", Faculty.COMPUTERSCIENCE));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initializeEmptyListsOnDefaultConstructor(){
        instance = new TeacherChecker();

        assertTrue(instance.TeacherList.isEmpty());
        assertTrue(instance.CourseList.isEmpty());
        assertTrue(instance.ResultPairs.isEmpty());
    }

    @Test
    void initializeListsOnNonDefaultConstructor(){
        instance = new TeacherChecker(teacherList,courseList);

        assertEquals(teacherList, instance.TeacherList);
        assertEquals(courseList, instance.CourseList);
        assertTrue(instance.ResultPairs.isEmpty());
    }

    @Test
    void assignCoursesLessTeachersThanCourses(){
        courseList.add(new Course("CPSC 501", Faculty.COMPUTERSCIENCE));
        instance.AssignCourses();

        var result = instance.ResultPairs;

        // verify that there are no course pairs
        assertTrue(instance.ResultPairs.isEmpty());
    }

    @Test
    void assignCoursesLessOrEqualCoursesThanTeachers(){
        teacherList.add(new Teacher("21", "James Franco", "213 CovePark NE", "TEACHINGASSISTANT", "COMPUTERSCIENCE"));
        instance.AssignCourses();

        var result = instance.ResultPairs;


    }
}