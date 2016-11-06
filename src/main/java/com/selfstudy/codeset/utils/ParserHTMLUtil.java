package com.selfstudy.codeset.utils;

import org.apache.commons.lang3.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 *
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
public class ParserHTMLUtil {
    /*protected transient final static Log logger = LogFactory.getLog(ParserHTMLUtil.class);
    private Parser parser;

    private NodeFilter nodeFilter;

    private String html;

    private String encode;

    public static ParserHTMLUtil createParserHtmlUtil() {
        return new ParserHTMLUtil();
    }

    public ParserHTMLUtil getHtml(String url, String encode) throws IOException {
        HttpResponse response = HttpClientUtils.getResponse(url, null, HttpGet.METHOD_NAME);
        if (response.getStatusLine().getStatusCode() == 200) {
            this.html = EntityUtils.toString(response.getEntity(), encode);
            this.encode = encode;
        } else {
            this.html = "";
            this.encode = encode;
            logger.debug("获取页面失败!!");
        }
        return this;
    }

    public ParserHTMLUtil createParser() {
        if (StringUtils.isNotBlank(html)) {
            this.parser = Parser.createParser(html, encode);
        } else {
            this.parser = null;
        }
        return this;
    }

    public ParserHTMLUtil createParser(String html, String encode) {
        if (StringUtils.isNotBlank(html)) {
            this.parser = Parser.createParser(html, encode);
        } else {
            this.parser = null;
        }
        return this;
    }

    public ParserHTMLUtil createNodeFilter(final String filterStr) {
        this.nodeFilter = new NodeFilter() {
            @Override
            public boolean accept(Node node) {
                if (node.getText().startsWith(filterStr)) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return this;
    }

    public NodeList getNodeListByFilter() throws ParserException {
        if (ObjectUtils.notEqual(this.parser, null)) {
            return this.parser.parse(this.nodeFilter);
        } else {
            return null;
        }
    }
*/
}
