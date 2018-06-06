package cn.edu.bigc.cloudnote.controller;

import cn.edu.bigc.cloudnote.model.GroupPO;
import cn.edu.bigc.cloudnote.model.UserPO;
import cn.edu.bigc.cloudnote.service.GroupService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/{groupId}")
    public GroupPO getGroup(@PathVariable Integer groupId) {
        return groupService.getGroup(groupId);
    }

    @GetMapping("/created/{userId}")
    public List<GroupPO> getAllGroupsCreated(@PathVariable Integer userId) {
        return groupService.getAllGroupsCreated(userId);
    }

    @GetMapping("/joined/{userId}")
    public List<GroupPO> getAllGroupsJoined(@PathVariable Integer userId) {
        return groupService.getAllGroupsJoined(userId);
    }
    @GetMapping("/members/{groupId}")
    public List<UserPO> getAllGroupMembers(@PathVariable Integer groupId) {
        return groupService.getAllGroupMembers(groupId);
    }

    @PostMapping("/")
    public Integer createGroup(@RequestBody GroupPO po) {
        return groupService.createGroup(po);
    }
    @PutMapping("/join")
    public void joinGroup(@Param("userId") Integer userId, @Param("groupId") Integer groupId) {
        groupService.joinGroup(userId, groupId);
    }

    @PutMapping("/exit")
    public void exitGroup(@Param("userId") Integer userId, @Param("groupId") Integer groupId) {
        groupService.exitGroup(userId, groupId);
    }

    @PutMapping("/dismiss")
    public void dissmissGroup(@Param("userId") Integer userId, @Param("groupId") Integer groupId) {
        groupService.dissmissGroup(userId, groupId);
    }

    @PutMapping("/share")
    public void shareNotepage(@Param("userId") Integer userId, @Param("groupId") Integer groupId, @Param("notepageId") Integer notepageId) {
        groupService.shareNotepage(userId, groupId, notepageId);
    }

    @PutMapping("/revoke")
    public void revokeNotepage(@Param("userId") Integer userId, @Param("groupId") Integer groupId, @Param("notepageId") Integer notepageId) {
        groupService.revokeNotepage(userId, groupId, notepageId);
    }
}
