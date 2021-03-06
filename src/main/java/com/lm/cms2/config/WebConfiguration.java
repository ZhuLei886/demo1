package com.lm.cms2.config;

import com.lm.cms2.interceptor.ArticleClickInterceptor;
import com.lm.cms2.interceptor.LoginStateInterceptor;
import com.lm.cms2.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tuzhenyu on 17-7-20.
 * @author tuzhenyu
 */
@Component
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private PassportInterceptor passportInterceptor;
    @Autowired
    private ArticleClickInterceptor articleClickInterceptor;
    @Autowired
    private LoginStateInterceptor loginStateInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(articleClickInterceptor).addPathPatterns("/article/*");
        registry.addInterceptor(loginStateInterceptor).addPathPatterns("/note");
        super.addInterceptors(registry);
    }
}
