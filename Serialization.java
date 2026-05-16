package com.example.filehandling;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Serialization implements Serializable {
    public static void main(String[] args) throws Exception {

        //Writing in a file
        File myFile = new File("Text.txt");
        myFile.createNewFile();

        // Student s=new Student("Laiba","laiba@gmail.com","punjab",3.54);
        //Instead of giving it to a constructor We can give it through ArrayList

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Hiba", "laiba@gmail.com", "punjab", 2.94));
        students.add(new Student("Laiba", "hiba@gmail.com", "punjab", 3.94));
        students.add(new Student("Eshaal", "Eshaal@gmail.com", "punjab", 4.24));

        // Writing in a file
        FileOutputStream fileOutputStream = new FileOutputStream(myFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(students);
        objectOutputStream.close();
        fileOutputStream.close();

        // Reading from a file
        FileInputStream fileInputStream = new FileInputStream(myFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        // Object o=ObjectInputStream.readObject();
        // Student std=(Student) o;
        ArrayList<Student> o = (ArrayList<Student>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        System.out.println();
        Collections.sort(students);

        System.out.println("Original + Gpa is sorted");
        for (Student st : o) {
            System.out.println(st.getName() + " " +st.getEmail()+ " " +st.getAddress()+ " "+ st.getGpa());
        }
        System.out.println();

        System.out.println("Printing the complete Object");
        System.out.println(o);

        System.out.println();


        students = readData(myFile);
        students.set(1,new Student("Khalid","Khalid@gamil.com","punjab",2.9));
        students.forEach(e-> e.setGpa(3.0));
        System.out.println();
        System.out.println("Updated Gpa + First index is replaced with another values");
        for (Student st : students) {
            System.out.println(st.getName() + " " + st.getEmail() + " " + st.getAddress() + " " + st.getGpa());
        }
    }


    public static ArrayList<Student> readData(File myFile) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(myFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Student> obj = (ArrayList<Student>) objectInputStream.readObject();
        return obj;
    }
}


