package com.zyl.springcloud.hystrix;

import com.zyl.springcloud.entity.department.Department;
import com.zyl.springcloud.service.DepartmentClientService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentClientHystrix implements DepartmentClientService {
    @Override
    public Department get(Long id) {
        return new Department().setId(id).setDepartmentName("没有找到").setSource("no source <--> hystrix");
    }

    @Override
    public List<Department> queryPage() {
        List<Department> list = new ArrayList<Department>();
        list.add(new Department().setId(1L).setDepartmentName("没有找到").setSource("no source <--> hystrix"));
        return list;
    }

    @Override
    public void add(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Object discovery() {
        return "no discovery info <--> hystrix";
    }
}
