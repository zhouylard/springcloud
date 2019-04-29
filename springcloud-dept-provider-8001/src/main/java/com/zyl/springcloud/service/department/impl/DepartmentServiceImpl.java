package com.zyl.springcloud.service.department.impl;

import com.zyl.springcloud.dao.department.DepartmentMapper;
import com.zyl.springcloud.entity.department.Department;
import com.zyl.springcloud.service.base.impl.BaseServiceImpl;
import com.zyl.springcloud.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, DepartmentMapper> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> queryPage() {
        return departmentMapper.queryPage();
    }
}
