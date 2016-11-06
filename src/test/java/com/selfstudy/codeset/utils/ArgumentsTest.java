package com.selfstudy.codeset.utils;

import org.junit.Test;

/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2016年04月13日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class ArgumentsTest {

    @Test
    public void testArgument(){
        Peerson p1 = new Peerson();

        Peerson p2 = p1;

        p1 = new Peerson();
        setPersonName(p1);
        setPersonName(p2);
        System.out.println(p1.userName);
        System.out.println(p2.userName);
        setNewPersonName(p1);
        System.out.println(p1.userName);

    }

    public void setPersonName(Peerson peerson){
        peerson.userName = "zhangsan";
    }
    public void setNewPersonName(Peerson peerson){
        peerson.userName = "liser";
        peerson = new Peerson();
        peerson.userName = "wangwu";
    }

}

class Peerson {

    public String userName;


}