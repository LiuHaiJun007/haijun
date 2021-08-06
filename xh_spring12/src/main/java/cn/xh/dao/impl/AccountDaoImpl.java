package cn.xh.dao.impl;

import cn.xh.dao.IAccountDao;
import cn.xh.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account findAccountByName(String name) {

        List<Account> list= jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set money=? where name=?",account.getMoney(),account.getName());
    }
}
