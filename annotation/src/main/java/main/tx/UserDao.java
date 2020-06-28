package main.tx;/*
@author : Administrator
@create : 2020-06-2020/6/28-22:15

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate  jdbcTemplate;


    public  int add(){
        String sql="INSERT INTO tbl_user (`name`,`age`) VALUES(?,?)";
        String substring = UUID.randomUUID().toString().substring(0, 4);
        int update = jdbcTemplate.update(sql, substring, 18);
        System.out.println("插入成功");

        return update;
    }

}
