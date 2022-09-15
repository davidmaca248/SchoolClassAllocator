package Helpers;

import Allocators.TeacherChecker;

public class CourseTeacherPair {

    private String Course;
    private String Professor;
    private String TeachingAssistant;

    public CourseTeacherPair(){
        Course = "";
        Professor = "";
        TeachingAssistant = "";
    }

    public CourseTeacherPair(String course, String professor, String teachingAssistant){
        Course = course;
        Professor = professor;
        TeachingAssistant = teachingAssistant;
    }

    public void SetCourse(String course){
        Course = course;
    }

    public void SetProfessor(String professor){
        Professor = professor;
    }

    public void SetTeachingAssistant(String teachingAssistant){
        TeachingAssistant = teachingAssistant;
    }

    public String GetCourse(){
        return Course;
    }

    public String GetProfessor(){
        return Professor;
    }

    public String GetTeachingAssistant(){
        return TeachingAssistant;
    }
}
