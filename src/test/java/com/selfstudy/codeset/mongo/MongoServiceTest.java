package com.selfstudy.codeset.mongo;

import com.selfstudy.codeset.base.BaseJunit4ServiceTest;
import com.selfstudy.codeset.po.Person;
import com.selfstudy.codeset.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
public class MongoServiceTest extends BaseJunit4ServiceTest {

    @Autowired
    public PersonService personService;

    @Test
    public void testSavePerson() {
        Person person = new Person("zhangsan", 18);
        person = personService.savePerson(person);
        logger.debug("person : " + person.getId());
    }


}
