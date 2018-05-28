package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.UserTypePO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTypePOMapperTest {
    @Autowired
    UserTypePOMapper mapper;

    @Test
    public void select() {
        UserTypePO po = mapper.select(1);
        System.out.println(po);
    }

    @Test
    public void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        UserTypePO po = new UserTypePO(null, "002", "黄金会员", "最多只能创建 50 条笔记", 50);
        mapper.insert(po);
        System.out.println("id: " + po.getTypeId());
    }

    @Test
    public void update() {
        UserTypePO po = new UserTypePO(4, null, null, "最多只能创建 60 条笔记", 60);
        mapper.update(po);
    }

}