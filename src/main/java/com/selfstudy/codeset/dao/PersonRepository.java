package com.selfstudy.codeset.dao;

import com.selfstudy.codeset.po.Person;
import org.springframework.data.repository.CrudRepository;


/**
 * <dl>
 * <dt>CodeSet</dt>
 * <dd>Description:</dd>
 * <dd>Copyright: Copyright (C) 2015</dd>
 * <dd>Company: 北京青牛风科技有限公司</dd>
 * <dd>CreateDate: 2016年01月02日</dd>
 * </dl>
 *
 * @author LuoHui
 */
//@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {



}
