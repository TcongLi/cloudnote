package cn.edu.bigc.cloudnote.entity;

import java.time.Instant;

public class NotebookPO {
    private Integer notebookId;

    private Integer ownerId;

    private String notebookName;

    private String notebookDesc;

    private Integer deleted;

    private Integer stared;

    private Instant createdAt;

    private Instant updatedAt;

    public NotebookPO() {
    }

    public NotebookPO(Integer notebookId, Integer ownerId, String notebookName, String notebookDesc, Integer deleted, Integer stared, Instant createdAt, Instant updatedAt) {
        this.notebookId = notebookId;
        this.ownerId = ownerId;
        this.notebookName = notebookName;
        this.notebookDesc = notebookDesc;
        this.deleted = deleted;
        this.stared = stared;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getNotebookId() {
        return notebookId;
    }

    public void setNotebookId(Integer notebookId) {
        this.notebookId = notebookId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public String getNotebookDesc() {
        return notebookDesc;
    }

    public void setNotebookDesc(String notebookDesc) {
        this.notebookDesc = notebookDesc;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getStared() {
        return stared;
    }

    public void setStared(Integer stared) {
        this.stared = stared;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
