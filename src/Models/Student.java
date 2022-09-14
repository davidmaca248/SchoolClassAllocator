package Models;

import static Helpers.Helpers.SchoolIdGenerator;
import Helpers.Helpers.Faculty;

public class Student extends Person{

    public Faculty Major = Faculty.UNKNOWN;
    public Faculty Minor = Faculty.UNKNOWN;
    public double Grade;

    public Student(){}
    public Student(String id, String name, String address, String major, String minor, double grade){
        Name = name;
        Address = address;
        Id = SchoolIdGenerator();
        Grade = grade;

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

        switch (minor){
            case "ARTS":
                Minor = Faculty.ARTS;
                break;
            case "BUSINESS":
                Minor = Faculty.BUSINESS;
                break;
            case "SOFTWAREENGINEERING":
                Minor = Faculty.SOFTWAREENGINEERING;
                break;
            case "COMPUTERSCIENCE":
                Minor = Faculty.COMPUTERSCIENCE;
                break;
            default:
                Minor = Faculty.UNKNOWN;
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
    public void SetId(String id) {Id = id;}
    public void SetGrade(double grade) {Grade = grade;}
    public void SetMajor(Faculty newMajor){
        Major = newMajor;
    }
    public void SetMinor(Faculty newMinor){
        Major = newMinor;
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
    public Faculty GetMinor(){
        return Minor;
    }
    public double GetGrade(){
        return Grade;
    }
}
