package com.lm.cms2.interceptor;


import com.lm.cms2.redis.JedisService;
import com.lm.cms2.util.RedisKeyUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by tuzhenyu on 17-7-20.
 * @author tuzhenyu
 */
@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    private JedisService jedisService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {


        String uri = httpServletRequest.getServletPath();
        String uriKey = RedisKeyUntil.getClickCountKey(uri);
        jedisService.incr(uriKey);
        return true;
    }
}
