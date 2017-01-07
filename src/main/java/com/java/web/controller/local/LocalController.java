package com.java.web.controller.local;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by devin on 2016/12/30.
 */
@RestController
@RequestMapping(value = "/local")
public class LocalController {

    @RequestMapping(value = "/test")
    public String local(HttpServletRequest request){
        RequestContext requestContext = new RequestContext(request);
        LocaleContext localeContext = () -> requestContext.getLocale();
        return String.format("local %s, timezone %s", requestContext.getLocale(), requestContext.getTimeZone());
    }

}
