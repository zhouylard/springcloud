package com.zyl.springcloud.service.base.impl;

import com.zyl.springcloud.dao.base.BaseDao;
import com.zyl.springcloud.service.base.BaseService;
import com.zyl.springcloud.util.GenericsUtils;
import com.zyl.springcloud.util.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>Title: BaseServiceImpl</p>
 * <p>Description: Service基础实现类，实现单表的增删该查</p>
 * @param <M> 表对应的实体
 * @param <T> 表对应的mapper接口（xxMapper.xml中的命名空间）
 */
@Slf4j
@SuppressWarnings("unchecked")
@Transactional(rollbackFor = Exception.class)
public class BaseServiceImpl<M,T> implements BaseService<M, T> {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	/**
	 * @Description: 保存
	 * @param 实体对象   
	 * @return void  
	 * @throws ServiceException
	 */
    public M save(M m) throws ServiceException {
    	try {
			
			BaseDao daoImpl = (BaseDao) sessionTemplate.getMapper(GenericsUtils.getSuperClassGenricType(getClass(), 1));
    		daoImpl.insertSelective(m);
    		return m;
		} catch (Exception e) {
			throw serviceExp(e);
		}
    	
    }
    
    /**
	 * @Description: 单表实体更新
	 * @param 主键Id   
	 * @return 更新实体  
	 * @throws ServiceException
	 */
    public M update(M m) throws ServiceException{
    	try {
			
    		BaseDao daoImpl = (BaseDao) sessionTemplate.getMapper(GenericsUtils.getSuperClassGenricType(getClass(), 1));
    		daoImpl.updateByPrimaryKeySelective(m);
    		return m;
		} catch (Exception e) {
			throw serviceExp(e);
		}
    }
    
	/**
	 * @Description: 单表实体查询
	 * @param 主键Id   
	 * @return 查询实体  
	 * @throws ServiceException
	 */
    public M get(Long id) throws ServiceException {
    	try {
			
    		BaseDao daoImpl = (BaseDao) sessionTemplate.getMapper(GenericsUtils.getSuperClassGenricType(getClass(), 1));
    		return (M) daoImpl.selectByPrimaryKey(id);
    		
		} catch (Exception e) {
			throw serviceExp(e);
		}
    }
    
	/**
	 * @Description: 单表实体删除
	 * @param id 主键id
	 * @return void  
	 * @throws ServiceException
	 */
    public void deleteById(Long id) throws ServiceException {
    	try {
			
    		BaseDao daoImpl = (BaseDao) sessionTemplate.getMapper(GenericsUtils.getSuperClassGenricType(getClass(), 1));
    		daoImpl.deleteByPrimaryKey(id);
    		
		} catch (Exception e) {
			throw serviceExp(e);
		}
    }
    
    protected ServiceException serviceExp(Exception e)  {
		
		 log.error("mybatis service error : {}",this.getClass().getName(),e);
	
		 return new ServiceException("mybatis异常：" + e.getMessage());
	}


}
