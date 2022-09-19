package Allocators;

import Helpers.StudentCoursePair;
import Models.Student;

import java.util.ArrayList;
import java.util.List;

//
public class StudentChecker {

    public double Threshold;
    public List<Student> StudentList;

    public List<StudentCoursePair> Pairs;

    public StudentChecker(){
        Threshold = 2.0;
        StudentList = new ArrayList<Student>();
        Pairs = new ArrayList<StudentCoursePair>();
    }
    public StudentChecker(double threshold, List<Student> studentList){
        Threshold = threshold;
        StudentList = studentList;
        Pairs = new ArrayList<StudentCoursePair>();
    }

    public List<Student> GetStudentList(){
        return StudentList;
    }
    public double GetThreshold(){
        return Threshold;
    }

    public List<StudentCoursePair> GetPairResults(){
        return Pairs;
    }

    public void SetStudentList(List<Student> studentList){
        StudentList = studentList;
    }
    public void SetThreshold(double threshold){
        Threshold = threshold;
    }

    public List<StudentCoursePair> Sort(){
        for (Student s: StudentList) {

            if(s.Grade >= Threshold){
                StudentCoursePair pair = new StudentCoursePair(s.Name, s.GetMajor());
                Pairs.add(pair);
            } else{
                StudentCoursePair pair = new StudentCoursePair(s.Name, s.GetMinor());
                Pairs.add(pair);
            }
        }
        return Pairs;
    }
}
