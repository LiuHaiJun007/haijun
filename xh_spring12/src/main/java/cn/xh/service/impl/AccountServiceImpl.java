package cn.xh.service.impl;

import cn.xh.dao.IAccountDao;
import cn.xh.pojo.Account;
import cn.xh.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional(propagation= Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Transactional(propagation=Propagation.REQUIRED,readOnly = false)
    @Override
    public void transfer(String sourceAccount, String targetAccount, float money) {
        Account source= accountDao.findAccountByName(sourceAccount);
        source.setMoney(source.getMoney()-money);
        accountDao.updateAccount(source);

        int i=1/0;

        Account target=accountDao.findAccountByName(targetAccount);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(target);
    }
}
