package Models;

import Helpers.Helpers.Faculty;

import java.util.ArrayList;

public class Course {

    public String Name;
    public Faculty faculty;
    public Course(){

        Name = "";
        faculty = Faculty.UNKNOWN;
    }

    public String GetName(){
        return Name;
    }
    public Faculty GetFaculty(){
        return faculty;
    }

    public void SetName(String name){
        Name = name;
    }

    public void SetFaculty (Helpers.Helpers.Faculty newFaculty){
        faculty = newFaculty;
    }
}
