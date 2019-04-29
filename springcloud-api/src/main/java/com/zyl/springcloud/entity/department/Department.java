package com.zyl.springcloud.entity.department;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Department {
    private Long id;

    private String departmentName;

    private String source;

}