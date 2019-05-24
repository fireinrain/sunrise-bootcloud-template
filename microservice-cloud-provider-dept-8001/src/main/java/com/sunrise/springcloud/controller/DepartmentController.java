package com.sunrise.springcloud.controller;

import com.sunrise.springcloud.entities.Department;
import com.sunrise.springcloud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
    public Department get(@PathVariable("id") Long id) {
        return departmentService.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Department> list() {
        return departmentService.list();
    }

    //服务发现
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
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
