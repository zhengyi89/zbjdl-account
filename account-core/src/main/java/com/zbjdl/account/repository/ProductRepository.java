package com.zbjdl.account.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zbjdl.common.respository.mybatis.GenericRepository;
import com.zbjdl.account.model.Product;


@Repository
public interface ProductRepository extends GenericRepository {
	
	public List<Product>  selectLimitList(Product reqdto);
	public List<Product>  selectByRange(Product reqdto);
	
}
