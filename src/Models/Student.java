package Models;

import static Helpers.Helpers.SchoolIdGenerator;
import Helpers.Helpers.Faculty;

public class Student extends Person{

    public Faculty major;

    public Student(String name, String address){
        Name = name;
        Address = address;
        Id = SchoolIdGenerator();

        major = Faculty.UNKNOWN;
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
        major = newMajor;
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
        return major;
    }
}
