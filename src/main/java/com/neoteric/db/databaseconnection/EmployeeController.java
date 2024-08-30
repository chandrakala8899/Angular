package com.neoteric.db.databaseconnection;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {


    @GetMapping(value = "/getEmpList")

    public List<EmployeeBuilder> getEmpList(){
        EmployeeDBService service = new EmployeeDBService();
        return  service.employeeBuilderlist();
    }


}
