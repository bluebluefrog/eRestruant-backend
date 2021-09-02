package com.wjb.eRestruant.dao;

import com.wjb.eRestruant.entity.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMapper {
    int deleteByPrimaryKey(Integer bookingId);

    int insert(Booking record);

    int insertSelective(Booking record);

    Booking selectByPrimaryKey(Integer bookingId);

    int updateByPrimaryKeySelective(Booking record);

    int updateByPrimaryKey(Booking record);
}