package com.zyl.springcloud.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyl.springcloud.entity.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumer/departments")
public class DepartmentController {

//    public static final String SPRINGCLOUD_DEPT_PROVIDER_URL = "http://192.168.101.90:8001";
    // 使用ribbon实现负载均衡的时候，服务名称不能用下划线，换成中划线。
    public static final String SPRINGCLOUD_DEPT_PROVIDER_URL = "http://springcloud-dept-provider";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity queryPage(){
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(SPRINGCLOUD_DEPT_PROVIDER_URL + "/provider/departments/", List.class);
        return responseEntity;
    }

    @GetMapping("/{id}")
    // 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand(fallbackMethod)标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "getError")
    public ResponseEntity get(@PathVariable("id") Long id){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        ResponseEntity<Department> responseEntity = restTemplate.getForEntity(SPRINGCLOUD_DEPT_PROVIDER_URL + "/provider/departments/" + id, Department.class);
        if(responseEntity.getBody() == null){
            throw new RuntimeException("没有查到。。。该部门");
        }
        return responseEntity;
    }


    public ResponseEntity getError(@PathVariable("id") Long id){
        Department department = new Department();
        department.setId(id).setDepartmentName("没有查到该部门").setSource("no datasource --> hystrix_error");

        ResponseEntity<Department> responseEntity = new ResponseEntity<Department>(department, HttpStatus.OK);

        return responseEntity;
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(SPRINGCLOUD_DEPT_PROVIDER_URL + "/provider/departments/discovery",Object.class);
    }

}
