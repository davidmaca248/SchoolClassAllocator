package Models;

import Helpers.Helpers.Faculty;

public class Course {

    public String name;
    public Faculty faculty;
    public Course(){

        name = "";
        faculty = Faculty.UNKNOWN;
    }

    public Course(String newName, Faculty newFaculty){

        name = newName;
        faculty = newFaculty;
    }

    public String GetName(){
        return name;
    }
    public Faculty GetFaculty(){
        return faculty;
    }

    public void SetName(String newName){
        name = newName;
    }

    public void SetFaculty (Faculty newFaculty){
        faculty = newFaculty;
    }
}
