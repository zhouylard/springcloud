package com.zyl.springcloud.service.department;

import com.zyl.springcloud.dao.department.DepartmentMapper;
import com.zyl.springcloud.entity.department.Department;
import com.zyl.springcloud.service.base.BaseService;

import java.util.List;

public interface DepartmentService extends BaseService<Department, DepartmentMapper> {

    List<Department> queryPage();

}
