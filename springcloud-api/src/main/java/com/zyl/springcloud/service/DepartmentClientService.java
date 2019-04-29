package com.zyl.springcloud.service;

import com.zyl.springcloud.entity.department.Department;
import com.zyl.springcloud.hystrix.DepartmentClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 也可以用fallbackFactory=DepartmentClientFactory.class
@FeignClient(value = "springcloud-dept-provider",path = "/provider/departments",fallback = DepartmentClientHystrix.class)
public interface DepartmentClientService {

    @GetMapping("/{id}")
    Department get(@PathVariable("id") Long id);

    @GetMapping
    List<Department> queryPage();

    @PostMapping
    void add(@RequestBody Department department);

    @PutMapping("/{id}")
    void update(@RequestBody Department department);

    @DeleteMapping("/{id}")
    void delete(@PathVariable() Long id);

    @GetMapping("/discovery")
    Object discovery();
}
