package com.los.service;

import com.los.data.access.DepartmentDao;
import com.los.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nuwantha on 12/15/16.
 */

@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    public List<Department> getAllDepartment(){
        return departmentDao.getAllDepartment();
    }

    public Department getDepartment(int depId){
        return departmentDao.getDepartment(depId);
    }
}
