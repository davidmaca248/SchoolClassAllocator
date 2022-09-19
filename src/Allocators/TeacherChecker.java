package Allocators;

import Helpers.CourseTeacherPair;
import Helpers.Helpers;
import Models.Course;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherChecker {

    public List<Teacher> TeacherList;
    public List<Course> CourseList;
    public List<CourseTeacherPair> Pairs;
    public TeacherChecker(){
        Pairs = new ArrayList<CourseTeacherPair>();
        TeacherList = new ArrayList<Teacher>();
        CourseList = new ArrayList<Course>();
    }

    public TeacherChecker(List<Teacher> teacherList, List<Course> courseList){
        Pairs = new ArrayList<CourseTeacherPair>();
        TeacherList = teacherList;
        CourseList = courseList;
    }

    public List<CourseTeacherPair> GetPairResults(){
        return Pairs;
    }

    public List<CourseTeacherPair> CheckerAssign(){
        for (int i = 0; i < CourseList.size(); i++) {
            CourseTeacherPair p = new CourseTeacherPair();

            Course c = CourseList.get(i);
            p.SetCourse(c.GetName());

            // indicator for assignment
            boolean teacherExists = false;

            // CheckerAssign Professor
            for(int j = 0; j < TeacherList.size(); j++){
                Teacher t = TeacherList.get(j);

                // if Faculties Match, set professor
                if(c.GetFaculty() == t.GetFaculty() && t.GetLevel() == Helpers.InstructorLevel.PROFESSOR){
                    p.SetProfessor(t.GetName());
                    TeacherList.remove(j);
                    teacherExists = true;
                    break;
                }
            }

            // CheckerAssign Teaching Assistant
            for(int k = 0; k < TeacherList.size(); k++){
                Teacher t = TeacherList.get(k);

                // if Faculties Match, set TA
                if(c.GetFaculty() == t.GetFaculty() && t.GetLevel() == Helpers.InstructorLevel.TEACHINGASSISTANT){
                    p.SetTeachingAssistant(t.GetName());
                    TeacherList.remove(k);
                    teacherExists = true;
                    break;
                }
            }

            if(teacherExists){
                Pairs.add(p);}
        }
        return Pairs;
    }

}
