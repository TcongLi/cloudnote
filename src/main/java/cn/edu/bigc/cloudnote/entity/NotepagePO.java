package cn.edu.bigc.cloudnote.entity;

import java.time.Instant;

public class NotepagePO {
    private Integer notepageId;

    private Integer notebookId;

    private Integer ownerId;

    private String title;

    private String content;

    private Integer deleted;

    private Integer stared;

    private Instant createdAt;

    private Instant updatedAt;

    public NotepagePO() {
    }

    public NotepagePO(Integer notepageId, Integer notebookId, Integer ownerId, String title, String content, Integer deleted, Integer stared, Instant createdAt, Instant updatedAt) {
        this.notepageId = notepageId;
        this.notebookId = notebookId;
        this.ownerId = ownerId;
        this.title = title;
        this.content = content;
        this.deleted = deleted;
        this.stared = stared;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getNotepageId() {
        return notepageId;
    }

    public void setNotepageId(Integer notepageId) {
        this.notepageId = notepageId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
