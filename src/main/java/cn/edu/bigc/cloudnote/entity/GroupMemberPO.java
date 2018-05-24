package cn.edu.bigc.cloudnote.entity;

public class GroupMemberPO {
    private Integer groupMemberId;

    private Integer groupId;

    private Integer userId;

    public GroupMemberPO() {
    }

    public GroupMemberPO(Integer groupMemberId, Integer groupId, Integer userId) {
        this.groupMemberId = groupMemberId;
        this.groupId = groupId;
        this.userId = userId;
    }

    public Integer getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(Integer groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
