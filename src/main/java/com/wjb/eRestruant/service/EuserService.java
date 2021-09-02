package com.wjb.eRestruant.service;

import com.wjb.eRestruant.entity.Euser;
import com.wjb.eRestruant.vo.ResponseVo;

public interface EuserService {
    public ResponseVo register(Euser euser);

    public ResponseVo login(String username,String password);
}
