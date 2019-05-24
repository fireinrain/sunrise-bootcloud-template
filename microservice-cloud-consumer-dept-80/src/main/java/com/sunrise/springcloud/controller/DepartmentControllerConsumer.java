package com.sunrise.springcloud.controller;

import com.sunrise.springcloud.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @description:
 * @date: 2019/5/24 21:56
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@RestController
public class DepartmentControllerConsumer {

    private static final String REST_URL_PREFIX = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Department department) {
        return restTemplate
                .postForObject(REST_URL_PREFIX + "/dept/add", department, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Department get(@PathVariable("id") Long id) {
        return restTemplate
                .getForObject(REST_URL_PREFIX + "/dept/get/" + id, Department.class);
    }

    @SuppressWarnings(value = "unchecked") //返回的不带泛型，但是我们声明了，所以压制一下警告
    @RequestMapping(value = "/consumer/dept/list")
    public List<Department> list() {
        return restTemplate
                .getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
}
