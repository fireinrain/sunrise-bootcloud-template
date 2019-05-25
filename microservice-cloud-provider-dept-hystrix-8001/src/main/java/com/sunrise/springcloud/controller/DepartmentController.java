package com.sunrise.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunrise.springcloud.entities.Department;
import com.sunrise.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @date: 2019/5/24 20:28
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //服务发现
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Department department) {
        return departmentService.add(department);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hystrixFallBackProcessGet")  //该方法调用失败后会自动启动hystrixFallBackProcessGet这个方法
    public Department get(@PathVariable("id") Long id) {
        Department department = departmentService.get(id);
        if (null == department) {
            throw new RuntimeException("id: " + id + "不存在记录");
        }
        return department;
    }

    public Department hystrixFallBackProcessGet(@PathVariable("id") Long id) {
        return new Department()
                .setDeptNo(id)
                .setDeptName("id: " + id + "该id无记录，不在数据库").setDbSource("@hystrixFallBackProcessGet，请及时检查服务");
    }

    public List<Department> hystrixFallBackProcessList() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department()
                .setDeptNo((long)-1)
                .setDeptName("该列表，不在数据库").setDbSource("@hystrixFallBackProcessGet，请及时检查服务"));
        return departments;

    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    //只有被注解了@HystrixCommand 才能被hystrix dashboard 监控到
    @HystrixCommand(fallbackMethod = "hystrixFallBackProcessList")
    public List<Department> list() {
        return departmentService.list();
    }


    //服务发现
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICE-CLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

}
