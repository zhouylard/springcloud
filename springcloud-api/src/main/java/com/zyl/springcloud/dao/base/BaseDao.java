package com.zyl.springcloud.dao.base;

/**
 * <p>Title: BaseDao</p>
 * <p>Description: 基础dao接口，定义单表的增删该查方法</p>
 *
 */
public interface BaseDao {
	
	int deleteByPrimaryKey(Long id);

    int insert(Object record);

    int insertSelective(Object record);

    Object selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(Object record);
}
