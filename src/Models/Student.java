package Models;

import static Helpers.Helpers.SchoolIdGenerator;
import Helpers.Helpers.Faculty;

public class Student extends Person{

    public Faculty Major = Faculty.UNKNOWN;

    public Student(){}
    public Student(String id, String name, String address, String major){
        Name = name;
        Address = address;
        Id = SchoolIdGenerator();

        switch (major){
            case "ARTS":
                Major = Faculty.ARTS;
                break;
            case "BUSINESS":
                Major = Faculty.BUSINESS;
                break;
            case "SOFTWAREENGINEERING":
                Major = Faculty.SOFTWAREENGINEERING;
                break;
            case "COMPUTERSCIENCE":
                Major = Faculty.COMPUTERSCIENCE;
                break;
            default:
                Major = Faculty.UNKNOWN;
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
    public void SetId(String id) {
        Id = id;
    }
    public void SetMajor(Faculty newMajor){
        Major = newMajor;
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

    public Faculty GetMajor(){
        return Major;
    }
}
