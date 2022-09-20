package Allocators;

import Models.Student;

import java.util.ArrayList;
import java.util.List;

//
public class StudentChecker {

    public double Threshold;
    public List<Student> StudentList;

    public String[] courseResults;
    public String[] studentResults;

    public int arraySize = 0;
    public StudentChecker(){
        Threshold = 2.0;
        StudentList = new ArrayList<Student>();
        studentResults = new String[100];
        courseResults = new String[100];
    }
    public StudentChecker(double threshold, List<Student> studentList){
        Threshold = threshold;
        StudentList = studentList;
        arraySize = StudentList.size();
        studentResults = new String[100];
        courseResults = new String[100];
    }

    public List<Student> GetStudentList(){
        return StudentList;
    }
    public double GetThreshold(){
        return Threshold;
    }

    public String[] GetCourseResults(){
        return courseResults;
    }
    public String[] GetStudentResults(){
        return studentResults;
    }

    public void SetStudentList(List<Student> studentList){
        StudentList = studentList;
        arraySize = StudentList.size();
    }
    public void SetThreshold(double threshold){
        Threshold = threshold;
    }

    public void Sort(){
        for(int i = 0; i < StudentList.size(); i++) {

            var s = StudentList.get(i);
            studentResults[i] = s.Name;
            if (s.Grade >= Threshold) {
                courseResults[i] = s.GetMajor().toString();
            } else {
                courseResults[i] = s.GetMinor().toString();
            }
        }
    }
}
