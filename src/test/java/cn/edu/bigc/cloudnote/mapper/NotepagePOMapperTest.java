package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.NotepagePO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotepagePOMapperTest {
    @Autowired
    NotepagePOMapper mapper;

    @Test
    public void select() {
        NotepagePO po = mapper.select(1);
        System.out.println(po);
    }

    @Test
    public void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        mapper.insert(new NotepagePO(null, 2, 2, "2048-01-23", "今天...", null, null, null, null));
    }

    @Test
    public void update() {
        mapper.update(new NotepagePO(1, 2, 2, "2048-01-23", "Roy, Richeal", null, null, null, null));
    }
}