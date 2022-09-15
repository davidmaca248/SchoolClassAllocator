package Models;

import Helpers.Helpers;

import java.util.ArrayList;

public class Course {

    public String Name;
    public Helpers.Faculty faculty;
    public Course(){

        Name = "";
        faculty = Helpers.Faculty.UNKNOWN;
    }

    public String GetName(){
        return Name;
    }
    public Helpers.Helpers.Faculty GetFaculty(){
        return faculty;
    }

    public void SetName(String name){
        Name = name;
    }

    public void SetFaculty (Helpers.Helpers.Faculty newFaculty){
        faculty = newFaculty;
    }
}
