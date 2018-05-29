package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.UserPO;
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
public class UserPOMapperTest {
    @Autowired
    UserPOMapper mapper;

    @Test
    public void select() {
        UserPO po = mapper.select(2);
        System.out.println(po);
    }

    @Test
    public void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        mapper.insert(new UserPO(null, "WillyWonka", "2qe3qq3eq", 3));
    }

    @Test
    public void update() {
        mapper.update(new UserPO(2, null, "123456789", 4));
    }
}