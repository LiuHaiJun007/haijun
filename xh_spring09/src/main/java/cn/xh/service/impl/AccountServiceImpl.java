package cn.xh.service.impl;

import cn.xh.dao.IAccountDao;
import cn.xh.pojo.Account;
import cn.xh.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Override
    public void transfer(String sourceAccount, String targetAccount, float money) {
        //转出
        Account source = accountDao.findAccountByName(sourceAccount);
        source.setMoney(source.getMoney()-money);
        accountDao.updateAccount(source);
//        int i=1/0;
        //转入
        Account target = accountDao.findAccountByName(targetAccount);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(target);

    }
}
