package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.model.GroupPO;
import cn.edu.bigc.cloudnote.service.GroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupServiceImplTest {
    @Autowired
    GroupService service;

    @Test
    public void getGroup() {
        GroupPO group = service.getGroup(1);
        assertNotNull(group);
        System.out.println(group);
    }

    @Test
    public void getAllGroupMembers() {
        service.getAllGroupMembers(1).forEach(System.out::println);
    }

    @Test
    public void getAllGroupsJoined() {
        service.getAllGroupsJoined(2).forEach(System.out::println);
    }

    @Test
    public void getAllGroupsCreated() {
        service.getAllGroupsCreated(2).forEach(System.out::println);
    }

    @Test
    public void createGroup() {
        service.createGroup(new GroupPO(null, 5, "书法小组", "大家一起练习书法"));
    }

    @Test
    public void joinGroup() {
        service.joinGroup(2, 1);
    }

    @Test
    public void dissmissGroup() {
        service.dissmissGroup(5, 2);
    }

    @Test
    public void exitGroup() {
        service.exitGroup(2, 2);
    }

    @Test
    public void shareNotepage() {
        service.shareNotepage(2, 3, 1);
    }

    @Test
    public void revokeNotepage() {
        service.revokeNotepage(2, 3, 1);
    }
}