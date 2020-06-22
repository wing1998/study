package com.sicau.mapper;

import com.sicau.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    List<Product> getProductsByOId(@Param("oId") long oId);
}
