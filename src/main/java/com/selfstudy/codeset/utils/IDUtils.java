package com.selfstudy.codeset.utils;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.time.DateFormatUtils;

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
public class IDUtils {
    protected transient final static Log logger = LogFactory.getLog(IDUtils.class);

    /**
     *  2016011353487000
     *  格式为yyyyMMdd+(小时 分 秒)的毫秒数
     * @return
     */
    public static String createTimeId() {
        return (DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMdd")
                + RandomUtils.nextLong()).substring(0,20);
    }
}
