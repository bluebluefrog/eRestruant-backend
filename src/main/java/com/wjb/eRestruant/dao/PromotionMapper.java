package com.wjb.eRestruant.dao;

import com.wjb.eRestruant.entity.Promotion;

public interface PromotionMapper {
    int deleteByPrimaryKey(Integer promotionId);

    int insert(Promotion record);

    int insertSelective(Promotion record);

    Promotion selectByPrimaryKey(Integer promotionId);

    int updateByPrimaryKeySelective(Promotion record);

    int updateByPrimaryKey(Promotion record);
}