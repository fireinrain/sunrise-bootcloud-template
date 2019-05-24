package com.sunrise.springcloud.service;

import com.sunrise.springcloud.entities.Department;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @date: 2019/5/24 20:23
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public interface DepartmentService {

    boolean add(Department department);

    Department get(Long id);

    List<Department> list();
}
