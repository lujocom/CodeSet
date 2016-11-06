package com.selfstudy.codeset.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class HttpClientUtilsTest2 {
    protected transient final static Log logger = LogFactory.getLog(HttpClientUtilsTest2.class);

   /* @Test
    public void testGetReposeByGet2() {

        String path = "/Users/luohui/Pictures/download/";

        try {

            NodeList nodeList = ParserHTMLUtil.createParserHtmlUtil()
                    .getHtml("http://cl.czca.biz/htm_data/16/1511/1701120.html", "utf-8")
                    .createParser()
                    .createNodeFilter("input src=")
                    .getNodeListByFilter();
            for (Node node : nodeList.toNodeArray()) {
                if (node instanceof InputTag) {
                    InputTag inputTag = (InputTag) node;
                    String url = inputTag.getAttribute("src");
                    if (url.contains("jpg") && !url.contains(".jpg")){
                        url = url + ".jpg";
                    }
                    DownImageUtils.downloadImg(url, path);
                }
            }

        } catch (ParserException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @Test
    public void testGetReposeByGet3() {

        String path = "/Users/luohui/Pictures/download/";

        try {

            NodeList nodeList = ParserHTMLUtil.createParserHtmlUtil()
                    .getHtml("http://cl.czca.biz/htm_data/16/1511/1701120.html", "utf-8")
                    .createParser()
                    .createNodeFilter("input src=")
                    .getNodeListByFilter();
            List<String> imgeUrl = Lists.newArrayList();
            for (Node node : nodeList.toNodeArray()) {
                if (node instanceof InputTag) {
                    InputTag inputTag = (InputTag) node;
                    String url = inputTag.getAttribute("src");
                    if (url.contains("jpg") && !url.contains(".jpg")){
                        url = url + ".jpg";
                    }
                    imgeUrl.add(url);
                }
            }
            DownImageUtils.downloadImgs(imgeUrl, path);

        } catch (ParserException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    private void processMyNodes(Node node) {
        logger.debug(node.toString());


    }*/

}
