package com.sunrise.springcloud.service.impl;

import com.sunrise.springcloud.dao.DepartmentDao;
import com.sunrise.springcloud.entities.Department;
import com.sunrise.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @date: 2019/5/24 20:26
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao dao;

    @Override
    public boolean add(Department department) {
        return dao.addDept(department);
    }

    @Override
    public Department get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Department> list() {
        return dao.findAll();
    }
}
