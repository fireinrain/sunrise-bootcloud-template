package com.sunrise.springcloud.controller;

import com.sunrise.springcloud.entities.Department;
import com.sunrise.springcloud.service.DepartmentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @date: 2019/5/24 21:56
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@RestController
public class DepartmentControllerConsumer {


    @Autowired
    private DepartmentClientService departmentClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Department department) {
        return departmentClientService.add(department);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Department get(@PathVariable("id") Long id) {
        return departmentClientService.get(id);
    }

    @SuppressWarnings(value = "unchecked") //返回的不带泛型，但是我们声明了，所以压制一下警告
    @RequestMapping(value = "/consumer/dept/list")
    public List<Department> list() {
        return departmentClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return departmentClientService.discovery();
    }
}
