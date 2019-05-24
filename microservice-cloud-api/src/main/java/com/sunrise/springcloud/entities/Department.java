package com.sunrise.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description:
 * @date: 2019/5/24 16:43
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Department implements Serializable {
    private Long deptNo;
    private String deptName;
    private String dbSource;

    public Department(String deptName) {
        this.deptName = deptName;
    }

}
