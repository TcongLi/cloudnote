package cn.edu.bigc.cloudnote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by TiancongLi(tiancong.li@hotmail.com) on 2018/5/28.
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class GroupPO {
    private Integer groupId;

    private Integer ownerId;

    private String groupName;

    private String groupDesc;
}