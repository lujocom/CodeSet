package com.selfstudy.codeset.service;

import com.selfstudy.codeset.dao.PersonRepository;
import com.selfstudy.codeset.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person savePerson(Person person){
        return personRepository.save(person);
    }


}
