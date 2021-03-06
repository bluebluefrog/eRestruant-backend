package com.wjb.eRestruant.dao;

import com.wjb.eRestruant.entity.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer foodId);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}