package com.wjb.eRestruant.dao;

import com.wjb.eRestruant.entity.BookingFood;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface BookingFoodMapper {
    int deleteByPrimaryKey(Integer bookingFoodId);

    int insert(BookingFood record);

    int insertSelective(BookingFood record);

    BookingFood selectByPrimaryKey(Integer bookingFoodId);

    int updateByPrimaryKeySelective(BookingFood record);

    int updateByPrimaryKey(BookingFood record);
}