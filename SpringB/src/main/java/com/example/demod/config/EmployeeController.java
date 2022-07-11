package com.example.demod.config;

import com.example.demod.dao.DepartmentDao;
import com.example.demod.dao.EmployeeDao;
import com.example.demod.pojo.Department;
import com.example.demod.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/emp")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @RequestMapping(value = "/empadd")
    public String add(Model model){
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping(value = "/empadd")
    public String addEmp(Employee employee){
        System.out.println("WAW"+employee);
        employeeDao.save(employee);//调用底层业务添加员工信息
        //添加的操作
        return "redirect:/emp";
    }

    @RequestMapping(value = "/emp/{id}")
    public String getUpdate(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.getemployeeid(id);
        System.out.println(employee.getDepartment().getDepartment());
        Department department = departmentDao.getid(id);
        model.addAttribute("emp",employee);
        model.addAttribute("department",department);
        return "emp/update";
    }
    //修改信息
    @PostMapping(value = "/updateEmp")
    public String emUpdate(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emp";
    }

//    删除信息
    @RequestMapping("/dele/{id}")
    public String dele(@PathVariable("id")Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emp";
    }
}
