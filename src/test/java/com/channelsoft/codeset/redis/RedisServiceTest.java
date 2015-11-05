package com.channelsoft.codeset.redis;

import com.channelsoft.codeset.base.BaseJunit4RedisTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
public class RedisServiceTest extends BaseJunit4RedisTest {



    @Autowired
    private RedisTemplateUtils redisTemplateUtils;


    @Test
    public void testRedisStringTemplate(){
        redisTemplateUtils.setValue("hello", "world");
        logger.debug(redisTemplateUtils.getValue("hello"));
    }



}
