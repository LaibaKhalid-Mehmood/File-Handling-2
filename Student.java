package com.example.filehandling;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>{
    private String name;
    private String email;
    private String address;
    private double gpa;

    Student(String name, String email, String address, double gpa){
        this.name=name;
        this.email=email;
        this.address=address;
        this.gpa=gpa;
    }

    public String getName(){ return name;}
    public String getEmail(){ return email;}
    public String getAddress(){ return address;}
    public double getGpa(){ return gpa;}


    public String setName(String name){
        this.name=name;
        return name;
    }

    public String setEmail(String email){
        this.email=email;
        return email;
    }

    public String setAddress(String address){
        this.address=address;
        return address;
    }

    public double setGpa(double gpa){
        this.gpa=gpa;
        return gpa;
    }

    public int compareTo(Student s){
        int f=0;
        if(s.gpa>this.gpa){
            f=1;
        }

        if(s.gpa<this.gpa){
            f=-1;
        }

        if(s.gpa==this.gpa){
            f=0;
        }
        return f;
    }

    public String toString(){
        return "Name:"+ name+"  "+ "Email:"+email+"  "+ "Address:"+address+"  " +"Gpa:"+gpa;
    }





}
