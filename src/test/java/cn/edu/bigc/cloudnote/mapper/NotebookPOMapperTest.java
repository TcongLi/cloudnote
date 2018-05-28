package cn.edu.bigc.cloudnote.mapper;

import cn.edu.bigc.cloudnote.model.NotebookPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static org.junit.Assert.*;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NotebookPOMapperTest {
    @Autowired
    NotebookPOMapper mapper;

    @Test
    public void select() {
        NotebookPO po = mapper.select(2);
        System.out.println(po);
    }

    @Test
    public void selectAll() {
        mapper.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        mapper.insert(new NotebookPO(null, 3, "学习笔记", "有机化学", null, true, null, null));
    }

    @Test
    public void update() {
        mapper.update(new NotebookPO(3, null, null,  "大学物理", null, false, null,Instant.now()));
    }
}