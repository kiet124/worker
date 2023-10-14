/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author dotha
 */
public class Worker {
    private String Code;
    private String Name;
    private int Age;
    private int Salary;
    private String WorkLocation;

    public Worker() {
    }

    public Worker(String Code, String Name, int Age, int Salary, String WorkLocation) {
        this.Code = Code;
        this.Name = Name;
        this.Age = Age;
        this.Salary = Salary;
        this.WorkLocation = WorkLocation;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public String getWorkLocation() {
        return WorkLocation;
    }

    public void setWorkLocation(String WorkLocation) {
        this.WorkLocation = WorkLocation;
    }
    
}