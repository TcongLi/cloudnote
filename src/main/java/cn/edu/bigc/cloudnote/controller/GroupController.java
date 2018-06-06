package cn.edu.bigc.cloudnote.controller;

import cn.edu.bigc.cloudnote.model.GroupPO;
import cn.edu.bigc.cloudnote.model.UserPO;
import cn.edu.bigc.cloudnote.service.GroupService;
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
    public void joinGroup(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
        groupService.joinGroup(userId, groupId);
    }

    @PutMapping("/exit")
    public void exitGroup(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
        groupService.exitGroup(userId, groupId);
    }

    @PutMapping("/dismiss")
    public void dissmissGroup(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId) {
        groupService.dissmissGroup(userId, groupId);
    }

    @PutMapping("/share")
    public void shareNotepage(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId, @RequestParam("notepageId") Integer notepageId) {
        groupService.shareNotepage(userId, groupId, notepageId);
    }

    @PutMapping("/revoke")
    public void revokeNotepage(@RequestParam("userId") Integer userId, @RequestParam("groupId") Integer groupId, @RequestParam("notepageId") Integer notepageId) {
        groupService.revokeNotepage(userId, groupId, notepageId);
    }
}
