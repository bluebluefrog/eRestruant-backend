package com.wjb.eRestruant.dao;

import com.wjb.eRestruant.entity.BookingFood;

public interface BookingFoodMapper {
    int deleteByPrimaryKey(Integer bookingFoodId);

    int insert(BookingFood record);

    int insertSelective(BookingFood record);

    BookingFood selectByPrimaryKey(Integer bookingFoodId);

    int updateByPrimaryKeySelective(BookingFood record);

    int updateByPrimaryKey(BookingFood record);
}