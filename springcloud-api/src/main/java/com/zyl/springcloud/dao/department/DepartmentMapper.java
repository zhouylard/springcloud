package com.zyl.springcloud.dao.department;

import com.zyl.springcloud.dao.base.BaseDao;
import com.zyl.springcloud.entity.department.Department;

import java.util.List;

public interface DepartmentMapper extends BaseDao {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> queryPage();
}