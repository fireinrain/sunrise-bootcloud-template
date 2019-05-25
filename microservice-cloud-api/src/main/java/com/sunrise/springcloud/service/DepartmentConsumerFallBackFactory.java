package com.sunrise.springcloud.service;

import com.sunrise.springcloud.entities.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @date: 2019/5/25 20:54
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@Component
public class DepartmentConsumerFallBackFactory implements FallbackFactory<DepartmentClientService> {
    @Override
    public DepartmentClientService create(Throwable throwable) {
        return new DepartmentClientService() {
            @Override
            public boolean add(Department department) {
                return false;
            }

            @Override
            public Department get(Long id) {
                return new Department().setDeptNo(id)
                        .setDeptName("id: "+id+"服务暂时不可用")
                        .setDbSource("@DepartmentConsumerFallBackFactory 为你做了降级处理");
            }

            @Override
            public List<Department> list() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
