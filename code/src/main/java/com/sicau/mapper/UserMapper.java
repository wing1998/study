package com.sicau.mapper;

import com.sicau.pojo.UOrder;
import com.sicau.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    UOrder getUserDataByUName(@Param("uName") String uName);
    long getUIdByUName(@Param("uName") String uName);
    List<User> getUserByAnnotation(@Param("uName") String uName);
    User getUserByResultMap(@Param("uId") int uId);
}
