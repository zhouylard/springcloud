package com.zyl.springcloud.service.base;


import com.zyl.springcloud.util.exception.ServiceException;

/**
 * <p>Title: BaseService</p>
 * <p>Description: Service基础接口，定义单表的增删该查方法</p>
 * @param <M> 表对应的实体
 * @param <T> 表对应的mapper接口（xxMapper.xml中的命名空间）
 */
public interface BaseService<M,T> {
	
	/**
	 * @Description: 保存、更新
	 * @param JPA实体对象   
	 * @return M  
	 * @throws 数据库操作异常
	 */
    M save(M m) throws ServiceException;
    /**
	 * @Description: 更新
	 * @param 实体对象   
	 * @return M  
	 * @throws 数据库操作异常
	 */
    M update(M m) throws ServiceException;
    
	/**
	 * @Description: 单表实体查询
	 * @param 主键Id   
	 * @return 查询实体  
	 * @throws 数据库操作异常
	 */
    M get(Long id) throws ServiceException;
    
	/**
	 * @Description: 单表实体删除
	 * @param 主键Id   
	 * @return void  
	 * @throws 数据库操作异常
	 */
    void deleteById(Long id) throws ServiceException;
    
	
}
