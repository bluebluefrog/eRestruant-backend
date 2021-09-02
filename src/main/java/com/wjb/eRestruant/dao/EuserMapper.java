package com.wjb.eRestruant.dao;

import com.wjb.eRestruant.entity.Euser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EuserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Euser record);

    int insertSelective(Euser record);

    Euser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Euser record);

    int updateByPrimaryKey(Euser record);

    Euser selectByUsername(@Param("username") String username);
}