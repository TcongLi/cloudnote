package cn.edu.bigc.cloudnote.entity;

public class GroupPO {
    private Integer groupId;

    private Integer groupOwnerId;

    private String groupName;

    private String groupDesc;

    public GroupPO() {
    }

    public GroupPO(Integer groupId, Integer groupOwnerId, String groupName, String groupDesc) {
        this.groupId = groupId;
        this.groupOwnerId = groupOwnerId;
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupOwnerId() {
        return groupOwnerId;
    }

    public void setGroupOwnerId(Integer groupOwnerId) {
        this.groupOwnerId = groupOwnerId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }
}
