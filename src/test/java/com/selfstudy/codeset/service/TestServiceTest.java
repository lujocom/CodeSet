package com.selfstudy.codeset.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2015年11月01日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class TestServiceTest {

    private TestService testService;

    @Before
    public void beforeTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{
                "classpath:spring/spring-service.xml"
        });
        testService = ctx.getBean(TestService.class);
    }

    @Test
    public void testPrint(){
       testService.testPrint();
    }

}
