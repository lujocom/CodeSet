package com.channelsoft.codeset.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2015年09月25日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class HttpClientUtilsTest {
    protected transient final static Log logger = LogFactory.getLog(HttpClientUtilsTest.class);

    @Test
    public void downLoadImageByImageURL() {
        String url = "http://image.baidu.com/data/imgs?pn=0&rn=18&col=%E5%A3%81%E7%BA%B8&tag=%E5%85%A8%E9%83%A8&tag3=&width=1280&height=800&ic=0&ie=utf8&oe=utf-8&image_id=&fr=channel&p=channel&from=1&app=img.browse.channel.wallpaper&t=0.4825903191231191";
        JSONObject jsonObject = HttpClientUtils.getJSONObject(url, null, HttpGet.METHOD_NAME);
        List<String> imgURL = Lists.newArrayList();
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("imgs"));
        for (Object data : jsonArray) {
            imgURL.add((String) JSONObject.fromObject(data).get("downloadUrl"));
        }
        logger.debug("img size : " + imgURL.size());
        String path = "/Users/luohui/Pictures/download/";
        for (String urlStr : imgURL) {
            logger.debug(urlStr);

            downloadImg(urlStr, path);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        /*for (int i = 0; i < imgURL.size(); i ++){
            logger.debug(imgURL.get(i));
            *//*if (i % 3 == 1){
                executorService.execute(new DownLoad(imgURL.get(i), path));
            }else if (i % 3 ==2){
                executorService.execute(new DownLoad(imgURL.get(i), path));
            }else {
                executorService.execute(new DownLoad(imgURL.get(i), path));
            }*//*

            if(i % 2 == 1){
                new DownLoad(imgURL.get(i), path).run();
            }else{
                new DownLoad(imgURL.get(i), path).run();
            }
        }*/
    }

    public class DownLoad implements Runnable{
        private String urlStr;
        private String path;
        public DownLoad(String urlStr, String path){
            this.path = path;
            this.urlStr = urlStr;
        }

        @Override
        public void run() {
            logger.debug("download thread is running : " + urlStr);
            downloadImg(urlStr, path);
        }
    }


    public static void downloadImg(String url, String path) {
        if(StringUtils.isBlank(url)){
            return ;
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDownLoadImg() {
        try {
            HttpResponse response = HttpClientUtils.getResponse("http://b.hiphotos.baidu.com/image/w%3D230/sign=ca80bc927af0f736d8fe4b023a57b382/6f061d950a7b02081a10b50c60d9f2d3562cc806.jpg", null, HttpGet.METHOD_NAME);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity.isStreaming()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/luohui/Pictures/download/6f061d950a7b02081a10b50c60d9f2d3562cc806.jpg"));
                    entity.writeTo(fileOutputStream);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScradCard(){
        String urlSc = "http://localhost:8903/helpdesk/microweb/queryGameDetails.action";
        String urlTu = "http://localhost:8903/helpdesk/microweb/queryGameDetails.action";

        String entId = "1433487834831";

        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("entId", entId);
        parameter.put("wapId", "4e4d851c8abb48abad2dfbab40d7e79b");

        JSONObject jsonObject = HttpClientUtils.getJSONObject(urlTu, parameter, HttpPost.METHOD_NAME);
        logger.debug(jsonObject.toString());
        JSONObject wapTemp = jsonObject.getJSONObject("wap");
        JSONObject activityTemp = jsonObject.getJSONObject("activity");
        JSONObject companyTemp = jsonObject.getJSONObject("company");
        JSONObject defaultGameResource = jsonObject.getJSONObject("defaulGameResource");
        JSONObject useStartTime = activityTemp.getJSONObject("useStartTime");
        /*Date data = new Date( useStartTime.getLong("time"))  ;

        logger.debug("time : "  + DateFormatUtils.format(useStartTime.getLong("time"), "yyyy-MM-dd"));*/

        String prizeSq = defaultGameResource.getString("prizeSequence");
        logger.debug(prizeSq);
        JSONArray jsonArray = JSONArray.fromObject(prizeSq);
        for (int i = 0; i < jsonArray.size(); i++) {
            logger.debug(jsonArray.getJSONObject(i).getInt("prizeLevel"));
        }
       /* logger.debug("******************************************");
        parameter.put("wapId", "d31ecdb9a443412e874269d24b11e5c9");
        JSONObject jsonObjectNew = HttpClientUtils.getJSONObject(urlSc, parameter, HttpPost.METHOD_NAME);
        logger.debug(jsonObjectNew.toString());*/
    }

    @Test
    public void getUUID(){
       logger.debug(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    @Test
    public void getProductDetail(){
        String urlTu = "http://localhost:8903/helpdesk/mw/getProductDetails.action";
        String entId = "1433487834831";

        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("entId", entId);
        parameter.put("wapId", "ea559cd8964d4adcb2e614c40b3dbddc");

        JSONObject jsonObject = HttpClientUtils.getJSONObject(urlTu, parameter, HttpPost.METHOD_NAME);
        logger.debug("product -- " + jsonObject.toString());
        jsonObject = jsonObject.getJSONObject("wap");
        String createTime = jsonObject.getString("createTime");
        logger.debug(JSONUtils.isString(jsonObject.get("createTime")));
//        logger.debug(jsonObject.getString("createTime"));
        try {
            Date date = FastDateFormat.getInstance("yyyy-MM-dd hh:MM:ss").parse(createTime);
            logger.debug(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void getCusTplDetail(){
        String urlTu = "http://localhost:8903/helpdesk/sycnHistory/couponInfo_getPrivilegeDetail.action";
        String entId = "1433487834831";

        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("entId", entId);
        parameter.put("wapId", "95e4c0bfcea344e09f955e23b9402bba");

        JSONObject jsonObject = HttpClientUtils.getJSONObject(urlTu, parameter, HttpPost.METHOD_NAME);
        logger.debug("cusTpl -- " + jsonObject.toString());
        jsonObject = jsonObject.getJSONObject("wap");
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        logger.debug(jsonArray);

    }
    @Test
    public void getCouponDetail(){
        String urlTu = "http://localhost:8903/helpdesk/sycnHistory/couponInfo_getPrivilegeDetail.action";
        String entId = "1433487834831";

        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("entId", entId);
        parameter.put("wapId", "7fcd9f361f894e329dc996ef5100fa79");

        JSONObject jsonObject = HttpClientUtils.getJSONObject(urlTu, parameter, HttpPost.METHOD_NAME);
        logger.debug("cusTpl -- " + jsonObject.toString());
        jsonObject = jsonObject.getJSONObject("activity");
        logger.debug(jsonObject);

    }

    @Test
    public void generateProductResource(){
        String urlTu = "http://localhost:8899/syncData/generateProductResource.shtml";
        String entId = "1433487834831";

        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("entId", entId);
        parameter.put("couponId", "e06b36cf158e4718b6e2f1757a9be4f2");

        JSONObject jsonObject = HttpClientUtils.getJSONObject(urlTu, parameter, HttpPost.METHOD_NAME);
        logger.debug("cusTpl -- " + jsonObject.toString());
        jsonObject = jsonObject.getJSONObject("activity");
        logger.debug(jsonObject);

    }

    @Test
    public void testAddMerchant(){
        String urlTu = "http://localhost:14000/ordering/merchant/addMerchantTableInfo.action";

        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("merchantId", "6a1326c86aa0417c9dba9180f20c76c8");
        parameter.put("tableType", "测试-数字");
        parameter.put("tableNumbers", "1号桌,2号桌,3号桌,4号桌,5号桌,6号桌");

        JSONObject jsonObject = HttpClientUtils.getJSONObject(urlTu, parameter, HttpPost.METHOD_NAME, "gbk");
        logger.debug("cusTpl -- " + jsonObject.toString());
    }

}
