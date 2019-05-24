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
    private Integer id;
    private String deptName;
    private String db_source;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public static void main(String[] args) {
        Department department = new Department().setDeptName("RD")
                .setId(1)
                .setDb_source("DB001");

    }

}
