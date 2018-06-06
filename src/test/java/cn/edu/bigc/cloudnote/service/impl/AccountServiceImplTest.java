package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.model.UserPO;
import cn.edu.bigc.cloudnote.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {
    @Autowired
    AccountService service;

    @Test
    public void signIn() {
        UserPO po0 = service.signIn("Pepe", "normalpornfornormalpeople");
        assertNotNull(po0);
        System.out.println(po0);

        UserPO po1 = service.signIn("Pepe", "normalpornfornormalpeopl");
        assertNull(po1);
    }

    @Test
    public void signUp() {
        Integer userId = service.signUp(new UserPO(null, "Pepe", "normalpornfornormalpeople", null));
        assertNotNull(userId);
    }

    @Test
    public void promote() {
        service.promote(2, 1);
    }
}