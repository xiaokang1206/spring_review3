package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("AccountService")
@Transactional(isolation = Isolation.DEFAULT)//配置在类上代表类中方法，都进行事务控制
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Transactional(isolation = Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly = false)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
       // int i = 1/0;
        accountDao.in(inMan,money);
    }
}
