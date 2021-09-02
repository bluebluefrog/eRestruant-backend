package com.wjb.eRestruant.controller;

import com.wjb.eRestruant.common.Constant;
import com.wjb.eRestruant.entity.Euser;
import com.wjb.eRestruant.enums.ResponseEnum;
import com.wjb.eRestruant.service.EuserService;
import com.wjb.eRestruant.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EuserController {

    @Autowired
    public EuserService euserService;

    @PostMapping("/user/register")
    @ResponseBody
    public ResponseVo register(@RequestBody Euser euser) {
        if(euser==null||euser.getUsername()==null){
            return ResponseVo.error(ResponseEnum.PARAM_ERROR);
        }
        euser.setRole(Constant.CUSTOMER);

        return euserService.register(euser);
    }

    @PostMapping("/user/login")
    @ResponseBody
    public ResponseVo login(@RequestParam("username")String username,@RequestParam("password")String password) {
        if (username == null || password == null) {
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return euserService.login(username,password);
    }
}
