package com.neoteric.db.databaseconnection;

public class EmployeeBuilder {
    private  String employeeid;
    private  String name;
    private  String designation;
    private  int salary;
    public EmployeeBuilder(){

    }

    public String getEmployeeid() {
        return employeeid;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public int getSalary() {
        return salary;
    }

    public EmployeeBuilder setEmployeeid(String employeeid){
       this.employeeid =employeeid;
      return  this;
    }

    public EmployeeBuilder setname(String name){
        this.name =name;
        return  this;
    }

    public EmployeeBuilder setsalary(int salary){
        this.salary =salary;
        return  this;
    }

    public EmployeeBuilder setdesignation(String designation){
        this.designation =designation;
        return  this;
    }

    public  static EmployeeBuilder build(){
        return  new EmployeeBuilder();
    }
}
