package com.selfstudy.codeset.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.Date;

/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2016年01月13日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class IDUtilTest {
    protected transient final static Log logger = LogFactory.getLog(IDUtilTest.class);

    @Test
    public void testCreatId(){
        String id = IDUtils.createTimeId();
        logger.debug(id + ":l:" + id.length());
    }

    @Test
    public void testDate(){
        Date date = new Date();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug(System.currentTimeMillis() - date.getTime());
    }




}
