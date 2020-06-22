package com.sicau.mapper;

import com.sicau.pojo.UOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UOrderMapper {
    UOrder getOrderByUId(@Param("uId") long uId);
}
