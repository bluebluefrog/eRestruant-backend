package com.wjb.eRestruant.dao;

import com.wjb.eRestruant.entity.Euser;

public interface EuserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(Euser record);

    int insertSelective(Euser record);

    Euser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(Euser record);

    int updateByPrimaryKey(Euser record);
}