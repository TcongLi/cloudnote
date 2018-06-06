package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.GroupMemberPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupMemberPOMapperTest {
    @Autowired
    GroupMemberPOMapper mapper;

    @Test
    public void select() {
        GroupMemberPO po = mapper.select(1);
        System.out.println(po);
    }

    @Test
    public void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        mapper.insert(new GroupMemberPO(null, 1, 2));
    }

    @Test
    public void update() {
        mapper.update(new GroupMemberPO(1, 1, 3));
    }
}