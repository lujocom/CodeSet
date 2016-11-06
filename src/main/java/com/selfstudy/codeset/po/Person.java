package com.selfstudy.codeset.po;

/**
 * <dl>
 * <dt>gradle-web</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2015年12月17日</dd>
 * </dl>
 *
 * @author LuoHui
 */
public class Person {

    private String id;

    private String userName;

    private int old;

    public Person(String userName, int old) {
        this.userName = userName;
        this.old = old;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", old=" + old +
                '}';
    }
}
