package Helpers;

public class CourseTeacherPair {

    public String Course;
    public String Professor;
    public String TA;

    public CourseTeacherPair(){
        Course = "";
        Professor = "";
        TA = "";
    }

    public CourseTeacherPair(String course, String professor, String ta){
        Course = course;
        Professor = professor;
        TA = ta;
    }

    public void SetCourse(String course){
        Course = course;
    }

    public void SetProfessor(String professor){
        Professor = professor;
    }

    public void SetTeachingAssistant(String teachingAssistant){
        TA = teachingAssistant;
    }

    public String GetCourse(){
        return Course;
    }

    public String GetProfessor(){
        return Professor;
    }

    public String GetTeachingAssistant(){
        return TA;
    }
}
