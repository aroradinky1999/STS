package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
    //single row
	List<Product> findBypname(String pname);
	
	//using partial word get full details
	List<Product> findBypnameLike(String pname);
	
	//named parameters
	@Query("From Product  where pid>= :min and pid<= :max")
	List<Product> fetchProductBypIdRange(int min,int max);
	
	//positional param
	@Query("From Product  where pid>= ?1 and pid<= ?2")
	List<Product> findProductBypIdRange(int min,int max);
	
	//specific coloumn
	@Query("select pname from Product  where pid>= ?1 and pid<= ?2")
	List<String> findProductNameById(int min,int max);
	
    
	//All the products greater then the price mentioned in url
	@Query("select p from Product p where p.price > :price")
	public List<Product> getProductByPrice(@Param("price") float price);
	
	//Arrange the products in desc order of names
	@Query("From Product  where pname in(:name1,:name2,:name3) order by pname desc")
	List<Product> fetchByname(String name1,String name2,String name3);
	
	//single row specific coloumn
	@Query("select pname,price from Product  where pname =:pname")
	Object findProductPartialDataByName(String pname);
	
	//max price
	@Query("select max(price) from Product")
	public float fetchMaxPrice();
	
	@Query("select min(price),avg(price),count(*),sum(price) from Product")
	public Object fetchAggregateData();
	
	
	
	
	
	
	
	
	
	
}
