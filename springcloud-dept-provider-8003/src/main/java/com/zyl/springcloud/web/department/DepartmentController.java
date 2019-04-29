package com.zyl.springcloud.web.department;

import com.zyl.springcloud.entity.department.Department;
import com.zyl.springcloud.service.department.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/provider/departments")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity queryPage(){
        List<Department> departments = departmentService.queryPage();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public Department get(@PathVariable("id") Long id){
        Department department = departmentService.get(id);
        return department;
    }

    @PostMapping
    public void add(Department department){
        departmentService.save(department);
    }

    @PutMapping("/{id}")
    public void update(Department department){
        departmentService.update(department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        departmentService.deleteById(id);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        System.out.println("************ services:" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-dept-provider");

        for (ServiceInstance instance : instances) {
            System.out.println("serviceId=" + instance.getServiceId() + ",host=" + instance.getHost() + ",port=" + instance.getPort() + ",uri=" + instance.getUri());
        }

        return this.discoveryClient;
    }

}
