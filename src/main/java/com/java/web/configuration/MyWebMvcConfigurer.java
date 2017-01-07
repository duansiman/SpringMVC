package com.java.web.configuration;

import com.java.web.controller.async.CallableInterceptor;
import com.java.web.controller.async.DeferredInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * Created by devin on 2016/12/30.
 */
//@Configuration
//@EnableWebMvc
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.registerCallableInterceptors(new CallableInterceptor());
        configurer.registerDeferredResultInterceptors(new DeferredInterceptor());
    }
}
