package Models;

import Helpers.Helpers.Faculty;
import Helpers.Helpers.InstructorLevel;


public class Teacher extends Person {

    public Faculty faculty;
    public InstructorLevel level;

    public Teacher(){}
    public Teacher(String id, String name, String address,
                   String newLevel, String newFaculty){
        Name = name;
        Address = address;
        Id = id;

        switch (newLevel){
            case "TEACHINGASSISTANT":
                level = InstructorLevel.TEACHINGASSISTANT;
                break;
            case "PROFESSOR":
                level = InstructorLevel.PROFESSOR;
                break;
            default:
                level = InstructorLevel.UNKNOWN;
                break;
        }

        switch (newFaculty){
            case "ARTS":
                faculty = Faculty.ARTS;
                break;
            case "BUSINESS":
                faculty = Faculty.BUSINESS;
                break;
            case "SOFTWAREENGINEERING":
                faculty = Faculty.SOFTWAREENGINEERING;
                break;
            case "COMPUTERSCIENCE":
                faculty = Faculty.COMPUTERSCIENCE;
                break;
            case "MATH":
                faculty = Faculty.MATH;
                break;
            default:
                faculty = Faculty.UNKNOWN;
                break;
        }
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
    public void SetLevel(InstructorLevel newLevel) {
        level = newLevel;
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
    public InstructorLevel GetLevel(){
        return level;
    }
}
