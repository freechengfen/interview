package main.tx;/*
@author : Administrator
@create : 2020-06-2020/6/28-22:16

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private  UserDao userDao;

    @Transactional
    public int insert(){
        int add = userDao.add();
        int divide=10/0;
        return divide;
    }

}
