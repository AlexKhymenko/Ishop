package com.ishop.controller;

import com.ishop.entity.Employee;
import com.ishop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by alexkhymenko on 3/29/15.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        return new ModelAndView("employeeForm");
    }
    @RequestMapping("editEmployee")
    public ModelAndView editEmployee(@RequestParam long id, @ModelAttribute Employee employee) {
        employee = employeeService.getEmployee(id);
        return new ModelAndView("employeeForm", "employeeObject", employee);
    }
    @RequestMapping("saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        if(employee.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:getAllEmployees");
    }
    @RequestMapping("deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam long id) {
        employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:getAllEmployees");
    }
    @RequestMapping(value = {"getAllEmployees", "/"})
    public ModelAndView getAllEmployees() {
        List employeeList = employeeService.getAllEmployees();
        return new ModelAndView("employeeList", "employeeList", employeeList);
    }
}
