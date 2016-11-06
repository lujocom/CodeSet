package com.selfstudy.codeset.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2016年02月15日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class StringTest {

    @Test
    public void testStringIntern(){
        /*String a = "abcd";
        String b = new String("abcd");
        String c = a.intern();

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);

        String f = "10";
        String e = "8.7";*/
//        System.out.println(Double.parseDouble(f));
        /*System.out.println(NumberUtils.isNumber(f));
        System.out.println(NumberUtils.toDouble(f));
        System.out.println(NumberUtils.compare(NumberUtils.toDouble(e), NumberUtils.toDouble(f)));
        Double wd = 1631.0;
        System.out.println(wd + "");
        System.out.println(wd.intValue());


        BigDecimal wq = new BigDecimal("3");

        BigDecimal er = new BigDecimal(0.80);

        wq = wq.multiply(er);

        System.out.println(wq.doubleValue());


        System.out.println(StringTest.multiplication("1", "0.4"));
        Double ddsa = 10.0;
        ddsa /= 10.0;
//        System.out.println(ddsa.toString());
        System.out.println(0 < 0);*/

        int refundMoney = 0;
        int payed = 0;
        if (refundMoney < payed){
            System.out.println("金额不合法");
        }




    }


    public  static double add(String lnum, String rnum){
        BigDecimal a = new BigDecimal(lnum);
        BigDecimal b = new BigDecimal(rnum);

        return Math.floor(a.add(b).doubleValue());
    }

    /**
     * 乘法
     * @param lnum
     * @param rnum
     * @return
     */
    public  static double multiplication(String lnum, String rnum){
        BigDecimal a = new BigDecimal(lnum);
        BigDecimal b = new BigDecimal(rnum);
        return Math.round(a.multiply(b).doubleValue());
    }

    @Test
    public void testContaine(){
        System.out.println(StringUtils.contains("sss_ss", "_"));
        System.out.println(StringUtils.contains("sss_s_s", "_"));
        System.out.println(StringUtils.containsAny("sss_ss", "_"));
        System.out.println(StringUtils.containsAny("sss_ss", "_"));
    }

    @Test
    public void testHashMap(){
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        for (String key : map.keySet()){
            System.out.println(key + ":" + map.get(key));
        }

        for (String key : map.keySet()){
            System.out.println(key + ":" + map.get(key));
        }



    }

    @Test
    public void testHUOADN(){






    }


}
