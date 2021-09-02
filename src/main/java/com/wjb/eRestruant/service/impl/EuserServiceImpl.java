package com.wjb.eRestruant.service.impl;

import com.wjb.eRestruant.dao.EuserMapper;
import com.wjb.eRestruant.entity.Euser;
import com.wjb.eRestruant.enums.ResponseEnum;
import com.wjb.eRestruant.service.EuserService;
import com.wjb.eRestruant.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class EuserServiceImpl implements EuserService {

    @Autowired
    public EuserMapper euserMapper;

    @Override
    public ResponseVo register(Euser euser) {
        Euser currentUser = euserMapper.selectByUsername(euser.getUsername());
        if (currentUser != null) {
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }

        String afterMd5 =DigestUtils.md5DigestAsHex(euser.getPassword().getBytes(StandardCharsets.UTF_8));
        euser.setPassword(afterMd5);
        int count = euserMapper.insertSelective(euser);
        if (count == 0) {
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo login(String username,String password) {
        Euser currentUser = euserMapper.selectByUsername(username);
        if (currentUser == null) {
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        String afterMd5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!currentUser.getPassword().equals(afterMd5)) {
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        currentUser.setPassword("");
        return ResponseVo.success(currentUser);
    }
}
