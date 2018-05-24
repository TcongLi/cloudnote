package cn.edu.bigc.cloudnote.entity;

public class UserTypePO {
    private Integer userTypeId;

    private String userTypeCode;

    private String userTypeName;

    private String userTypeDesc;

    private String userTypeMaxNote;

    public UserTypePO() {
    }

    public UserTypePO(Integer userTypeId, String userTypeCode, String userTypeName, String userTypeDesc, String userTypeMaxNote) {
        this.userTypeId = userTypeId;
        this.userTypeCode = userTypeCode;
        this.userTypeName = userTypeName;
        this.userTypeDesc = userTypeDesc;
        this.userTypeMaxNote = userTypeMaxNote;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserTypeDesc() {
        return userTypeDesc;
    }

    public void setUserTypeDesc(String userTypeDesc) {
        this.userTypeDesc = userTypeDesc;
    }

    public String getUserTypeMaxNote() {
        return userTypeMaxNote;
    }

    public void setUserTypeMaxNote(String userTypeMaxNote) {
        this.userTypeMaxNote = userTypeMaxNote;
    }
}
