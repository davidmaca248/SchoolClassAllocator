package Allocators;

import Helpers.StudentCoursePair;
import Models.Student;

import java.util.ArrayList;
import java.util.List;

//
public class StudentChecker {

    private double Threshold;
    private List<Student> StudentList;

    private List<StudentCoursePair> PairResults;

    public StudentChecker(){
        Threshold = 2.0;
        StudentList = new ArrayList<Student>();
        PairResults = new ArrayList<StudentCoursePair>();
    }
    public StudentChecker(double threshold, List<Student> studentList){
        Threshold = threshold;
        StudentList = studentList;
        PairResults = new ArrayList<StudentCoursePair>();
    }

    public List<Student> GetStudentList(){
        return StudentList;
    }
    public double GetThreshold(){
        return Threshold;
    }

    public List<StudentCoursePair> GetPairResults(){
        return PairResults;
    }

    public void SetStudentList(List<Student> studentList){
        StudentList = studentList;
    }
    public void SetThreshold(double threshold){
        Threshold = threshold;
    }

    public List<StudentCoursePair> SortStudents(){
        for (Student s: StudentList) {

            if(s.Grade >= Threshold){
                StudentCoursePair pair = new StudentCoursePair(s.Name, s.GetMajor());
                PairResults.add(pair);
            } else{
                StudentCoursePair pair = new StudentCoursePair(s.Name, s.GetMinor());
                PairResults.add(pair);
            }
        }
        return PairResults;
    }
}
