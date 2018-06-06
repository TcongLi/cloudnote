package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.GroupNotepagePO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupNotepagePOMapperTest {
    @Autowired
    GroupNotepagePOMapper mapper;

    @Test
    public void select() {
        GroupNotepagePO po = mapper.select(1);
        System.out.println(po);
    }

    @Test
    public void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        mapper.insert(new GroupNotepagePO(null, 1, 1));
    }

    @Test
    public void update() {
    }
}