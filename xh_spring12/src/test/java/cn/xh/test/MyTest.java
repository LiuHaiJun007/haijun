package cn.xh.test;

import cn.xh.config.springConfig;
import cn.xh.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class MyTest {
    @Autowired
    private IAccountService accountService;
    @Test
    public void test(){
        accountService.transfer("aaa","bbb",500);
        System.out.println("转账完毕");
    }

}
