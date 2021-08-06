package cn.xh.dao;

import cn.xh.pojo.Account;

public interface IAccountDao {
    Account findAccountByName(String name);
    void updateAccount(Account account);
}
