package Models;

import static Helpers.Helpers.SchoolIdGenerator;
import Helpers.Helpers.Faculty;
import Helpers.Helpers.InstructorLevel;


public class Teacher extends Person {

    private Faculty faculty;
    private InstructorLevel level;

    public Teacher(String name, String address){
        Name = name;
        Address = address;
        Id = SchoolIdGenerator();
        level = InstructorLevel.UNKNOWN;
        faculty = Faculty.UNKNOWN;
    }

    //Setters
    public void SetName(String name){
        Name = name;
    }
    public void SetAddress(String address){
        Address = address;
    }
    public void SetId(String id){
        Id = id;
    }
    public void SetFaculty(Faculty newFaculty){
        faculty = newFaculty;
    }

    //Getters
    public String GetName(){
        return Name;
    }
    public String GetAddress(){
        return Address;
    }
    public String GetId(){
        return Id;
    }
    public Faculty GetFaculty(){
        return faculty;
    }
}
