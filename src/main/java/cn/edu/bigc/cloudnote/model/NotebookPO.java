package cn.edu.bigc.cloudnote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class NotebookPO {
    private Integer notebookId;

    private Integer ownerId;

    private String notebookName;

    private String notebookDesc;

    private Boolean deleted;

    private Boolean stared;

    private Instant createdAt;

    private Instant updatedAt;
}
