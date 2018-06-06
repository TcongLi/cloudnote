package cn.edu.bigc.cloudnote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data @NoArgsConstructor @AllArgsConstructor
public class NotepagePO {
    private Integer notepageId;

    private Integer notebookId;

    private Integer ownerId;

    private String title;

    private String content;

    private Boolean deleted;

    private Boolean stared;

    private Instant createdAt;

    private Instant updatedAt;
}
