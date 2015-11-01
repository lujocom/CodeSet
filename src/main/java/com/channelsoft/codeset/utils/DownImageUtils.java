package com.channelsoft.codeset.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
public class DownImageUtils {
    protected transient final static Log logger = LogFactory.getLog(DownImageUtils.class);

    public static void downloadImg(String url, String path) {
        if (StringUtils.isBlank(url)) {
            return;
        }
        String fileName = url.substring(url.lastIndexOf("/"));
        try {
            HttpResponse response = HttpClientUtils.getResponse(url, null, HttpGet.METHOD_NAME);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity.isStreaming()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(path + fileName));
                    entity.writeTo(fileOutputStream);
                }
            } else {
                logger.debug("img download failed, url : " + url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
