package com.wjb.eRestruant;

import com.wjb.eRestruant.common.Constant;
import com.wjb.eRestruant.entity.Euser;
import com.wjb.eRestruant.exception.UserLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");
        HttpSession session = request.getSession();
        Euser current_user = (Euser)session.getAttribute(Constant.CURRENT_USER);
        if(current_user==null){
            log.info("user==null");
            throw new UserLoginException();
//            return false;
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return true;
    }

}
