package com.neoteric.db.databaseconnection;

import com.neoteric.db.EmployeeService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class EmployeeDBService {


    public static Function<ResultSet, List<EmployeeBuilder>> employeeexatractor = (rs) -> {
        List<EmployeeBuilder> employeeList = new ArrayList<>();

  try {
      while (rs.next()) {
          String employeeid = rs.getString("employeeid");
          String name = rs.getString("name");
          String designation = rs.getString("designation");
          int salary = rs.getInt("salary");

          EmployeeBuilder e =  EmployeeBuilder.build().
                  setname(name)
                  .setEmployeeid(employeeid)
                  .setdesignation(designation)
                  .setsalary(salary);
           employeeList.add(e);

      }
  }catch ( Exception e){
      System.out.println("  Exception Occured " +e);

  }
 return employeeList;
    };

    public  List<EmployeeBuilder> employeeBuilderlist() {
        List<EmployeeBuilder> employeeBuilder = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world",
                    "root", "Chandu@0210");
            Statement st = con.createStatement();
            st.execute(" select * from world.employee ");
            ResultSet rs = st.executeQuery("select * from world.employee");


           employeeBuilder = employeeexatractor.apply(rs);

            for (int i = 0; i < employeeBuilder.size(); i++) {
                EmployeeBuilder builder = employeeBuilder.get(i);

                System.out.println("name:  " + builder.getName() +
                        "  employee ID:  " + builder.getEmployeeid() +
                        " designation:     " + builder.getDesignation() +
                        "salary:  " + builder.getSalary());
            }

        } catch (Exception e) {
            System.out.println(" Exception  " + e);

        }
        return employeeBuilder;
    }



    public static void main(String[] args) {


    }
}
