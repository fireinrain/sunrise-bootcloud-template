package com.sunrise.springcloud.dao;

import com.sunrise.springcloud.entities.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @date: 2019/5/24 18:51
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@Mapper
public interface DepartmentDao {
    boolean addDept(Department department);

    Department findById(Long id);

    List<Department> findAll();
}
