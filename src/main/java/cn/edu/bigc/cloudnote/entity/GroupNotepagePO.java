package cn.edu.bigc.cloudnote.entity;

public class GroupNotepagePO {
    private Integer groupNotepageId;

    private Integer groupId;

    private Integer notepageId;

    public GroupNotepagePO() {
    }

    public GroupNotepagePO(Integer groupNotepageId, Integer groupId, Integer notepageId) {
        this.groupNotepageId = groupNotepageId;
        this.groupId = groupId;
        this.notepageId = notepageId;
    }

    public Integer getGroupNotepageId() {
        return groupNotepageId;
    }

    public void setGroupNotepageId(Integer groupNotepageId) {
        this.groupNotepageId = groupNotepageId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getNotepageId() {
        return notepageId;
    }

    public void setNotepageId(Integer notepageId) {
        this.notepageId = notepageId;
    }
}
