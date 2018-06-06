package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.model.NotepagePO;
import cn.edu.bigc.cloudnote.service.NotepageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotepageServiceImplTest {
    @Autowired
    NotepageService service;

    @Test
    public void getAllNotepages() {
        service.getAllNotepages(2).forEach(System.out::println);
    }

    @Test
    public void createNotepage() {
        Integer id = service.createNotepage(new NotepagePO(null, 2, 2, "2049-01-19", "killed Roy", null, null, null, null));
        assertNotNull(id);
    }

    @Test
    public void updateNotepage() {
        NotepagePO notepage = new NotepagePO();
        notepage.setNotepageId(3);
        notepage.setStared(true);
        service.updateNotepage(notepage);
    }

    @Test
    public void deleteNotepage() {
        service.deleteNotepage(3);
    }

    @Test
    public void recoverNotepage() {
        service.recoverNotepage(3);
    }
}