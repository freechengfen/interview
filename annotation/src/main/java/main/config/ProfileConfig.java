package main.config;/*
@author : Administrator
@create : 2020-06-2020/6/23-23:17

profile  不同的环境配置不同的数据库

可以使用 Dspring.profile.active=test 指定profile

*/


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:/db.properties")
public class ProfileConfig implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.driverClass}")
    private String driverClass;

    private StringValueResolver resolve;


    @Profile("test")
    @Bean("testDataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
         return  comboPooledDataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public ComboPooledDataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        String resolveDriver = this.resolve.resolveStringValue("${db.driverClass}");
        comboPooledDataSource.setDriverClass(resolveDriver);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        return  comboPooledDataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public ComboPooledDataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
        return  comboPooledDataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
            this.resolve  = stringValueResolver;
    }
}
