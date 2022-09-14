import Allocators.StudentChecker;
import Helpers.Helpers;
import Helpers.StudentCoursePair;
import Models.Student;
import Models.Teacher;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Student> studentList;
    public static List<Teacher> teacherList;
    public static void main(String[] args) {

        studentList = GetStudentIntoList();
        teacherList = GetTeacherIntoList();

        double threshold = 3.0;

        // call sorting algorithm for students
        StudentChecker studentChecker = new StudentChecker(threshold, studentList);
        studentChecker.SortStudents();

        // call sorting algorithm for teachers

        // write to output of students
        // write to output of teachers

        String studentOutput = "./OutputFiles/StudentOutput.txt";
        String teacherOutput = "./OutputFiles/TeacherOutput.txt";

        // write students
        try {
            BufferedWriter studentWriter = new BufferedWriter(new FileWriter(studentOutput));

            for (StudentCoursePair sp : studentChecker.GetPairResults()
                 ) {
                studentWriter.write("Student name: " + sp.name());
                studentWriter.write(", Assigned Faculty: " + sp.assignedCourse() + "\n");
            }

            studentWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // write teachers
        try {
            BufferedWriter teacherWriter = new BufferedWriter(new FileWriter(teacherOutput));

            for (Teacher t : teacherList
            ) {
                teacherWriter.write("Teacher name: " + t.Name + "\n");
            }
            teacherWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> GetStudentIntoList(){

        List<Student> studentLst = new ArrayList<Student>();

        String studentFilePath = "./InputFiles/StudentInformation.xml";

        File file = new File(studentFilePath);

        try{
            if(file.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(studentFilePath);
                doc.getDocumentElement().normalize();

                NodeList students = doc.getElementsByTagName("Student");

                int k = students.getLength();
                for(int i = 0; i < students.getLength(); i++){
                    Node student = students.item(i);

                    Student s = new Student();

                    // get student
                    if(student.getNodeType() == Node.ELEMENT_NODE) {
                        Element elem = (Element) student;


                        // get student's elements
                        NodeList children = student.getChildNodes();
                        for (int j = 0; j < children.getLength(); j++) {
                            Node child = children.item(j);

                            if (child.getNodeType() == Node.ELEMENT_NODE) {
                                Element studentElem = (Element) child;
                                var name = studentElem.getTagName();
                                System.out.println("Student Elem: " + name);
                                System.out.println("Student Value: " + studentElem.getAttribute("value"));

                                switch (name) {
                                    case "Id":
                                        s.SetId(studentElem.getAttribute("value"));
                                        break;
                                    case "Name":
                                        s.SetName(studentElem.getAttribute("value"));
                                        break;
                                    case "Address":
                                        s.SetAddress(studentElem.getAttribute("value"));
                                        break;
                                    case "Grade":
                                        s.SetGrade(Double.parseDouble(studentElem.getAttribute("value")));
                                        break;
                                    case "Major":
                                        switch (studentElem.getAttribute("value")) {
                                            case "ARTS":
                                                s.SetMajor(Helpers.Faculty.ARTS);
                                                break;
                                            case "BUSINESS":
                                                s.SetMajor(Helpers.Faculty.BUSINESS);
                                                break;
                                            case "SOFTWAREENGINEERING":
                                                s.SetMajor(Helpers.Faculty.SOFTWAREENGINEERING);
                                                break;
                                            case "COMPUTERSCIENCE":
                                                s.SetMajor(Helpers.Faculty.COMPUTERSCIENCE);
                                                break;
                                            case "MATH":
                                                s.SetMajor(Helpers.Faculty.MATH);
                                                break;
                                            default:
                                                s.SetMajor(Helpers.Faculty.UNKNOWN);
                                                break;
                                        }
                                        break;
                                    case "Minor":
                                        switch (studentElem.getAttribute("value")) {
                                            case "ARTS":
                                                s.SetMinor(Helpers.Faculty.ARTS);
                                                break;
                                            case "BUSINESS":
                                                s.SetMinor(Helpers.Faculty.BUSINESS);
                                                break;
                                            case "SOFTWAREENGINEERING":
                                                s.SetMinor(Helpers.Faculty.SOFTWAREENGINEERING);
                                                break;
                                            case "COMPUTERSCIENCE":
                                                s.SetMinor(Helpers.Faculty.COMPUTERSCIENCE);
                                                break;
                                            case "MATH":
                                                s.SetMinor(Helpers.Faculty.MATH);
                                                break;
                                            default:
                                                s.SetMinor(Helpers.Faculty.UNKNOWN);
                                                break;
                                        }
                                        break;
                                }
                            }
                        }
                        studentLst.add(s);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return studentLst;
    }

    public static List<Teacher> GetTeacherIntoList(){

        List<Teacher> teacherLst = new ArrayList<Teacher>();

        String teacherFilePath = "./InputFiles/TeacherInformation.xml";

        File file = new File(teacherFilePath);

        try{
            if(file.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(teacherFilePath);
                doc.getDocumentElement().normalize();

                NodeList teachers = doc.getElementsByTagName("Teacher");

                int k = teachers.getLength();
                for(int i = 0; i < teachers.getLength(); i++){
                    Node teacher = teachers.item(i);

                    Teacher t = new Teacher();

                    // get teacher
                    if(teacher.getNodeType() == Node.ELEMENT_NODE) {
                        Element elem = (Element) teacher;


                        // get teacher't elements
                        NodeList children = teacher.getChildNodes();
                        for (int j = 0; j < children.getLength(); j++) {
                            Node child = children.item(j);

                            if (child.getNodeType() == Node.ELEMENT_NODE) {
                                Element teacherElem = (Element) child;
                                var name = teacherElem.getTagName();

                                switch (name) {
                                    case "Id":
                                        t.SetId(teacherElem.getAttribute("value"));
                                        break;
                                    case "Name":
                                        t.SetName(teacherElem.getAttribute("value"));
                                        break;
                                    case "Address":
                                        t.SetAddress(teacherElem.getAttribute("value"));
                                        break;
                                    case "Faculty":
                                        switch (teacherElem.getAttribute("value")) {
                                            case "ARTS":
                                                t.SetFaculty(Helpers.Faculty.ARTS);
                                                break;
                                            case "BUSINESS":
                                                t.SetFaculty(Helpers.Faculty.BUSINESS);
                                                break;
                                            case "SOFTWAREENGINEERING":
                                                t.SetFaculty(Helpers.Faculty.SOFTWAREENGINEERING);
                                                break;
                                            case "COMPUTERSCIENCE":
                                                t.SetFaculty(Helpers.Faculty.COMPUTERSCIENCE);
                                                break;
                                            case "MATH":
                                                t.SetFaculty(Helpers.Faculty.MATH);
                                                break;
                                            default:
                                                t.SetFaculty(Helpers.Faculty.UNKNOWN);
                                                break;
                                        }
                                    case "Level":
                                        switch (teacherElem.getAttribute("value")) {
                                            case "PROFESSOR":
                                                t.SetLevel(Helpers.InstructorLevel.PROFESSOR);
                                                break;
                                            case "TEACHINGASSISTANT":
                                                t.SetLevel(Helpers.InstructorLevel.TEACHINGASSISTANT);
                                                break;
                                            default:
                                                t.SetLevel(Helpers.InstructorLevel.UNKNOWN);
                                                break;
                                        }
                                }
                            }
                        }
                        teacherLst.add(t);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        return teacherLst;
    }
}