package Allocators;

import Helpers.Helpers;
import Models.Course;
import Models.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherChecker {

    public List<Teacher> TeacherList;
    public List<Course> CourseList;

    public String[] courseResults;
    public String[] professorResults;
    public String[] teachingAssistantResults;
    public int arraySize = 0;
    public TeacherChecker(){
        TeacherList = new ArrayList<Teacher>();
        CourseList = new ArrayList<Course>();
        courseResults = new String[100];
        professorResults = new String[100];
        teachingAssistantResults = new String[100];
    }

    public TeacherChecker(List<Teacher> teacherList, List<Course> courseList){
        TeacherList = teacherList;
        CourseList = courseList;
        courseResults = new String[100];
        professorResults = new String[100];
        teachingAssistantResults = new String[100];
    }

    public String[] GetCourseResults(){
        return courseResults;
    }
    public String[] GetProfessorResults(){
        return professorResults;
    }
    public String[] GetTeachingAssistantResults(){
        return teachingAssistantResults;
    }

    public void CheckerAssign(){

        // array index tracker
        int l = 0;

        for (int i = 0; i < CourseList.size(); i++) {
            String courseResult = "";
            String professorResult = "";
            String teachingAssistantResult = "";

            Course c = CourseList.get(i);
            courseResult = c.GetName();

            // indicator for assignment
            boolean teacherExists = false;

            // CheckerAssign Professor
            for(int j = 0; j < TeacherList.size(); j++){
                Teacher t = TeacherList.get(j);

                // if Faculties Match, set professor
                if(c.GetFaculty() == t.GetFaculty() && t.GetLevel() == Helpers.InstructorLevel.PROFESSOR){
                    professorResult = t.GetName();
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
                    teachingAssistantResult = t.GetName();
                    TeacherList.remove(k);
                    teacherExists = true;
                    break;
                }
            }

            if(teacherExists){
                courseResults[l] = courseResult;
                professorResults[l] = professorResult;
                teachingAssistantResults[l] = teachingAssistantResult;
                arraySize++;
                l++;
            }
        }
    }

}
