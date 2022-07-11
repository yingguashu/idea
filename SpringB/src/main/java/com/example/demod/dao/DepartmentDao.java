package com.example.demod.dao;

import com.example.demod.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门Dao
@Repository
public class DepartmentDao {
    //初始化数据
    private static Map<Integer, Department> departmentMap=null;

    static {//模拟数据库
        departmentMap=new HashMap<Integer,Department>();//创建一个部门表
        departmentMap.put(1001,new Department(1001,"教学部"));
        departmentMap.put(1002,new Department(1002,"市场部"));
        departmentMap.put(1003,new Department(1003,"人事部"));
        departmentMap.put(1004,new Department(1004,"技术部"));
        departmentMap.put(1005,new Department(1005,"运营部"));
    }

    //获取所有部门信息
    public Collection<Department> getDepartment(){
        return departmentMap.values();
    }
    //通过id获取部门信息
    public Department getid(Integer id){
        return departmentMap.get(id);
    }
}
