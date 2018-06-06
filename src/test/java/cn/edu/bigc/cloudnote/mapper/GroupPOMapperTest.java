package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.GroupPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupPOMapperTest {
    @Autowired
    GroupPOMapper mapper;

    @Test
    public void select() {
        GroupPO po = mapper.select(1);
        System.out.println(po);
    }

    @Test
    public void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        mapper.insert(new GroupPO(null, 2, "OverPower", "科研项目小组"));
    }

    @Test
    public void update() {
        mapper.update(new GroupPO(1, 3, "OverPower", "科研项目小组"));
    }
}