package com.selfstudy.codeset.service;

import com.selfstudy.codeset.base.BaseJunit4ServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

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
public class TestServiceTest2 extends BaseJunit4ServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void testPrint(){
        testService.testPrint();
    }


    public void testUUID(){
        UUID.randomUUID();
    }

}
