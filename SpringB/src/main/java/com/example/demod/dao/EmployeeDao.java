package com.example.demod.dao;

import com.example.demod.pojo.Department;
import com.example.demod.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
    //初始化数据
    private static Map<Integer, Employee> employeeMap=null;

    @Autowired
    private DepartmentDao departmentDao;

    //员工有所属的部门
    static {//模拟数据库
        employeeMap=new HashMap<Integer,Employee>();//创建一个部门表
        employeeMap.put(1001,new Employee(1001,"AA","2773503370@qq.com",1,new Department(1001,"教学部")));
        employeeMap.put(1002,new Employee(1002,"BB","2187653075@qq.com",0,new Department(1002,"市场部")));
        employeeMap.put(1003,new Employee(1003,"CC","1472583698@qq.com",1,new Department(1003,"人事部")));
        employeeMap.put(1004,new Employee(1004,"DD","7894561230@qq.com",0,new Department(1004,"技术部")));
        employeeMap.put(1005,new Employee(1005,"EE","2456765684@qq.com",1,new Department(1005,"运维部")));
    }

    //主键自增
    private static Integer intid=1006;
    //添加员工信息
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(intid++);
        }
        employee.setDepartment(departmentDao.getid(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }

    //查询全部信息
    public Collection<Employee> getAll(){
        return employeeMap.values();
    }
    //通过id查询信息
    public Employee getemployeeid(Integer intid){
        return employeeMap.get(intid);
    }
    //删除信息
    public void delete(Integer intid){
        employeeMap.remove(intid);
    }
}
