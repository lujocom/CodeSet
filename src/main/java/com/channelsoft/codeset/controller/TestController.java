package com.channelsoft.codeset.controller;

import com.channelsoft.codeset.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <dl>
 * <dt>CodeSer_001</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2015年11月01日</dd>
 * </dl>
 *
 * @author LuoHui
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/page")
    public String testPage(){
        return "test.html";
    }

    @RequestMapping("/page2")
    public ModelAndView testPage2(){
        testService.testPrint();
        return new ModelAndView("test");
    }
}
