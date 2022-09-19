package Helpers;

import Helpers.Helpers.Faculty;

public class StudentCoursePair
{
    public String Name;
    public Faculty Course;

    public StudentCoursePair(){
        Name = "";
        Course = Faculty.UNKNOWN;
    }
    public StudentCoursePair(String name, Faculty course)
    {
        Name = name;
        Course = course;
    }

    public String name()   { return Name; }
    public Faculty assignedCourse() { return Course; }

    public void SetName(String name){
        Name = name;
    }
    public void SetCourse(Faculty course){
        Course = course;
    }
}