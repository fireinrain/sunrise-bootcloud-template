package com.sunrise.springcloud.service;

import com.sunrise.springcloud.entities.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description:
 * @date: 2019/5/25 16:22
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@FeignClient(value = "MICROSERVICE-CLOUD-DEPT",fallbackFactory = DepartmentConsumerFallBackFactory.class)
public interface DepartmentClientService {
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean add(Department department);

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    Department get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<Department> list();

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery();

}
