package edu.gonzaga;

import java.time.LocalDate;
import java.util.ArrayList;

// *************************************************************
class Person {
    private Integer yearBorn;

    public Person(Integer yearBorn) {
        this.yearBorn = yearBorn;
    }

    public Integer getAge_years() {
        LocalDate dateNow = LocalDate.now();
        Integer currYear = dateNow.getYear();
        Integer personAge_years = currYear - yearBorn;

        return personAge_years;
    }

}

// **************************************************************
class Student extends Person {
    private double gpa;
    public Student(Integer studentYearBorn) {
        super(studentYearBorn);
        gpa = 3.0;
    }

    @Override
    public String toString() {
        return "Student is " + getAge_years() + " years old! And their gpa is: " + this.gpa;
    }
}

// **************************************************************
class Faculty extends Person {
    private Integer salary;
    public Faculty(Integer facultyYearBorn) {
        super(facultyYearBorn);
        this.salary = 80000;
    }

    @Override
    public String toString() {
        return "Faculty Member is " + getAge_years() + " years old! and is paid: " + getSalary();
    }

    public Integer getSalary() { return salary; }
}

// *****************************************************************************
public class Main {

    public static void main(String[] args) {
        long millis=System.currentTimeMillis();
        System.out.println("Millis from system time: " + millis);
        System.out.println();

        Person p = new Person(1985);
        System.out.println("Person's age: " + p.getAge_years());
        Person p1980 = new Person(1980);

        Student s1990 = new Student(1760);
        System.out.println(s1990);

        Student s1980 = new Student(1980);
        System.out.println(s1980);

        Faculty f1970 = new Faculty(1970);
        System.out.println(f1970);
        System.out.println("Faculty f1970 is paid $" + f1970.getSalary() + " per year");

        // ** Parent class collection demonstration
        System.out.println("\n\n*******************************************\n\n");

        ArrayList<Person> everyone = new ArrayList<>();
        everyone.add(p);
        everyone.add(p1980);
        everyone.add(s1990);
        everyone.add(s1980);
        everyone.add(f1970);

        for(Person currP : everyone ) {
            System.out.println(currP);
        }

    }
}


// *********************************************************************************
// Ad Hoc Polymorphism

class Sum {

    // Overloaded sum(). This sum takes two int parameters
    public int sum(int x, int y)
    {
        return (x + y);
    }

    // Overloaded sum(). This sum takes three int parameters
    public int sum(int x, int y, int z)
    {
        return (x + y + z);
    }

    // Overloaded sum(). This sum takes two double parameters
    public double sum(double x, double y)
    {
        return (x + y);
    }

    public static void main(String args[])
    {
        Sum s = new Sum();
        System.out.println(s.sum(10, 20));
        System.out.println(s.sum(10, 20, 30));
        System.out.println(s.sum(10.5, 20.5));
    }
}


// **********************************************************************
// Parametric Polymorphism - Generics / Templating

class Box<T> {
    // T stands for "Type" -- but any string of characters is valid
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    @Override
    public String toString() {
        return "My value is: " + this.get();
    }

    public static void main(String args[]) {
        Box<Integer> box1 = new Box<>();
        box1.set(20);
        System.out.println(box1);

        Box<String> box2 = new Box<>();
        box2.set("I'm a box of String!");
        System.out.println(box2);

    }
}


// ***************************************************************
abstract class Vehicle {
    abstract Integer getCost();
}

abstract class Car extends Vehicle {
    abstract void drive();
}

class AstonMartin extends Car {
    public Integer getCost() {
        return 100000;
    }

    public void drive() {
        System.out.println("Vroom! Vroom!");
    }
}
