package cn.edu.bigc.cloudnote.service.impl;

import cn.edu.bigc.cloudnote.mapper.*;
import cn.edu.bigc.cloudnote.model.*;
import cn.edu.bigc.cloudnote.service.GroupService;
import lombok.experimental.var;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {
    @Autowired
    private UserPOMapper userPOMapper;

    @Autowired
    private GroupPOMapper groupPOMapper;

    @Autowired
    private GroupMemberPOMapper groupMemberPOMapper;

    @Autowired
    private GroupNotepagePOMapper groupNotepagePOMapper;

    @Autowired
    private NotepagePOMapper notepagePOMapper;

    @Override
    public GroupPO getGroup(Integer groupId) {
        return groupPOMapper.select(groupId);
    }

    @Override
    public List<UserPO> getAllGroupMembers(Integer groupId) {
        List<Integer> usersIdList = groupMemberPOMapper.selectAll().stream()
                .filter(it -> it.getGroupId().equals(groupId))
                .map(GroupMemberPO::getUserId)
                .collect(Collectors.toList());
        if (usersIdList == null || usersIdList.size() == 0) {
            return null;
        }
        return usersIdList.stream()
                .map(userPOMapper::select)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupPO> getAllGroupsJoined(Integer userId) {
        List<Integer> groupsIdList = groupMemberPOMapper.selectAll().stream()
                .filter(it -> it.getUserId().equals(userId))
                .map(GroupMemberPO::getGroupId)
                .collect(Collectors.toList());
        if (groupsIdList == null || groupsIdList.size() == 0) {
            return null;
        }
        return groupsIdList.stream()
                .map(groupPOMapper::select)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupPO> getAllGroupsCreated(Integer userId) {
        var joinedGroups = getAllGroupsJoined(userId);
        if (joinedGroups == null || joinedGroups.size() == 0) {
            log.info("该用户 {} 未创建任何小组", userId);
            return null;
        }
        return joinedGroups.stream()
                .filter(it -> it.getOwnerId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Integer createGroup(GroupPO po) {
        groupPOMapper.insert(po);
        log.info("用户 {} 创建小组 {} 成功", po.getOwnerId(), po.getGroupId());
        return po.getGroupId();
    }

    @Override
    public void joinGroup(Integer userId, Integer groupId) {
        log.info("用户 {} 加入小组 {}", userId, groupId);
        groupMemberPOMapper.insert(new GroupMemberPO(null, groupId, userId));
    }

    @Override
    public void dissmissGroup(Integer userId, Integer groupId) {
        var group = getGroup(groupId);
        if (group == null) {
            log.warn("小组不存在");
            return;
        }
        if (!group.getOwnerId().equals(userId)) {
            log.warn("该用户不是小组创建者");
            return;
        }
        log.info("用户 {} 解散小组 {}", userId, groupId);
        groupPOMapper.delete(groupId);
    }

    @Override
    public void exitGroup(Integer userId, Integer groupId) {
        var groupMembers = groupMemberPOMapper.selectAll();
        var group = groupMembers.stream().filter(it -> it.getUserId().equals(userId)).findFirst();
        if (!group.isPresent()) {
            log.warn("用户 {} 不属于组 {}", userId, groupId);
            return;
        }
        log.info("用户 {} 退出小组 {}", userId, groupId);
        groupMemberPOMapper.delete(group.get().getId());
    }

    @Override
    public void shareNotepage(Integer userId, Integer notepageId, Integer groupId) {
        // FIXME 可能导致重复分享
        var groupMembers = groupMemberPOMapper.selectAll();
        var group = groupMembers.stream().filter(it -> it.getUserId().equals(userId)).findFirst();
        if (!group.isPresent()) {
            log.warn("用户 {} 不属于组 {}", userId, groupId);
            return;
        }
        log.info("用户 {} 将笔记页 {} 共享到小组 {}", userId, notepageId, groupId);
        groupNotepagePOMapper.insert(new GroupNotepagePO(null, groupId, notepageId));
    }

    @Override
    public void revokeNotepage(Integer userId, Integer notepageId, Integer groupId) {
        var groupMembers = groupMemberPOMapper.selectAll();
        var group = groupMembers.stream().filter(it -> it.getUserId().equals(userId)).findFirst();
        if (!group.isPresent()) {
            log.warn("用户 {} 不属于组 {}", userId, groupId);
            return;
        }
        var groupNotepages = groupNotepagePOMapper.selectAll();
        var groupNotepage = groupNotepages.stream().filter(it -> it.getGroupId().equals(groupId) && it.getNotepageId().equals(notepageId))
                .findFirst();
        if (!groupNotepage.isPresent()) {
            log.warn("笔记页 {} 不属于组 {}", notepageId, groupId);
            return;
        }
        log.info("用户 {} 将笔记页 {} 从小组 {} 取消共享", userId, notepageId, groupId);
        groupNotepagePOMapper.delete(groupNotepage.get().getId());
    }

    @Override
    public List<NotepagePO> getAllNotepages(Integer groupId) {
        var groupNotepages = groupNotepagePOMapper.selectAll();
        if (groupNotepages == null) {
            return null;
        }
        return groupNotepages.stream().filter(it -> it.getGroupId().equals(groupId))
                .map(it -> notepagePOMapper.select(it.getNotepageId()))
                .collect(Collectors.toList());
    }
}
