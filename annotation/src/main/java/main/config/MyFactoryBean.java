package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/16-21:26

*/

import main.entity.Person;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Person> {
    public Person getObject() throws Exception {
        return new Person(3, "factoryBeanPerson");
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
