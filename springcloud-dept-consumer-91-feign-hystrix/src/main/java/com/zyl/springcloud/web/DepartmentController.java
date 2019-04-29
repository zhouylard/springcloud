package com.zyl.springcloud.web;

import com.zyl.springcloud.entity.department.Department;
import com.zyl.springcloud.service.DepartmentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer/departments")
public class DepartmentController {

    @Autowired
    private DepartmentClientService departmentClientService;

    @GetMapping
    public List<Department> queryPage(){
        return departmentClientService.queryPage();
    }


    @GetMapping("/{id}")
    public Department get(@PathVariable("id") Long id){
        Department department = departmentClientService.get(id);
        return department;
    }

    @PostMapping
    public void add(@RequestBody Department department){
        departmentClientService.add(department);
    }

    @PutMapping("/{id}")
    public void update(Department department){
        departmentClientService.update(department);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return departmentClientService.discovery();
    }


}
