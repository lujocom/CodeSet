package com.channelsoft.codeset.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2015年09月23日</dd>
 * </dl>
 *
 * @author LuoHui
 */
@Service("redisService")
public class RedisTemplateUtils {

    @Autowired
    private RedisTemplate<String, String> template;

    public void setValue(String key, String value){
        template.opsForValue().set(key, value);
    }


    public String getValue(String key){
        return template.opsForValue().get(key);
    }


}
