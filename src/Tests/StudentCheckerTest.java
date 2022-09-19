package Tests;

import Allocators.StudentChecker;
import Models.Student;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentCheckerTest {

    private StudentChecker instance;
    private double threshold;
    private List<Student> studentList;
    
    private List<String> Majors;
    private List<String> Minors;

    @org.junit.jupiter.api.BeforeEach
     void setUp() {
        Majors = new ArrayList<>();
        Majors.add("COMPUTERSCIENCE");
        Majors.add("MATH");
        Majors.add("ARTS");
        Majors.add("BUSINESS");

        Minors = new ArrayList<>();
        Minors.add("MATH");
        Minors.add("COMPUTERSCIENCE");
        Minors.add("SOFTWAREENGINEERING");
        Minors.add("ARTS");
        
        threshold = 3.0;

        studentList = new ArrayList<>();

    }

    @org.junit.jupiter.api.AfterEach
     void tearDown() {
    }

    @Test
    void PairResultsInitializeEmpty(){
        // Populate Student List
        studentList.add(new Student("21", "John Doe", "34 Country Way NE", Majors.get(0), Minors.get(0), 3.5));
        studentList.add(new Student("22", "Dave Web", "423 Cove Way NW", Majors.get(1), Minors.get(1), 3.2));
        studentList.add(new Student("23", "Danny Low", "23 Pano Way SE", Majors.get(2), Minors.get(2), 2.3));
        studentList.add(new Student("24", "Marie Jay", "65 Stone Way NW", Majors.get(3), Minors.get(3), 1.6));

        instance = new StudentChecker();
        instance.Threshold = threshold;
        instance.StudentList = studentList;

        // Check that PairResults is empty
        assertTrue (instance.GetPairResults().isEmpty());
    }

    // All Students have a grade above threshold, leading to assigned Majors
    @Test
    void  SortStudentAllGetMajor(){
        // Populate Student List
        studentList.add(new Student("21", "John Doe", "34 Country Way NE", Majors.get(0), Minors.get(0), 3.5));
        studentList.add(new Student("22", "Dave Web", "423 Cove Way NW", Majors.get(1), Minors.get(1), 3.2));
        studentList.add(new Student("23", "Danny Low", "23 Pano Way SE", Majors.get(2), Minors.get(2), 3.3));
        studentList.add(new Student("24", "Marie Jay", "65 Stone Way NW", Majors.get(3), Minors.get(3), 3.6));

        instance = new StudentChecker();
        instance.Threshold = threshold;
        instance.StudentList = studentList;

        instance.Sort();

        // Check that all students recieved minors
        var pairs = instance.GetPairResults();

        for (int i = 0; i < pairs.size();i++) {
            assertEquals(Majors.get(i), pairs.get(i).Course.toString());
        }
    }

    // All Students have a grade below threshold, leading to assigned minors
    @Test
    void SortStudentAllGetMinor(){
        studentList.add(new Student("21", "John Doe", "34 Country Way NE", Majors.get(0), Minors.get(0), 2.5));
        studentList.add(new Student("22", "Dave Web", "423 Cove Way NW", Majors.get(1), Minors.get(1), 1.2));
        studentList.add(new Student("23", "Danny Low", "23 Pano Way SE", Majors.get(2), Minors.get(2), 2.3));
        studentList.add(new Student("24", "Marie Jay", "65 Stone Way NW", Majors.get(3), Minors.get(3), 1.6));

        instance = new StudentChecker();
        instance.Threshold = threshold;
        instance.StudentList = studentList;

        instance.Sort();

        // Check that all students received minors
        var pairs = instance.GetPairResults();

        for (int i = 0; i < pairs.size();i++) {
            assertEquals(Minors.get(i), pairs.get(i).Course.toString());
        }
    }
}