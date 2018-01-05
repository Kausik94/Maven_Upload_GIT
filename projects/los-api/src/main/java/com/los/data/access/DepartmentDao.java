package com.los.data.access;

import com.los.entity.Department;

import java.util.List;

/**
 * Created by nuwantha on 12/15/16.
 */
public interface DepartmentDao {
    List<Department> getAllDepartment();
    Department getDepartment(int depId);
}
